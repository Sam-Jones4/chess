package dataAccess;

import chess.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Game;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Data access object class to store and retrieve game data
 */
public class GameDAO
{
    private Connection connection;
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
    public Game findGame(int gameID) throws DataAccessException
    {
        try (var preparedStatement = connection.prepareStatement("SELECT * FROM Game WHERE gameID = ?"))
        {
            preparedStatement.setInt(1, gameID);
            try (var resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    var id = resultSet.getInt("gameID");
                    var whiteUsername = resultSet.getString("whiteUsername");
                    var blackUsername = resultSet.getString("blackUsername");
                    var gameName = resultSet.getString("gameName");
                    var game = resultSet.getString("game");

                    var builder = new GsonBuilder();
                    builder.registerTypeAdapter(ChessGame.class, ChessGameImpl.getAdapter());
                    builder.registerTypeAdapter(ChessPiece.class, ChessPieceImpl.getAdapter());
                    builder.registerTypeAdapter(ChessBoard.class, ChessBoardImpl.getAdapter());

                    Gson gson = builder.create();

                    ChessGameImpl chessGame = gson.fromJson(game, ChessGameImpl.class);

                    Game foundGame = new Game(id, whiteUsername, blackUsername, gameName, chessGame);
                    return foundGame;
                }
            }
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
        return null;
    }

    /**
     * Finds all the games
     */
    public Game[] findAllGames() throws DataAccessException {
        try (var preparedStatement = connection.prepareStatement("SELECT * FROM Game"))
        {
            try (var resultSet = preparedStatement.executeQuery())
            {
                ArrayList<Game> allGames = new ArrayList<>();
                while (resultSet.next())
                {
                    var id = resultSet.getInt("gameID");
                    var whiteUsername = resultSet.getString("whiteUsername");
                    var blackUsername = resultSet.getString("blackUsername");
                    var gameName = resultSet.getString("gameName");
                    var game = resultSet.getString("game");

                    var builder = new GsonBuilder();
                    builder.registerTypeAdapter(ChessGame.class, ChessGameImpl.getAdapter());
                    builder.registerTypeAdapter(ChessPiece.class, ChessPieceImpl.getAdapter());
                    builder.registerTypeAdapter(ChessBoard.class, ChessBoardImpl.getAdapter());

                    Gson gson = builder.create();

                    ChessGameImpl chessGame = gson.fromJson(game, ChessGameImpl.class);

                    Game foundGame = new Game(id, whiteUsername, blackUsername, gameName, chessGame);
                    allGames.add(foundGame);
                }
                return allGames.toArray(new Game[0]);
            }
        } catch (SQLException exception)
        {
            throw new DataAccessException(exception.getMessage());
        }
    }

    /**
     * Claims a spot in a game
     *
     * @param username username to be black or white
     */
    public void claimSpot(int gameID, String username, ChessGame.TeamColor teamColor) throws DataAccessException
    {
        if (teamColor.equals(ChessGame.TeamColor.WHITE))
        {
            try (var preparedStatement = connection.prepareStatement("UPDATE Game SET whiteUsername=? WHERE gameID=?")) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, gameID);

                preparedStatement.executeUpdate();
            } catch (SQLException exception)
            {
                throw new DataAccessException(exception.getMessage());
            }
        }
        else
        {
            try (var preparedStatement = connection.prepareStatement("UPDATE Game SET blackUsername=? WHERE gameID=?")) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, gameID);

                preparedStatement.executeUpdate();
            } catch (SQLException exception)
            {
                throw new DataAccessException(exception.getMessage());
            }
        }
    }

}
