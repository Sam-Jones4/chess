package server;

import com.google.gson.Gson;
import handlers.*;
import spark.*;
import java.util.*;

/**
 * Server class
 */
public class Server
{
    /**
     * Creates a new server to run
     *
     * @param args arguments provided on the command line
     */
    public static void main(String[] args)
    {
        new Server().run();
    }

    /**
     * Runs the server
     */
    private void run()
    {
        Spark.port(8080);

        Spark.externalStaticFileLocation("web");

        Spark.delete("/db", new ClearApplicationHandler());
        Spark.post("/user", new RegisterHandler());
        Spark.post("/session", new LoginHandler());
        Spark.delete("/session", new LogoutHandler());
        Spark.get("/game", new ListGamesHandler());
        Spark.post("/game", new CreateGameHandler());
        Spark.put("/game", new JoinGameHandler());
    }

}
