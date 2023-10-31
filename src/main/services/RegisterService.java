package services;

import dataAccess.AuthDAO;
import dataAccess.UserDAO;
import models.Authtoken;
import models.User;
import requests.RegisterRequest;
import responses.RegisterResponse;

public class RegisterService
{
    public RegisterResponse registerUser(RegisterRequest r)
    {
        UserDAO userDAO = new UserDAO();

        if (r.getUsername() == null || r.getPassword() == null || r.getEmail() == null)
        {
            return new RegisterResponse("Error: bad request");
        }
        if (userDAO.findUser(r.getUsername()) != null)
        {
            return new RegisterResponse("Error: already taken");
        }

        Authtoken token = userDAO.insertUser(r.getUsername(), r.getPassword(), r.getEmail());

        return new RegisterResponse(token.getAuthToken());
    }

}
