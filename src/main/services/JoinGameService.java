package services;

import chess.ChessGame;
import dataAccess.AuthDAO;
import dataAccess.GameDAO;
import dataAccess.UserDAO;
import models.Authtoken;
import requests.JoinGameRequest;
import responses.JoinGameResponse;

public class JoinGameService
{
    public JoinGameResponse joinGame(JoinGameRequest joinGameRequest, String token)
    {
        GameDAO gameDAO = new GameDAO();
        AuthDAO authDAO = new AuthDAO();

        if (joinGameRequest.getGameID() == 0)
        {
            return new JoinGameResponse("Error: bad request");
        }
        if (authDAO.findAuthtoken(token) == null)
        {
            return new JoinGameResponse("Error: unauthorized");
        }

        if (gameDAO.findGame(joinGameRequest.getGameID()) != null)
        {
            if (joinGameRequest.getPlayerColor() != null)
            {
                if (joinGameRequest.getPlayerColor() == ChessGame.TeamColor.BLACK)
                {
                    if (gameDAO.findGame(joinGameRequest.getGameID()).getBlackUsername() != null)
                    {
                        return new JoinGameResponse("Error: already taken");
                    }
                }
                if (joinGameRequest.getPlayerColor() == ChessGame.TeamColor.WHITE)
                {
                    if (gameDAO.findGame(joinGameRequest.getGameID()).getWhiteUsername() != null)
                    {
                        return new JoinGameResponse("Error: already taken");
                    }
                }
            }

        }

        Authtoken authtoken = authDAO.findAuthtoken(token);

        if (joinGameRequest.getPlayerColor() != null)
        {
            gameDAO.claimSpot(joinGameRequest.getGameID(), authtoken.getUsername(), joinGameRequest.getPlayerColor());
        }

        return new JoinGameResponse();
    }

}
