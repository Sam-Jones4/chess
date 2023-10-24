package requests;

/**
 * Request class for registering a new user
 */
public class RegisterRequest
{
    /**
     * Variable to hold the username
     */
    private String username;
    /**
     * Variable to hold the password
     */
    private String password;
    /**
     * Variable to hold the email
     */
    private String email;

    /**
     * Class constructor
     *
     * @param username sets username to the username
     * @param password sets password to the password
     * @param email sets email to the email
     */
    public RegisterRequest(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
