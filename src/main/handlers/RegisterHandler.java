package handlers;

import com.google.gson.Gson;
import requests.JoinGameRequest;
import requests.RegisterRequest;
import responses.JoinGameResponse;
import responses.RegisterResponse;
import services.JoinGameService;
import services.RegisterService;
import spark.Request;
import spark.Response;
import spark.Route;

public class RegisterHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        RegisterRequest registerRequest = new Gson().fromJson(request.body(), RegisterRequest.class);

        RegisterService service = new RegisterService();
        RegisterResponse result = service.registerUser(registerRequest);

        if (result.getUsername() != null && result.getAuthToken() != null)
        {
            response.status(200);
        }
        else if (result.getMessage() == "Error: bad request")
        {
            response.status(400);
        }
        else if (result.getMessage() == "Error: already taken")
        {
            response.status(403);
        }
        else
        {
            response.status(500);
        }

        return new Gson().toJson(result);
    }
}
