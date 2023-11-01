package services;

import dataAccess.AuthDAO;
import dataAccess.GameDAO;
import models.Authtoken;
import models.Game;
import requests.CreateGameRequest;
import responses.CreateGameResponse;

import java.util.UUID;

public class CreateGameService
{
    public CreateGameResponse createGame(CreateGameRequest request, String token)
    {
        GameDAO gameDAO = new GameDAO();
        AuthDAO authDAO = new AuthDAO();

        if (request.getGameName() == null)
        {
            return new CreateGameResponse("Error: bad request");
        }
        if (authDAO.findAuthtoken(token) == null)
        {
            return new CreateGameResponse("Error: unauthorized");
        }

        Game game = new Game(UUID.randomUUID().hashCode(), request.getGameName());

        if (gameDAO.findGame(game.getGameID()) != null)
        {
            return new CreateGameResponse("Error: bad request");
        }

        gameDAO.insertGame(game);

        return new CreateGameResponse(game.getGameID(), null);
    }
}
