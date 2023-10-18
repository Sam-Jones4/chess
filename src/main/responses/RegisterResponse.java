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
    private String authToken;
    private String message;

    public RegisterResponse(String username, String authToken, String message)
    {
        this.username = username;
        this.authToken = authToken;
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
