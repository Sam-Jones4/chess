package services;

import dataAccess.AuthDAO;
import dataAccess.GameDAO;
import dataAccess.UserDAO;
import responses.ClearApplicationResponse;

public class ClearApplicationService
{
    public ClearApplicationResponse clearApplication()
    {
        AuthDAO authDAO = new AuthDAO();
        UserDAO userDAO = new UserDAO();
        GameDAO gameDAO = new GameDAO();

        authDAO.clearAuthtokens();
        userDAO.clearUsers();
        gameDAO.clearGames();

        return new ClearApplicationResponse(null);
    }

}
