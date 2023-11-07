package dataAccess;

import models.User;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Data access object class to store and retrieve user data
 */
public class UserDAO
{
    private Connection connection;

    /**
     * Creates a map to store users
     */
    private static Map<String, User> userMap = new HashMap<>();

    /**
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
    public void clearUsers()
    {
        userMap.clear();
    }

    /**
     * Inserts a new user into the database
     *
     * @param username given username to create a new user
     * @param password given password
     * @param email given email
     * @return returns the authtoken for the new user
     */
    public void insertUser(String username, String password, String email)
    {
        User newUser = new User(username, password, email);
        userMap.put(username, newUser);
    }

    /**
     * Finds a user in the database
     *
     * @param username user to find
     */
    public User findUser(String username)
    {
        return userMap.get(username);
    }


}
