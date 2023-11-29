package facade;

import com.google.gson.Gson;
import requests.CreateGameRequest;
import requests.JoinGameRequest;
import requests.LoginRequest;
import requests.RegisterRequest;
import responses.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class ServerFacade
{
    public static String authToken = null;
    static String baseURL = "http://localhost:8080/";

    public static ClearApplicationResponse clearApplication() throws URISyntaxException, IOException
    {
        HttpURLConnection http = sendRequest(baseURL + "db", "DELETE", null);
        if (http.getResponseCode() == 200)
        {
            try (InputStream respBody = http.getInputStream()) {
                InputStreamReader inputStreamReader = new InputStreamReader(respBody);
                return new Gson().fromJson(inputStreamReader, ClearApplicationResponse.class);
            } catch (Exception exception)
            {
                return null;
            }
        }
        else
        {
            try (InputStream respBody = http.getErrorStream()) {
                InputStreamReader inputStreamReader = new InputStreamReader(respBody);
                return new Gson().fromJson(inputStreamReader, ClearApplicationResponse.class);
            } catch (Exception exception)
            {
                return null;
            }
        }
    }

    public static RegisterResponse register(RegisterRequest request) throws IOException, URISyntaxException
    {
        HttpURLConnection http = sendRequest(baseURL + "user", "POST", new Gson().toJson(request));
        try (InputStream respBody = http.getInputStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(respBody);
            return new Gson().fromJson(inputStreamReader, RegisterResponse.class);
        } catch (Exception exception)
        {
            return null;
        }
    }

    public static LoginResponse login(LoginRequest request) throws URISyntaxException, IOException
    {
        HttpURLConnection http = sendRequest(baseURL + "session", "POST", new Gson().toJson(request));
        try (InputStream respBody = http.getInputStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(respBody);
            return new Gson().fromJson(inputStreamReader, LoginResponse.class);
        } catch (Exception exception)
        {
            return null;
        }
    }

    public static LogoutResponse logout() throws URISyntaxException, IOException
    {
        HttpURLConnection http = sendRequest(baseURL + "session", "DELETE", null);
        if (http.getResponseCode() == 200)
        {
            try (InputStream respBody = http.getInputStream()) {
                InputStreamReader inputStreamReader = new InputStreamReader(respBody);
                return new Gson().fromJson(inputStreamReader, LogoutResponse.class);
            } catch (Exception exception)
            {
                return null;
            }
        }
        else
        {
            try (InputStream respBody = http.getErrorStream()) {
                InputStreamReader inputStreamReader = new InputStreamReader(respBody);
                return new Gson().fromJson(inputStreamReader, LogoutResponse.class);
            } catch (Exception exception)
            {
                return null;
            }
        }
    }

    public static ListGamesResponse listGames() throws URISyntaxException, IOException
    {
        HttpURLConnection http = sendRequest(baseURL + "game", "GET", null);
        if (http.getResponseCode() == 200)
        {
            try (InputStream respBody = http.getInputStream()) {
                InputStreamReader inputStreamReader = new InputStreamReader(respBody);
                return new Gson().fromJson(inputStreamReader, ListGamesResponse.class);
            } catch (Exception exception)
            {
                return null;
            }
        }
        else
        {
            try (InputStream respBody = http.getErrorStream()) {
                InputStreamReader inputStreamReader = new InputStreamReader(respBody);
                return new Gson().fromJson(inputStreamReader, ListGamesResponse.class);
            } catch (Exception exception)
            {
                return null;
            }
        }
    }

    public static CreateGameResponse createGame(CreateGameRequest request) throws URISyntaxException, IOException
    {
        HttpURLConnection http = sendRequest(baseURL + "game", "POST", new Gson().toJson(request));
        try (InputStream respBody = http.getInputStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(respBody);
            return new Gson().fromJson(inputStreamReader, CreateGameResponse.class);
        } catch (Exception exception)
        {
            return null;
        }
    }

    public static JoinGameResponse joinGame(JoinGameRequest request) throws URISyntaxException, IOException
    {
        HttpURLConnection http = sendRequest(baseURL + "game", "PUT", new Gson().toJson(request));
        try (InputStream respBody = http.getInputStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(respBody);
            return new Gson().fromJson(inputStreamReader, JoinGameResponse.class);
        } catch (Exception exception)
        {
            return null;
        }
    }

    private static HttpURLConnection sendRequest(String url, String method, String body) throws URISyntaxException, IOException
    {
        URI uri = new URI(url);
        HttpURLConnection http = (HttpURLConnection) uri.toURL().openConnection();
        http.setRequestMethod(method);
        writeRequestBody(body, http);
        http.connect();
        System.out.printf("= Request =========\n[%s] %s\n\n%s\n\n", method, url, body);
        return http;
    }

    private static void writeRequestBody(String body, HttpURLConnection http) throws IOException {
        if (body != null && !body.isEmpty()) {
            http.setDoOutput(true);
            try (var outputStream = http.getOutputStream()) {
                outputStream.write(body.getBytes());
            }
        }
    }
}

