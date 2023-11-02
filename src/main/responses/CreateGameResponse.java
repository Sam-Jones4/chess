package responses;

/**
 * Creates a new game
 */
public class CreateGameResponse
{
    /**
     * Creates a variable to hold a gameID
     */
    private Integer gameID;
    /**
     * Creates a variable to hold a message
     */
    private String message;

    /**
     * Class constructor
     *
     * @param gameID sets gameID to given gameID
     */
    public CreateGameResponse(int gameID)
    {
        this.gameID = gameID;
    }

    public CreateGameResponse(String message)
    {
        this.message = message;
    }


    public int getGameID()
    {
        return gameID;
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
