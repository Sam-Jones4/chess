package handlers;

import com.google.gson.Gson;
import responses.ClearApplicationResponse;
import responses.RegisterResponse;
import services.ClearApplicationService;
import spark.Request;
import spark.Response;
import spark.Route;

public class ClearApplicationHandler implements Route
{
    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        ClearApplicationResponse result;

        try
        {
            ClearApplicationService service = new ClearApplicationService();
            result = service.clearApplication();

            if (result.getMessage() == null)
            {
                response.status(200);
            }
        }catch (Exception exception)
        {
            result = new ClearApplicationResponse("Error: " + exception.getMessage());
            response.status(500);
        }

        return new Gson().toJson(result);
    }
}
