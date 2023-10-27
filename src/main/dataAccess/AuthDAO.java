package dataAccess;

import models.Authtoken;
import java.util.Map;

/**
 * Data access object class to store and retrieve authToken data
 */
public class AuthDAO
{
    /**
     * Creates a map to hold authTokens
     */
    private static Map<String, Authtoken> authtokenMap;

    public Authtoken getAuthtoken(String token)
    {
        return authtokenMap.get(token);
    }


    /**
     * Clears authToken data
     */
    private void clearAuthtokens()
    {
        authtokenMap.clear();
    }

    /**
     * Inserts an authToken into the map
     *
     * @param authtoken given authToken to insert
     */
    private void insertAuthtoken(Authtoken authtoken)
    {
        authtokenMap.put(authtoken.getAuthToken(), authtoken);
    }

    /**
     * Finds an authtoken
     *
     * @param authtoken authToken to find
     */
    private void findAuthtoken(Authtoken authtoken)
    {

    }

    /**
     * Removes an authToken
     *
     * @param authtoken authToken to remove
     */
    private void removeAuthtoken(Authtoken authtoken)
    {
        authtokenMap.remove(authtoken.getAuthToken());
    }
}
