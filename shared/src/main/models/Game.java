package models;

/**
 * A model class for a game
 */

import chess.ChessGameImpl;

import java.util.Objects;

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
     * @param game sets game to the game
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

    public ChessGameImpl getGame()
    {
        return game;
    }

    public void setGame(ChessGameImpl game)
    {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game1 = (Game) o;
        return gameID == game1.gameID && Objects.equals(whiteUsername, game1.whiteUsername) && Objects.equals(blackUsername, game1.blackUsername) && Objects.equals(gameName, game1.gameName) && Objects.equals(game, game1.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameID, whiteUsername, blackUsername, gameName, game);
    }
}
