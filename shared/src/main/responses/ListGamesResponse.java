package responses;

import models.Game;

import java.util.Arrays;
import java.util.List;

/**
 * Gives a list of all the games
 */
public class ListGamesResponse
{
    /**
     * Creates a variable to store the failure message
     */
    private String message;
    /**
     * Creates a variable to store a gameID
     */

    private List<Game> games;



    public ListGamesResponse(Game[] games)
    {
        this.games = Arrays.asList(games);
    }

    public ListGamesResponse(String message)
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


    public List<Game> getGames()
    {
        return games;
    }
}
