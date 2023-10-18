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
}
