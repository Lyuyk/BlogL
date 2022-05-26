package BlogL.BlogLServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import BlogL.Utils.stringUtils;
public class loginServlet {

    public static void login(HttpServletRequest request)
    {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");

        if(stringUtils.isEmpty(userName)||stringUtils.isEmpty(password))
            return;


    }
}
