package services;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import responses.LogoutResponse;

public class LogoutService
{
    public LogoutResponse logout(String token)
    {
        Database database = new Database();

        try {
            database.getConnection();
        } catch (DataAccessException exception)
        {

        }

        AuthDAO authDAO = new AuthDAO();

        if (authDAO.findAuthtoken(token) == null)
        {
            return new LogoutResponse("Error: unauthorized");
        }

        authDAO.removeAuthtoken(token);

        return new LogoutResponse();
    }
}
