package ui;

import facade.ServerFacade;
import requests.CreateGameRequest;
import responses.CreateGameResponse;

import java.util.Scanner;

public class PostloginUI
{
    public static void EnterCommand()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            String command = scanner.next();
            if (command == "create")
            {
                System.out.println("Game name:");
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
            else if (command == "list")
            {

            }
            else if (command == "join")
            {

            }
            else if (command == "observe")
            {

            }
            else if (command == "logout")
            {

            }
            else if (command == "quit")
            {

            }
            else if (command == "help")
            {

            }
        }
    }

}
