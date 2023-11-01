package services;

import dataAccess.AuthDAO;
import dataAccess.GameDAO;
import models.Game;
import responses.ListGamesResponse;

public class ListGamesService
{
    public ListGamesResponse listGames(String token)
    {
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
