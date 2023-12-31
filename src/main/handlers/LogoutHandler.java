package handlers;

import com.google.gson.Gson;
import responses.LogoutResponse;
import services.LogoutService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class LogoutHandler implements Route
{
    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        LogoutResponse result;

        try {
            String token = request.headers("authorization");

            LogoutService service = new LogoutService();
            result = service.logout(token);

            if (result.getMessage() == null)
            {
                response.status(200);
            }
            else if(Objects.equals(result.getMessage(), "Error: unauthorized"))
            {
                response.status(401);
            }
        } catch (Exception exception)
        {
            result = new LogoutResponse("Error: " + exception.getMessage());
            response.status(500);
        }

        return new Gson().toJson(result);
    }
}
