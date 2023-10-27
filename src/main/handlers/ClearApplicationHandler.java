package handlers;

import responses.ClearApplicationResponse;
import services.ClearApplicationService;
import spark.Request;
import spark.Response;
import spark.Route;

public class ClearApplicationHandler implements Route
{
    @Override
    public Object handle(Request request, Response response) throws Exception
    {
        String token = request.headers("/db");

        ClearApplicationService service = new ClearApplicationService();
        ClearApplicationResponse result = service.clearApplication(token);

        if (result.getMessage() == null)
        {
            response.status(200);
        }
        else
        {
            response.status(500);
        }

        return null;
    }
}
