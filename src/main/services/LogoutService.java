package services;

import dataAccess.AuthDAO;
import responses.LogoutResponse;

public class LogoutService
{
    public LogoutResponse logout(String token)
    {
        AuthDAO authDAO = new AuthDAO();

        if (authDAO.findAuthtoken(token) == null)
        {
            return new LogoutResponse("Error: unauthorized");
        }

        authDAO.removeAuthtoken(token);

        return new LogoutResponse();
    }
}
