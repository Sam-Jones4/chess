package handlers;

import com.google.gson.Gson;
import requests.JoinGameRequest;
import requests.LoginRequest;
import responses.JoinGameResponse;
import responses.LoginResponse;
import services.JoinGameService;
import services.LoginService;
import spark.Request;
import spark.Response;
import spark.Route;

public class LoginHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        LoginRequest loginRequest = new Gson().fromJson(request.body(), LoginRequest.class);

        LoginService service = new LoginService();
        LoginResponse result = service.login(loginRequest);

        if (result.getMessage() == null)
        {
            response.status(200);
        }
        else if(result.getMessage() == "Error: unauthorized")
        {
            response.status(401);
        }
        else
        {
            response.status(500);
        }

        return new Gson().toJson(result);
    }
}
