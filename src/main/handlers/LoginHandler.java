package handlers;

import com.google.gson.Gson;
import requests.JoinGameRequest;
import requests.LoginRequest;
import requests.RegisterRequest;
import responses.JoinGameResponse;
import responses.LoginResponse;
import responses.RegisterResponse;
import services.JoinGameService;
import services.LoginService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class LoginHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        LoginResponse result;
        try
        {
            LoginRequest loginRequest = new Gson().fromJson(request.body(), LoginRequest.class);

            LoginService service = new LoginService();
            result = service.login(loginRequest);

            if (result.getUsername() != null && result.getAuthToken() != null)
            {
                response.status(200);
            }
            else if(Objects.equals(result.getMessage(), "Error: unauthorized"))
            {
                response.status(401);
            }
        }catch (Exception exception)
        {
            result = new LoginResponse("Error: " + exception.getMessage());
            response.status(500);
        }

        return new Gson().toJson(result);
    }
}
