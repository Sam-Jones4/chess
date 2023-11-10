package passoffTests.DAOTests;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import models.Authtoken;
import org.junit.jupiter.api.Assertions;
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
    void ClearAuthtokensTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtokenOne = new Authtoken("token", "samuser");
        Authtoken authtokenTwo = new Authtoken("token2", "notsamuser");

        authDAO.insertAuthtoken(authtokenOne);
        authDAO.insertAuthtoken(authtokenTwo);

        authDAO.clearAuthtokens();

        Assertions.assertNull(authDAO.findAuthtoken("token"));
        Assertions.assertNull(authDAO.findAuthtoken("token2"));

        database.closeConnection(connection);
    }

    @Test
    void InsertAuthtokenPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("token", "samuser");

        authDAO.insertAuthtoken(authtoken);

        Assertions.assertNotNull(authDAO.findAuthtoken("token"));

        database.closeConnection(connection);
    }

    @Test
    void InsertAuthtokenFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("token", "samuser");

        authDAO.insertAuthtoken(authtoken);

        Assertions.assertThrows(DataAccessException.class, () -> authDAO.insertAuthtoken(authtoken));

        database.closeConnection(connection);
    }

    @Test
    void FindAuthtokenPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("token", "samuser");

        authDAO.insertAuthtoken(authtoken);

        Assertions.assertNotNull(authDAO.findAuthtoken("token"));

        database.closeConnection(connection);
    }

    @Test
    void FindAuthtokenFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("token", "samuser");

        authDAO.insertAuthtoken(authtoken);

        Assertions.assertNull(authDAO.findAuthtoken("nottoken"));

        database.closeConnection(connection);
    }

    @Test
    void RemoveAuthtokenPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("token", "samuser");

        authDAO.insertAuthtoken(authtoken);

        authDAO.removeAuthtoken("token");

        Assertions.assertNull(authDAO.findAuthtoken("token"));

        database.closeConnection(connection);
    }

    @Test
    void RemoveAuthtokenFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        Authtoken authtoken = new Authtoken("token", "samuser");

        authDAO.insertAuthtoken(authtoken);

        authDAO.removeAuthtoken("token2");

        Assertions.assertNotNull(authDAO.findAuthtoken("token"));

        database.closeConnection(connection);
    }
}
