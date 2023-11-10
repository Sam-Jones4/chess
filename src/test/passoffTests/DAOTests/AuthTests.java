package passoffTests.DAOTests;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class AuthTests
{
    @BeforeEach
    void ClearTestData() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        authDAO.clearAuthtokens();

        database.closeConnection(connection);
    }

    @Test
    void ClearAuthtokensTest()
    {

    }

    @Test
    void InsertAuthtokenPassTest()
    {

    }

    @Test
    void InsertAuthtokenFailTest()
    {

    }

    @Test
    void FindAuthtokenPassTest()
    {

    }

    @Test
    void FindAuthtokenFailTest()
    {

    }

    @Test
    void RemoveAuthtokenPassTest()
    {

    }

    @Test
    void RemoveAuthtokenFailTest()
    {

    }
}
