package ui;

import facade.ServerFacade;
import requests.CreateGameRequest;
import responses.CreateGameResponse;

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
            else if (Objects.equals(command, "list"))
            {

            }
            else if (Objects.equals(command, "join"))
            {

            }
            else if (Objects.equals(command, "observe"))
            {

            }
            else if (Objects.equals(command, "logout"))
            {

            }
            else if (Objects.equals(command, "quit"))
            {

            }
            else if (Objects.equals(command, "help"))
            {

            }
        }
    }

}
