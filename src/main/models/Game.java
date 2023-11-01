package models;

/**
 * A model class for a game
 */

import chess.ChessGame;
import chess.ChessGameImpl;

public class Game
{
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
     * Creates a variable to store a gameName
     */
    private String gameName;
    /**
     * Creates an object to store a Game
     */
    private ChessGameImpl game;

    /**
     * Class constructor
     *
     * @param gameID sets gameID to the game ID
     * @param whiteUsername sets whiteUsername to white's username
     * @param blackUsername sets blackUsername to black's username
     * @param gameName sets gameName to the game name
     * @param game sets game to teh game
     */
    public Game(int gameID, String whiteUsername, String blackUsername, String gameName, ChessGameImpl game)
    {
        this.gameID = gameID;
        this.whiteUsername = whiteUsername;
        this.blackUsername = blackUsername;
        this.gameName = gameName;
        this.game = game;
    }

    public Game(int gameID, String gameName)
    {
        this.gameID = gameID;
        this.gameName = gameName;
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

    public ChessGameImpl getGame()
    {
        return game;
    }

    public void setGame(ChessGameImpl game)
    {
        this.game = game;
    }
}
