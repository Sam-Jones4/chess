package services;

import dataAccess.*;
import responses.ClearApplicationResponse;

public class ClearApplicationService
{
    public ClearApplicationResponse clearApplication()
    {
        Database database = new Database();

        try {
            database.getConnection();
        } catch (DataAccessException exception)
        {

        }


        AuthDAO authDAO = new AuthDAO();
        UserDAO userDAO = new UserDAO();
        GameDAO gameDAO = new GameDAO();

        authDAO.clearAuthtokens();
        userDAO.clearUsers();
        gameDAO.clearGames();

        return new ClearApplicationResponse(null);
    }

}
