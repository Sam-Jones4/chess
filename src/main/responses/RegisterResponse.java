package responses;

/**
 * Registers a new user.
 */

public class RegisterResponse
{
    /**
     * Creates a variable to store a username.
     */
    private String username;
    /**
     * Creates a variable to store an authToken
     */
    private String authToken;
    /**
     * Creates a variable to store any failure messages
     */
    private String message;

    /**
     * Class constructor
     *
     * @param username sets username to given username
     * @param authToken sets authToken to given authToken
     */
    public RegisterResponse(String username, String authToken)
    {
        this.username = username;
        this.authToken = authToken;
    }

    /**
     * Another class constructor that just takes a messages
     *
     * @param message sets message to the message
     */
    public RegisterResponse(String message)
    {
        this.message = message;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
