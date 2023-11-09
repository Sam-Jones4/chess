package services;

import dataAccess.*;
import responses.ClearApplicationResponse;

import java.sql.Connection;

public class ClearApplicationService
{
    public ClearApplicationResponse clearApplication() throws DataAccessException {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);
        UserDAO userDAO = new UserDAO(connection);
        GameDAO gameDAO = new GameDAO(connection);

        authDAO.clearAuthtokens();
        userDAO.clearUsers();
        gameDAO.clearGames();

        database.closeConnection(connection);

        return new ClearApplicationResponse(null);
    }

}
