package responses;

/**
 * Creates a new game
 */
public class CreateGameResponse
{
    /**
     * Creates a variable to hold a gameID
     */
    private int gameID;
    /**
     * Creates a variable to hold a message
     */
    private String message;

    /**
     * Class constructor
     *
     * @param gameID sets gameID to given gameID
     * @param message sets message to given message
     */
    public CreateGameResponse(int gameID, String message)
    {
        this.gameID = gameID;
        this.message = message;
    }

    public int getGameID()
    {
        return gameID;
    }

    public void setGameID(int gameID)
    {
        this.gameID = gameID;
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
