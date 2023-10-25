package handlers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateGameHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        //1) use GSON to convert the request body into a create game request
        //2) get the token from the header String token = request.headers(authorization)
        //3) call to service which will return a response
        //4) send back the correct response code null = 200, etc
        //5) return a response in JSON format
        return new Gson().toJson(/*whatever response the response gives you*/);
    }
}
