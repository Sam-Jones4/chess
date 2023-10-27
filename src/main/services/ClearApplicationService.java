package services;

import dataAccess.AuthDAO;
import responses.ClearApplicationResponse;

public class ClearApplicationService
{
    public ClearApplicationResponse clearApplication(String token)
    {
        //check is the authtoken is valid, if invalid send 401
        //check the request object is valid,
        AuthDAO authDAO = new AuthDAO();
        ClearApplicationService
        authDAO.getAuthtoken()

        return null;
    }

}
