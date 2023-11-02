package requests;

import chess.ChessGame;

/**
 * Request class for joining a game
 */
public class JoinGameRequest
{
    /**
     * Variable to hold the player's color
     */
    private ChessGame.TeamColor playerColor;
    /**
     * Variable to hold the game ID
     */
    private int gameID;

    /**
     * Class constructor
     *
     * @param playerColor sets the playerColor
     * @param gameID sets gameID to the game ID
     */
    public JoinGameRequest(ChessGame.TeamColor playerColor, int gameID)
    {
        this.playerColor = playerColor;
        this.gameID = gameID;
    }

    public ChessGame.TeamColor getPlayerColor()
    {
        return playerColor;
    }

    public int getGameID()
    {
        return gameID;
    }

}
