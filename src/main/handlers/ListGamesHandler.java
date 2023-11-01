package handlers;

import com.google.gson.Gson;
import requests.JoinGameRequest;
import responses.ClearApplicationResponse;
import responses.JoinGameResponse;
import responses.ListGamesResponse;
import services.JoinGameService;
import services.ListGamesService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class ListGamesHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        ListGamesResponse result;

        try {
            String token = request.headers("authorization");

            ListGamesService service = new ListGamesService();
            result = service.listGames(token);

            if (result.getGames() != null)
            {
                response.status(200);
            }
            else if(Objects.equals(result.getMessage(), "Error: unauthorized"))
            {
                response.status(401);
            }
        } catch (Exception exception)
        {
            result = new ListGamesResponse("Error: " + exception.getMessage());
            response.status(500);
        }

        return new Gson().toJson(result);
    }
}
