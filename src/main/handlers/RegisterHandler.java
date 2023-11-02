package handlers;

import com.google.gson.Gson;
import requests.RegisterRequest;
import responses.RegisterResponse;
import services.RegisterService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class RegisterHandler implements Route
{

    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        RegisterResponse result;
        try
        {
            RegisterRequest registerRequest = new Gson().fromJson(request.body(), RegisterRequest.class);

            RegisterService service = new RegisterService();
            result = service.registerUser(registerRequest);

            if (result.getUsername() != null && result.getAuthToken() != null)
            {
                response.status(200);
            }
            else if (Objects.equals(result.getMessage(), "Error: bad request"))
            {
                response.status(400);
            }
            else if (Objects.equals(result.getMessage(), "Error: already taken"))
            {
                response.status(403);
            }
        } catch (Exception exception)
        {
            result = new RegisterResponse("Error: " + exception.getMessage());
            response.status(500);
        }

        return new Gson().toJson(result);
    }
}
