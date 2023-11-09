package services;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import dataAccess.GameDAO;
import models.Game;
import responses.ListGamesResponse;

import java.sql.Connection;

public class ListGamesService
{
    public ListGamesResponse listGames(String token) throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        AuthDAO authDAO = new AuthDAO(connection);

        if (authDAO.findAuthtoken(token) == null)
        {
            return new ListGamesResponse("Error: unauthorized");
        }

        Game[] games = gameDAO.findAllGames();

        database.closeConnection(connection);

        return new ListGamesResponse(games);
    }
}
