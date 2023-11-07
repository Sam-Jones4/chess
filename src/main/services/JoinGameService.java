package services;

import chess.ChessGame;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import dataAccess.GameDAO;
import models.Authtoken;
import requests.JoinGameRequest;
import responses.JoinGameResponse;

import java.sql.Connection;

public class JoinGameService
{
    public JoinGameResponse joinGame(JoinGameRequest joinGameRequest, String token) throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        GameDAO gameDAO = new GameDAO(connection);
        AuthDAO authDAO = new AuthDAO(connection);

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
