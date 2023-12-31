package handlers;

import com.google.gson.Gson;
import requests.CreateGameRequest;
import responses.CreateGameResponse;
import services.CreateGameService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class CreateGameHandler implements Route
{
    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        CreateGameResponse result;

        try {
            //1) use GSON to convert the request body into a create game request
            CreateGameRequest createGameRequest = new Gson().fromJson(request.body(), CreateGameRequest.class);

            //2) get the token from the header
            String token = request.headers("authorization");

            //3) call to service which will return a response
            CreateGameService service = new CreateGameService();
            result = service.createGame(createGameRequest, token);

            //4) send back the correct response code null = 200, etc
            if (result.getMessage() == null)
            {
                response.status(200);
            }
            else if (Objects.equals(result.getMessage(), "Error: bad request"))
            {
                response.status(400);
            }
            else if(Objects.equals(result.getMessage(), "Error: unauthorized"))
            {
                response.status(401);
            }
        } catch (Exception exception)
        {
            result = new CreateGameResponse("Error: " + exception.getMessage());
            response.status(500);
        }

        //5) return a response in JSON format
        return new Gson().toJson(result);
    }
}
