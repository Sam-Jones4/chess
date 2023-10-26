package models;

/**
 * A model class for a user
 */
public class User
{
    /**
     * Creates a variable to store a username
     */
    private String username;
    /**
     * Creates a variable to store a password
     */
    private String password;
    /**
     * Creates a variable to store an email
     */
    private String email;

    /**
     * Class constructor
     *
     * @param username sets username to the username
     * @param password sets password to the password
     * @param email sets email to the email
     */
    public User(String username, String password, String email)
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
