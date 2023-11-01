package services;

import dataAccess.AuthDAO;
import dataAccess.UserDAO;
import models.Authtoken;
import models.User;
import requests.LoginRequest;
import responses.LoginResponse;

import java.util.Objects;
import java.util.UUID;

public class LoginService
{
    public LoginResponse login(LoginRequest loginRequest)
    {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findUser(loginRequest.getUsername());

        if (user == null)
        {
            return new LoginResponse("Error: unauthorized");
        }
        if (!Objects.equals(user.getPassword(), loginRequest.getPassword()))
        {
            return new LoginResponse("Error: unauthorized");
        }

        AuthDAO authDAO = new AuthDAO();

        Authtoken authtoken = new Authtoken(UUID.randomUUID().toString(), loginRequest.getUsername());

        authDAO.insertAuthtoken(authtoken);

        return new LoginResponse(loginRequest.getUsername(), authtoken.getAuthToken());
    }
}
