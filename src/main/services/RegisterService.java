package services;

import dataAccess.AuthDAO;
import dataAccess.UserDAO;
import models.Authtoken;
import models.User;
import requests.RegisterRequest;
import responses.RegisterResponse;

import java.util.UUID;

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

        userDAO.insertUser(r.getUsername(), r.getPassword(), r.getEmail());
        AuthDAO authDAO = new AuthDAO();

        Authtoken authtoken = new Authtoken(UUID.randomUUID().toString(),r.getUsername());

        authDAO.insertAuthtoken(authtoken);

        return new RegisterResponse(authtoken.getAuthToken());
    }

}
