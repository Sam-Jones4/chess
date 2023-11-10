package responses;

/**
 * Verifies that the specified game exists, and, if the color is specified, adds the caller as the requested color tp the game.
 * If no color is specified the user is joined as an observer.
 * This request is idempotent.
 */
public class JoinGameResponse
{
    /**
     * Creates a variable to hold a message
     */
    private String message;


    public JoinGameResponse()
    {}

    /**
     * Class constructor
     *
     * @param message sets message to given message
     */
    public JoinGameResponse(String message)
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
