package passoffTests.DAOTests;

import chess.ChessGame;
import dataAccess.DataAccessException;
import dataAccess.Database;
import dataAccess.GameDAO;
import models.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class GameTests
{
    @BeforeEach
    void ClearTestData() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        gameDAO.clearGames();

        database.closeConnection(connection);
    }

    @Test
    void ClearGamesTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game gameOne = new Game(1, "samgame");
        Game gameTwo = new Game(2, "notsamgame");

        gameDAO.insertGame(gameOne);
        gameDAO.insertGame(gameTwo);

        gameDAO.clearGames();

        Assertions.assertNull(gameDAO.findGame(1));
        Assertions.assertNull(gameDAO.findGame(2));

        database.closeConnection(connection);
    }

    @Test
    void InsertGamePassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game = new Game(1,"samgame");

        gameDAO.insertGame(game);

        Assertions.assertNotNull(gameDAO.findGame(1));

        database.closeConnection(connection);
    }

    @Test
    void InsertGameFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game = new Game(1,"samgame");

        gameDAO.insertGame(game);

        Assertions.assertThrows(DataAccessException.class, () -> gameDAO.insertGame(game));

        database.closeConnection(connection);
    }

    @Test
    void FindGamePassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game = new Game(1,"samgame");

        gameDAO.insertGame(game);

        Assertions.assertNotNull(gameDAO.findGame(1));

        database.closeConnection(connection);
    }

    @Test
    void FindGameFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game = new Game(1,"samgame");

        gameDAO.insertGame(game);

        Assertions.assertNull(gameDAO.findGame(2));

        database.closeConnection(connection);
    }

    @Test
    void FindAllGamesPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game1 = new Game(1,"game1");
        Game game2 = new Game(2,"game2");
        gameDAO.insertGame(game1);
        gameDAO.insertGame(game2);

        Assertions.assertNotNull(gameDAO.findAllGames());

        database.closeConnection(connection);
    }

    @Test
    void FindAllGamesFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game1 = new Game(1,"game1");
        Game game2 = new Game(2,"game2");
        gameDAO.insertGame(game1);
        gameDAO.insertGame(game2);

        Assertions.assertNotEquals(3,gameDAO.findAllGames().length);

        database.closeConnection(connection);
    }

    @Test
    void ClaimSpotPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game = new Game(1,"samgame");

        gameDAO.insertGame(game);

        gameDAO.claimSpot(1, "samuser", ChessGame.TeamColor.WHITE);

        Assertions.assertEquals("samuser", gameDAO.findGame(1).getWhiteUsername());

        database.closeConnection(connection);
    }

    @Test
    void ClaimSpotFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        Game game = new Game(1,"samgame");

        gameDAO.insertGame(game);

        gameDAO.claimSpot(0, "pauluser", ChessGame.TeamColor.WHITE);

        Assertions.assertNull(gameDAO.findGame(1).getWhiteUsername());

        database.closeConnection(connection);
    }
}
