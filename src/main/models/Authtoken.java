package models;

/**
 * A model class for an authToken
 */
public class Authtoken
{
    /**
     * Creates a variable to store an authToken
     */
    private String authToken;
    /**
     * creates a variable to store a username
     */
    private String username;

    /**
     * Class constructor
     *
     * @param authToken sets authToken to the authToken
     * @param username sets username to the username
     */
    public Authtoken(String authToken, String username)
    {
        this.authToken = authToken;
        this.username = username;
    }

    public String getAuthToken()
    {
        return authToken;
    }

    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
