package ui;

import chess.ChessGame;
import chess.ChessGameImpl;
import facade.ServerFacade;
import requests.CreateGameRequest;
import requests.JoinGameRequest;
import responses.CreateGameResponse;
import responses.JoinGameResponse;
import responses.ListGamesResponse;

import java.util.Objects;
import java.util.Scanner;

public class PostloginUI
{
    public static void EnterCommand()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            String command = scanner.next();
            if (Objects.equals(command, "create"))
            {
                System.out.println("Game name: ");
                String gameName = scanner.next();

                CreateGameRequest request = new CreateGameRequest(gameName);

                try
                {
                    CreateGameResponse result = ServerFacade.createGame(request);

                    assert result != null;
                    if (result.getMessage() != null)
                    {
                        System.out.println(result.getMessage());
                    }
                    else
                    {
                        PostloginUI.EnterCommand();
                    }

                } catch (Exception exception)
                {
                    System.out.println(exception.getMessage());
                }

            }
            else if (Objects.equals(command, "list"))
            {
                try
                {
                    ListGamesResponse result = ServerFacade.listGames();

                    assert result != null;
                    if (result.getMessage() != null)
                    {
                        System.out.println(result.getMessage());
                    }
                    else
                    {
                        PostloginUI.EnterCommand();
                    }

                } catch (Exception exception)
                {
                    System.out.println(exception.getMessage());
                }
            }
            else if (Objects.equals(command, "join"))
            {
                System.out.println("Game ID: ");
                int gameID = Integer.parseInt(scanner.next());

                System.out.println("Team Color [WHITE|BLACK|<empty>]: ");
                ChessGame.TeamColor teamColor = ChessGame.TeamColor.valueOf(scanner.next());


                JoinGameRequest request = new JoinGameRequest(teamColor, gameID);

                try
                {
                    JoinGameResponse result = ServerFacade.joinGame(request);

                    assert result != null;
                    if (result.getMessage() != null)
                    {
                        System.out.println(result.getMessage());
                    }
                    else
                    {
                        ChessGameImpl game = new ChessGameImpl();
                        game.getBoard().resetBoard();
                        GameUI.PrintWhiteBoard(game);
                    }
                } catch (Exception exception)
                {
                    System.out.println(exception.getMessage());
                }
            }
            else if (Objects.equals(command, "observe"))
            {
                System.out.println("Game ID: ");
                int gameID = Integer.parseInt(scanner.next());

                JoinGameRequest request = new JoinGameRequest(null, gameID);

                try
                {
                    JoinGameResponse result = ServerFacade.joinGame(request);

                    assert result != null;
                    if (result.getMessage() != null)
                    {
                        System.out.println(result.getMessage());
                    }
                    else
                    {
                        ChessGameImpl game = new ChessGameImpl();
                        game.getBoard().resetBoard();
                        GameUI.PrintWhiteBoard(game);
                    }
                } catch (Exception exception)
                {
                    System.out.println(exception.getMessage());
                }
            }
            else if (Objects.equals(command, "logout"))
            {
                PreloginUI.EnterCommand();
            }
            else if (Objects.equals(command, "quit"))
            {
                return;
            }
            else if (Objects.equals(command, "help"))
            {
                System.out.print(EscapeSequences.SET_TEXT_COLOR_BLUE);
                System.out.println("create - a game");
                System.out.println("list - games");
                System.out.println("join - a game");
                System.out.println("observe - a game");
                System.out.println("logout - when you are done");
                System.out.println("quit - playing chess");
                System.out.println("help - with possible commands");
                System.out.print(EscapeSequences.RESET_TEXT_COLOR);
            }
        }
    }

}
