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
            return new CreateGameResponse("Errror: bad request");
        }
        if (authDAO.findAuthtoken(token) == null)
        {
            return new CreateGameResponse("Error: unauthorized");
        }

        gameDAO.insertGame(request.getGameName());

        Authtoken authtoken = new Authtoken(UUID.randomUUID().toString(),request.getGameName());

        authDAO.insertAuthtoken(authtoken);

        return new CreateGameResponse(authtoken.getAuthToken());
    }
}
