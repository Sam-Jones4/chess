package responses;

/**
 * Logs in an existing user.
 */
public class LoginResponse
{
    /**
     * Creates a variable to store the username
     */
    private String username;
    /**
     * Creates a variable to store the authToken
     */
    private String authToken;
    /**
     * Creates a variable to store any failure message
     */
    private String message;

    /**
     * Class constructor
     *
     * @param username sets the username to username
     * @param authToken sets the authToken to authToken
     */
    public LoginResponse(String username, String authToken)
    {
        this.username = username;
        this.authToken = authToken;
    }

    /**
     * Another constructor for just a message
     *
     * @param message sets message to the message
     */
    public LoginResponse(String message)
    {
        this.message = message;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
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

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
