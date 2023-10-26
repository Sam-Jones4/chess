package handlers;

import com.google.gson.Gson;
import requests.JoinGameRequest;
import responses.JoinGameResponse;
import responses.LogoutResponse;
import services.JoinGameService;
import services.LogoutService;
import spark.Request;
import spark.Response;
import spark.Route;

public class LogoutHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        String token = request.headers("authorization");

        LogoutService service = new LogoutService();
        LogoutResponse result = service.logout(token);

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
