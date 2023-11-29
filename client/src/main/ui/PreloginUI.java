package ui;

import facade.ServerFacade;
import requests.LoginRequest;
import requests.RegisterRequest;
import responses.LoginResponse;
import responses.RegisterResponse;

import java.util.Objects;
import java.util.Scanner;

public class PreloginUI {
    public static void EnterCommand() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.next();
            if (Objects.equals(command, "register"))
            {
                System.out.println("Username:");
                String username = scanner.next();

                System.out.println("Password:");
                String password = scanner.next();

                System.out.println("Email:");
                String email = scanner.next();

                RegisterRequest request = new RegisterRequest(username, password, email);

                try {
                    RegisterResponse result = ServerFacade.register(request);

                    assert result != null;
                    if (result.getMessage() != null) {
                        System.out.println(result.getMessage());
                    } else {
                        PostloginUI.EnterCommand();
                    }

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
            else if (Objects.equals(command, "login"))
            {
                System.out.println("Username:");
                String username = scanner.next();

                System.out.println("Password:");
                String password = scanner.next();

                LoginRequest request = new LoginRequest(username, password);

                try {
                    LoginResponse result = ServerFacade.login(request);

                    assert result != null;
                    if (result.getMessage() != null) {
                        System.out.println(result.getMessage());
                    } else
                    {
                        PostloginUI.EnterCommand();
                    }

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
            else if (Objects.equals(command, "quit"))
            {
                return;
            }
            else if (Objects.equals(command, "help"))
            {
                System.out.print(EscapeSequences.SET_TEXT_COLOR_BLUE);
                System.out.println("register - to create an account");
                System.out.println("login - to play chess");
                System.out.println("quit - playing chess");
                System.out.println("help - with possible commands");
                System.out.print(EscapeSequences.RESET_TEXT_COLOR);
            }
        }
    }
}

