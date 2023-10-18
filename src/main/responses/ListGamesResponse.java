package responses;

import chess.ChessGame;

import java.util.ArrayList;
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
    private int gameID;
    /**
     * Creates a variable to store white's username
     */
    private String whiteUsername;
    /**
     * Creates a variable to store black's username
     */
    private String blackUsername;
    /**
     * Creates a variable to store the gameName
     */
    private String gameName;
    /**
     * Creates a list of the games
     */
    private List<ChessGame> games;

    /**
     * Class constructor
     *
     * @param message sets message to the message
     * @param gameID sets gameID to the gameID
     * @param whiteUsername sets whiteUsername to white's username
     * @param blackUsername sets blackUsername to black's username
     * @param gameName sets gameName to the game name
     * @param games sets games to the list of games
     */
    public ListGamesResponse(String message, int gameID, String whiteUsername, String blackUsername, String gameName, List<ChessGame> games)
    {
        this.message = message;
        this.gameID = gameID;
        this.whiteUsername = whiteUsername;
        this.blackUsername = blackUsername;
        this.gameName = gameName;
        this.games = games;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
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

    public String getWhiteUsername()
    {
        return whiteUsername;
    }

    public void setWhiteUsername(String whiteUsername)
    {
        this.whiteUsername = whiteUsername;
    }

    public String getBlackUsername()
    {
        return blackUsername;
    }

    public void setBlackUsername(String blackUsername)
    {
        this.blackUsername = blackUsername;
    }

    public String getGameName()
    {
        return gameName;
    }

    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }

    public List<ChessGame> getGames()
    {
        return games;
    }

    public void setGames(List<ChessGame> games)
    {
        this.games = games;
    }
}
