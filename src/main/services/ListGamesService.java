package services;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import dataAccess.GameDAO;
import models.Game;
import responses.ListGamesResponse;

public class ListGamesService
{
    public ListGamesResponse listGames(String token)
    {
        Database database = new Database();

        try {
            database.getConnection();
        } catch (DataAccessException exception)
        {

        }

        GameDAO gameDAO = new GameDAO();
        AuthDAO authDAO = new AuthDAO();

        if (authDAO.findAuthtoken(token) == null)
        {
            return new ListGamesResponse("Error: unauthorized");
        }

        Game[] games = gameDAO.findAllGames();

        return new ListGamesResponse(games);
    }
}
