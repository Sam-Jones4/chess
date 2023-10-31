package responses;

/**
 * Logs out the user represented by the authToken provided
 */
public class LogoutResponse
{
    /**
     * Creates a variable to store any failure messages
     */
    private String message;

    /**
     * Class constructor
     *
     * @param message sets message equal to the given message
     */
    public LogoutResponse(String message, String authToken)
    {
        this.message = message;
    }

    public LogoutResponse(String message)
    {
        this.message = message;
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
