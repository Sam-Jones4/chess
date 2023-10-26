package handlers;

import com.google.gson.Gson;
import requests.JoinGameRequest;
import responses.JoinGameResponse;
import services.JoinGameService;
import spark.Request;
import spark.Response;
import spark.Route;

public class JoinGameHandler implements Route
{
    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        JoinGameRequest joinGameRequest = new Gson().fromJson(request.body(), JoinGameRequest.class);

        String token = request.headers("authorization");

        JoinGameService service = new JoinGameService();
        JoinGameResponse result = service.joinGame(joinGameRequest, token);

        if (result.getMessage() == null)
        {
            response.status(200);
        }
        else if (result.getMessage() == "Error: bad request")
        {
            response.status(400);
        }
        else if(result.getMessage() == "Error: unauthorized")
        {
            response.status(401);
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
