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
    public void clearAuthtokens()
    {
        authtokenMap.clear();
    }

    /**
     * Inserts an authToken into the map
     *
     * @param authtoken given authToken to insert
     */
    public void insertAuthtoken(Authtoken authtoken)
    {
        authtokenMap.put(authtoken.getAuthToken(), authtoken);
    }

    /**
     * Finds an authtoken
     *
     * @param authtoken authToken to find
     */
    public Authtoken findAuthtoken(Authtoken authtoken)
    {
        return authtokenMap.get(authtoken.getAuthToken());
    }

    /**
     * Removes an authToken
     *
     * @param authtoken authToken to remove
     */
    public void removeAuthtoken(Authtoken authtoken)
    {
        authtokenMap.remove(authtoken.getAuthToken());
    }
}
