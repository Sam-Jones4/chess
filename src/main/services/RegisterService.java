package services;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.Database;
import dataAccess.UserDAO;
import models.Authtoken;
import requests.RegisterRequest;
import responses.RegisterResponse;

import java.util.UUID;

public class RegisterService
{
    public RegisterResponse registerUser(RegisterRequest r)
    {
        Database database = new Database();

        try {
            database.getConnection();
        } catch (DataAccessException exception)
        {

        }

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

        return new RegisterResponse(r.getUsername(),authtoken.getAuthToken());
    }

}
