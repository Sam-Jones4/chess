package services;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import responses.LogoutResponse;

import java.sql.Connection;

public class LogoutService
{
    public LogoutResponse logout(String token) throws DataAccessException
    {
        Database database = new Database();
        Connection connection = database.getConnection();

        AuthDAO authDAO = new AuthDAO(connection);

        if (authDAO.findAuthtoken(token) == null)
        {
            return new LogoutResponse("Error: unauthorized");
        }

        authDAO.removeAuthtoken(token);

        database.closeConnection(connection);

        return new LogoutResponse();
    }
}
