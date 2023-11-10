package responses;

/**
 * Clears the database. Removes all users, games, and authTokens.
 */
public class ClearApplicationResponse
{
    /**
     * Creates a variable to hold a message
     */
    private String message;

    /**
     * Class constructor
     *
     * @param message sets message to given message
     */
    public ClearApplicationResponse(String message)
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
