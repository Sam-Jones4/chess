package ui;

import facade.ServerFacade;
import requests.LoginRequest;
import requests.RegisterRequest;
import responses.LoginResponse;
import responses.RegisterResponse;

import java.util.Scanner;

public class PreloginUI {
    public static void EnterCommand() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.next();
            if (command == "register")
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
            else if (command == "login")
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
                    } else {
                        PostloginUI.EnterCommand();
                    }

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
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

