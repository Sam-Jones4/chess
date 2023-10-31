package requests;

/**
 * Request class for creating a new game
 */
public class CreateGameRequest
{
    /**
     * Variable to hold the gameName
     */
    private String gameName;

    /**
     * Class constructor
     *
     * @param gameName gameName set to the game name
     */
    public CreateGameRequest(String gameName)
    {
        this.gameName = gameName;
    }

    public String getGameName()
    {
        return gameName;
    }

    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }
}
