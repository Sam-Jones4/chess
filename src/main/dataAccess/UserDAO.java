package dataAccess;

import models.Game;
import models.User;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Data access object class to store and retrieve user data
 */
public class UserDAO
{
    private Connection connection;

    /**
     * Class constructor
     *
     * @param connection
     */
    public UserDAO(Connection connection)
    {
        this.connection = connection;
    }

    /**
     * Clears all users from the database
     */
    public void clearUsers() throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("DELETE FROM User"))
        {
            preparedStatement.executeUpdate();
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }

    /**
     * Inserts a new user into the database
     *
     * @param username given username to create a new user
     * @param password given password
     * @param email given email
     * @return returns the authtoken for the new user
     */
    public void insertUser(String username, String password, String email) throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("INSERT INTO User (username, password, email) VALUES(?, ?, ?)"
                , RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);

            preparedStatement.executeUpdate();
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }

    /**
     * Finds a user in the database
     *
     * @param username user to find
     */
    public User findUser(String username) throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE username = ?"))
        {
            preparedStatement.setString(1, username);
            try (var resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    var name = resultSet.getString("username");
                    var password = resultSet.getString("password");
                    var email = resultSet.getString("email");
                    return new User(name, password, email);
                }
            }
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
        return null;
    }


}
