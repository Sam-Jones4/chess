package handlers;

import com.google.gson.Gson;
import requests.JoinGameRequest;
import responses.JoinGameResponse;
import responses.ListGamesResponse;
import services.JoinGameService;
import services.ListGamesService;
import spark.Request;
import spark.Response;
import spark.Route;

public class ListGamesHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        String token = request.headers("authorization");

        ListGamesService service = new ListGamesService();
        ListGamesResponse result = service.listGames(token);

        if (result.getGames() != null)
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
