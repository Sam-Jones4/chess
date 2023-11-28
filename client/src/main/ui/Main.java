package ui;

import facade.ServerFacade;

import java.rmi.ServerError;
import java.util.prefs.Preferences;

public class Main
{
    public static void main(String[] args)
    {
        while(true)
        {
            if (ServerFacade.authToken == null)
            {
                PreloginUI.EnterCommand();
            }
            else
            {
                PostloginUI.EnterCommand();
            }
        }
    }
}
