package requests;

/**
 * Request class for login requests
 */
public class LoginRequest
{
    /**
     * Variable to hold a username
     */
    private String username;
    /**
     * Variable to hold a password
     */
    private String password;

    /**
     * Class constructor
     *
     * @param username sets username to the username
     * @param password sets password to the password
     */
    public LoginRequest(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
