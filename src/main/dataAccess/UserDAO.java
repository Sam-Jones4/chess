package dataAccess;

import models.User;

import java.util.List;
import java.util.Map;

/**
 * Data access object class to store and retrieve user data
 */
public class UserDAO
{
    /**
     * Creates a map to store users
     */
    private static Map<String, User> userMap;

    /**
     * Clears all users from the database
     */
    private void clearUsers()
    {
        userMap.clear();
    }

    /**
     * Inserts a user into the database
     *
     * @param user user to insert
     */
    private void insertUser(User user)
    {
        userMap.put(user.getUsername(), user);
    }

    /**
     * Finds a user in the database
     *
     * @param username user to find
     */
    private User findUser(String username)
    {
        return userMap.get(username);
    }


}
