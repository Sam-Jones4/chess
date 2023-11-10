package passoffTests.DAOTests;

import dataAccess.DataAccessException;
import dataAccess.Database;
import dataAccess.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class UserTests
{
    @BeforeEach
    void ClearTestData() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        UserDAO userDAO = new UserDAO(connection);
        userDAO.clearUsers();

        database.closeConnection(connection);
    }

    @Test
    void ClearUsersTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        UserDAO userDAO = new UserDAO(connection);
        userDAO.insertUser("samuser", "password", "sam@gmail.com");

        userDAO.clearUsers();

        Assertions.assertNull(userDAO.findUser("samuser"));

        database.closeConnection(connection);
    }

    @Test
    void InsertUserPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        UserDAO userDAO = new UserDAO(connection);
        userDAO.insertUser("samuser", "password", "sam@gmail.com");

        Assertions.assertNotNull(userDAO.findUser("samuser"));

        database.closeConnection(connection);
    }

    @Test
    void InsertUserFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        UserDAO userDAO = new UserDAO(connection);
        userDAO.insertUser("samuser", "password", "sam@gmail.com");

        Assertions.assertNull(userDAO.findUser("samsuser"));

        database.closeConnection(connection);
    }

    @Test
    void FindUserPassTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        UserDAO userDAO = new UserDAO(connection);


        database.closeConnection(connection);
    }

    @Test
    void FindUserFailTest() throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        UserDAO userDAO = new UserDAO(connection);

        database.closeConnection(connection);
    }

}
