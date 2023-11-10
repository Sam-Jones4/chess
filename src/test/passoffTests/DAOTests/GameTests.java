package passoffTests.DAOTests;

import dataAccess.DataAccessException;
import dataAccess.Database;
import dataAccess.GameDAO;
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
    void ClearGamesTest()
    {

    }

    @Test
    void InsertGamePassTest()
    {

    }

    @Test
    void InsertGameFailTest()
    {

    }

    @Test
    void FindGamePassTest()
    {

    }

    @Test
    void FindGameFailTest()
    {

    }

    @Test
    void FindAllGamesPassTest()
    {

    }

    @Test
    void FindAllGamesFailTest()
    {

    }

    @Test
    void ClaimSpotPassTest()
    {

    }

    @Test
    void ClaimSpotFailTest()
    {

    }
}
