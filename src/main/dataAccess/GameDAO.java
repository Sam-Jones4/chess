package dataAccess;

import chess.ChessGame;
import models.Game;
import models.User;
import java.util.Map;

/**
 * Data access object class to store and retrieve game data
 */
public class GameDAO
{
    /**
     * Creates a map to store games
     */
    private static Map<Integer, Game> gameMap;

    /**
     * Clears game data
     */
    private void clearGame()
    {
        gameMap.clear();
    }

    /**
     * Inserts a game into the map
     *
     * @param game game to insert
     */
    private void insertGame(Game game)
    {
        gameMap.put(game.getGameName(), game);
    }

    /**
     * Finds a game
     *
     * @param gameName game to find
     */
    private Game findGame(String gameName)
    {
        return gameMap.get(gameName);
    }

    /**
     * Finds all the games
     */
    private Map<String,Game> findAllGames()
    {
        return gameMap;
    }

    /**
     * Claims a spot in a game
     *
     * @param username username to be black or white
     */
    private void claimSpot(int gameID, String username, ChessGame.TeamColor teamColor)
    {
        if (teamColor.equals(ChessGame.TeamColor.WHITE))
        {
            gameMap.get(gameID).setWhiteUsername(username);
        }
    }

    /**
     * Updates a game in the database
     *
     * @param game game to be updated
     */
    private void updateGame(Game game)
    {

    }

    /**
     * Removes a game from the database
     *
     * @param gameName game to be removed
     */
    private void removeGame(String gameName)
    {
        gameMap.remove(gameName);
    }

}
