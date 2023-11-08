package passoffTests.serverTests;

import chess.ChessGame;
import dataAccess.*;
import models.Authtoken;
import models.Game;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.CreateGameRequest;
import requests.JoinGameRequest;
import requests.LoginRequest;
import requests.RegisterRequest;
import responses.*;
import services.*;

import java.sql.Connection;
import java.util.ArrayList;

public class ServiceTests
{
    @BeforeEach
    void ClearTestData() throws DataAccessException {
        ClearApplicationService clearApplicationService = new ClearApplicationService();
        clearApplicationService.clearApplication();
    }


    @Test
    void RegisterPassTest() throws DataAccessException
    {
        RegisterService registerService = new RegisterService();
        RegisterRequest registerRequest = new RegisterRequest("samuser", "password", "sam@gmail.com");

        RegisterResponse response = registerService.registerUser(registerRequest);

        Assertions.assertEquals(registerRequest.getUsername(), response.getUsername());
        Assertions.assertNotNull(response.getAuthToken());
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void RegisterFailTest() throws DataAccessException
    {
        RegisterService registerService = new RegisterService();
        RegisterRequest registerRequest = new RegisterRequest("samuser", null, "sam@gmail.com");

        RegisterResponse response = registerService.registerUser(registerRequest);

        Assertions.assertEquals(response.getMessage(), "Error: bad request");
    }

    @Test
    void LogoutPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisismytoken", "samusername");
        authDAO.insertAuthtoken(authtoken);

        LogoutService logoutService = new LogoutService();
        String authToken = "thisismytoken";

        LogoutResponse response = logoutService.logout(authToken);

        Assertions.assertNull(authDAO.findAuthtoken("thisismytoken"));
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void LogoutFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisismytoken", "samusername");
        authDAO.insertAuthtoken(authtoken);

        LogoutService logoutService = new LogoutService();
        String authToken = "thisisNOTmytoken";

        LogoutResponse response = logoutService.logout(authToken);

        Assertions.assertNotNull(authDAO.findAuthtoken("thisismytoken"));
        Assertions.assertEquals(response.getMessage(), "Error: unauthorized");
    }

    @Test
    void LoginPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisismytoken", "samsusername");
        authDAO.insertAuthtoken(authtoken);

        UserDAO userDAO = new UserDAO(connection);
        userDAO.insertUser("samsusername", "samspassword", "email");

        LoginService loginService = new LoginService();
        LoginRequest loginRequest = new LoginRequest("samsusername", "samspassword");

        LoginResponse response = loginService.login(loginRequest);

        Assertions.assertEquals(loginRequest.getUsername(), authtoken.getUsername());
        Assertions.assertNotNull(authDAO.findAuthtoken("thisismytoken"));
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void LoginFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisisNOTmytoken", "samsusername");

        LoginService loginService = new LoginService();
        LoginRequest loginRequest = new LoginRequest("samsusername", "samspassword");

        LoginResponse response = loginService.login(loginRequest);

        Assertions.assertEquals(loginRequest.getUsername(), authtoken.getUsername());
        Assertions.assertEquals(response.getAuthToken(), authDAO.findAuthtoken("thisismytoken"));
        Assertions.assertEquals(response.getMessage(), "Error: unauthorized");
    }

    @Test
    void ListGamesPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisismytoken", "samsusername");
        authDAO.insertAuthtoken(authtoken);

        GameDAO gameDAO = new GameDAO(connection);
        Game game1 = new Game(1,"game1");
        Game game2 = new Game(2,"game2");
        gameDAO.insertGame(game1);
        gameDAO.insertGame(game2);
        ArrayList<Game> gameArray = new ArrayList<>();

        gameArray.add(game1);
        gameArray.add(game2);

        ListGamesService listGamesService = new ListGamesService();

        ListGamesResponse listGamesResponse = listGamesService.listGames("thisismytoken");

        Assertions.assertNotNull(authDAO.findAuthtoken("thisismytoken"));
        Assertions.assertEquals(listGamesResponse.getGames(), gameArray);
    }

    @Test
    void ListGamesFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisismytoken", "samusername");
        authDAO.insertAuthtoken(authtoken);

        GameDAO gameDAO = new GameDAO(connection);
        Game game1 = new Game(1,"game1");
        Game game2 = new Game(2,"game2");
        gameDAO.insertGame(game1);
        gameDAO.insertGame(game2);

        ListGamesService listGamesService = new ListGamesService();

        ListGamesResponse listGamesResponse = listGamesService.listGames("thisisNOTmytoken");

        Assertions.assertNull(authDAO.findAuthtoken("thisisNOTmytoken"));
        Assertions.assertEquals(listGamesResponse.getMessage(), "Error: unauthorized");
    }

    @Test
    void JoinGamePassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game1 = new Game(1,"game1");
        gameDAO.insertGame(game1);

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisismytoken", "samusername");
        authDAO.insertAuthtoken(authtoken);

        JoinGameService joinGameService = new JoinGameService();
        JoinGameRequest joinGameRequest = new JoinGameRequest(ChessGame.TeamColor.WHITE, 1);

        JoinGameResponse response = joinGameService.joinGame(joinGameRequest, "thisismytoken");

        Assertions.assertEquals("samusername", gameDAO.findGame(1).getWhiteUsername());
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void JoinGameFailTest() throws DataAccessException
    {
        JoinGameService joinGameService = new JoinGameService();
        JoinGameRequest joinGameRequest = new JoinGameRequest(ChessGame.TeamColor.WHITE, 0);

        JoinGameResponse response = joinGameService.joinGame(joinGameRequest, "thisismytoken");

        Assertions.assertEquals(response.getMessage(), "Error: bad request");
    }

    @Test
    void CreateGamePassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("thisismytoken", "samusername");
        authDAO.insertAuthtoken(authtoken);

        CreateGameService createGameService = new CreateGameService();
        CreateGameRequest createGameRequest = new CreateGameRequest("myGame");

        CreateGameResponse response = createGameService.createGame(createGameRequest, "thisismytoken");

        Assertions.assertNotNull(response.getGameID());
        Assertions.assertEquals("myGame", gameDAO.findGame(response.getGameID()).getGameName());

    }

    @Test
    void CreateGameFailTest() throws DataAccessException
    {
        CreateGameService createGameService = new CreateGameService();
        CreateGameRequest createGameRequest = new CreateGameRequest(null);

        CreateGameResponse response = createGameService.createGame(createGameRequest, "thisismytoken");

        Assertions.assertEquals(response.getMessage(), "Error: bad request");
    }

    @Test
    void ClearApplicationTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        UserDAO userDAO = new UserDAO(connection);
        userDAO.insertUser("samuser", "password", "sam@gmail.com");

        ClearApplicationService clearApplicationService = new ClearApplicationService();

        ClearApplicationResponse response = clearApplicationService.clearApplication();

        Assertions.assertNull(userDAO.findUser("samuser"));

    }


}
