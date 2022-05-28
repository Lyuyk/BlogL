package BlogL.BlogLServlet;

import BlogL.Model.userBean;
import BlogL.Database.registerCheck;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/BlogL/register")
public class registerServlet extends HttpServlet {
    userBean userBeanData;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("user_name").trim();
        String password= request.getParameter("user_password").trim();
        String passwordCheck= request.getParameter("user_password_check").trim();
        String email= request.getParameter("user_email").trim();

        boolean check;

        userBeanData.setUserName(userName);
        userBeanData.setUserPassword(password);
        try {
            if(!registerCheck.check(userBeanData))
            {
                registerCheck.register(userBeanData);
            }
            else
            {
                HttpSession httpSession=request.getSession();
                httpSession.setAttribute("registerBean",userBeanData);

                response.sendRedirect(request.getContextPath()+"/BlogL/login.jsp");
            }
        }
        catch (Exception e) {
            throw new RuntimeException("账号密码不合法");
        }

    }
}
