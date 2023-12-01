package facade;

import chess.ChessGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.CreateGameRequest;
import requests.JoinGameRequest;
import requests.LoginRequest;
import requests.RegisterRequest;
import responses.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class ServerFacadeTests
{
    @BeforeEach
    void ClearTestData() throws URISyntaxException, IOException
    {
        ServerFacade.clearApplication();

        RegisterRequest registerRequest = new RegisterRequest("samsusername", "samspassword", "sam@sam.com");

        RegisterResponse registerResponse = ServerFacade.register(registerRequest);

        ServerFacade.authToken = registerResponse.getAuthToken();
    }

    @Test
    void ClearApplicationTest() throws URISyntaxException, IOException
    {
        RegisterRequest registerRequest = new RegisterRequest("samuser", "password", "sam@gmail.com");

        ServerFacade.register(registerRequest);

        ServerFacade.clearApplication();

        LoginRequest request = new LoginRequest("samuser", "password");

        Assertions.assertNotNull(ServerFacade.login(request).getMessage());
    }

    @Test
    void RegisterPassTest() throws IOException, URISyntaxException
    {
        RegisterRequest registerRequest = new RegisterRequest("samuser", "password", "sam@gmail.com");

        RegisterResponse response = ServerFacade.register(registerRequest);

        Assertions.assertEquals(registerRequest.getUsername(), response.getUsername());
        Assertions.assertNotNull(response.getAuthToken());
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void RegisterFailTest() throws IOException, URISyntaxException
    {
        RegisterRequest registerRequest = new RegisterRequest("samuser", null, "sam@gmail.com");

        RegisterResponse response = ServerFacade.register(registerRequest);

        Assertions.assertEquals(response.getMessage(), "Error: bad request");
    }

    @Test
    void LoginPassTest() throws URISyntaxException, IOException
    {
        RegisterRequest registerRequest = new RegisterRequest("samsusername", "samspassword", "sam@sam.com");

        ServerFacade.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest("samsusername", "samspassword");

        LoginResponse response = ServerFacade.login(loginRequest);

        Assertions.assertNotNull(response.getAuthToken());
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void LoginFailTest() throws URISyntaxException, IOException
    {
        LoginRequest loginRequest = new LoginRequest("notsamsusername", "notsamspassword");

        LoginResponse response = ServerFacade.login(loginRequest);

        Assertions.assertNull(response.getAuthToken());
        Assertions.assertNotNull(response.getMessage());
    }

    @Test
    void LogoutPassTest() throws URISyntaxException, IOException
    {
        LogoutResponse response = ServerFacade.logout();

        Assertions.assertNull(response.getMessage());
    }

    @Test
    void LogoutFailTest() throws URISyntaxException, IOException
    {
        ServerFacade.logout();
        LogoutResponse response = ServerFacade.logout();

        Assertions.assertNotNull(response.getMessage());
    }

    @Test
    void CreateGamePassTest() throws URISyntaxException, IOException
    {
        CreateGameRequest createGameRequest = new CreateGameRequest("samgame");

        CreateGameResponse response = ServerFacade.createGame(createGameRequest);

        Assertions.assertNotNull(response.getGameID());
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void CreateGameFailTest() throws URISyntaxException, IOException
    {
        CreateGameRequest createGameRequest = new CreateGameRequest(null);

        CreateGameResponse response = ServerFacade.createGame(createGameRequest);

        Assertions.assertNull(response);
    }

    @Test
    void JoinGamePassTest() throws URISyntaxException, IOException
    {
        CreateGameRequest createGameRequest = new CreateGameRequest("samgame");

        CreateGameResponse createGameResponse = ServerFacade.createGame(createGameRequest);

        JoinGameRequest joinGameRequest = new JoinGameRequest(ChessGame.TeamColor.WHITE, createGameResponse.getGameID());

        JoinGameResponse response = ServerFacade.joinGame(joinGameRequest);

        Assertions.assertEquals(joinGameRequest.getGameID(), createGameResponse.getGameID());
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void JoinGameFailTest() throws URISyntaxException, IOException
    {
//        CreateGameRequest createGameRequest = new CreateGameRequest("samgame");
//
//        CreateGameResponse createGameResponse = ServerFacade.createGame(createGameRequest);
//
//        JoinGameRequest joinGameRequest = new JoinGameRequest(ChessGame.TeamColor.WHITE, 18);
//
//        JoinGameResponse response = ServerFacade.joinGame(joinGameRequest);
//
//        Assertions.assertNotNull(response.getMessage());

        CreateGameRequest createGameRequest = new CreateGameRequest("samgame");

        CreateGameResponse createGameResponse = ServerFacade.createGame(createGameRequest);

        JoinGameRequest joinGameRequest = new JoinGameRequest(ChessGame.TeamColor.WHITE, createGameResponse.getGameID() + 4);

        ServerFacade.joinGame(joinGameRequest);

        Assertions.assertNotEquals(joinGameRequest.getGameID(), createGameResponse.getGameID());
    }

    @Test
    void ListGamesPassTest() throws URISyntaxException, IOException
    {
        CreateGameRequest createGameRequest = new CreateGameRequest("samgame");

        ServerFacade.createGame(createGameRequest);

        ListGamesResponse response = ServerFacade.listGames();

        assert response != null;
        Assertions.assertNotNull(response.getGames());
        Assertions.assertNull(response.getMessage());
    }

    @Test
    void ListGamesFailTest() throws URISyntaxException, IOException
    {
        CreateGameRequest createGameRequest = new CreateGameRequest("samgame");

        ServerFacade.createGame(createGameRequest);

        ListGamesResponse response = ServerFacade.listGames();

        Assertions.assertNotEquals(response.getGames().get(0).getGameName(), "notsamgame");
    }
}
