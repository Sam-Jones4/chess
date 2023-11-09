package dataAccess;

import models.Authtoken;
import models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Data access object class to store and retrieve authToken data
 */
public class AuthDAO
{
    private Connection connection;

    public AuthDAO(Connection connection)
    {
        this.connection = connection;
    }

    /**
     * Clears authToken data
     */
    public void clearAuthtokens() throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("DELETE FROM Auth"))
        {
            preparedStatement.executeUpdate();
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }

    /**
     * Inserts an authToken into the map
     *
     * @param authtoken given authToken to insert
     */
    public void insertAuthtoken(Authtoken authtoken) throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("INSERT INTO Auth (authtoken, username) VALUES(?, ?)"
                , RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, authtoken.getAuthToken());
            preparedStatement.setString(2, authtoken.getUsername());

            preparedStatement.executeUpdate();
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }

    /**
     * Finds an authtoken
     *
     * @param authtoken authToken to find
     */
    public Authtoken findAuthtoken(String authtoken) throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE username = ?"))
        {
            preparedStatement.setString(1, authtoken);
            try (var resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    var token = resultSet.getString("authtoken");
                    var username = resultSet.getString("username");
                    return new Authtoken(token, username);
                }
            }
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
        return null;
    }

    /**
     * Removes an authToken
     *
     * @param authtoken authToken to remove
     */
    public void removeAuthtoken(String authtoken) throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("DELETE FROM Auth WHERE authtoken=?"))
        {
            preparedStatement.setString(1, authtoken);

            preparedStatement.executeUpdate();
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }
}
