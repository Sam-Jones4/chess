package dataAccess;

import chess.ChessGame;
import com.google.gson.Gson;
import models.Game;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Data access object class to store and retrieve game data
 */
public class GameDAO
{
    private Connection connection;

    /**
     * Creates a map to store games
     */
    private static Map<Integer, Game> gameMap = new HashMap<>();

    public GameDAO(Connection connection)
    {
        this.connection = connection;
    }

    /**
     * Clears game data
     */
    public void clearGames() throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("DELETE FROM Game"))
        {
            preparedStatement.executeUpdate();
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }

    /**
     * Inserts a game into the map
     *
     * @param game game to insert
     */
    public void insertGame(Game game) throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("INSERT INTO Auth (gameID, whiteUsername, blackUsername, gameName, game) VALUES(?, ?, ?, ?, ?)"
                , RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1, game.getGameID());
            preparedStatement.setString(2, game.getWhiteUsername());
            preparedStatement.setString(3, game.getBlackUsername());
            preparedStatement.setString(4, game.getGameName());
            preparedStatement.setString(5, new Gson().toJson(game.getGame()));

            preparedStatement.executeUpdate();
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }

    /**
     * Finds a game
     *
     * @param gameID game to find
     */
    public Game findGame(int gameID)
    {
        return gameMap.get(gameID);
    }

    /**
     * Finds all the games
     */
    public Game[] findAllGames()
    {
        return gameMap.values().toArray(new Game[0]);
    }

    /**
     * Claims a spot in a game
     *
     * @param username username to be black or white
     */
    public void claimSpot(int gameID, String username, ChessGame.TeamColor teamColor)
    {
        if (teamColor.equals(ChessGame.TeamColor.WHITE))
        {
            gameMap.get(gameID).setWhiteUsername(username);
        }
        else
        {
            gameMap.get(gameID).setBlackUsername(username);
        }
    }

}
