package BlogL.BlogLServlet;

import BlogL.Database.loginCheck;
import BlogL.Model.userBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = "/BlogL/login")
public class loginServlet extends HttpServlet {
    userBean userBeanData;
    private loginCheck lgnCheck;

    @Override
    public void init() throws ServletException
    {
        super.init();
        lgnCheck=loginCheck.instance();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/BlogL/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ID和密码
        String userId=request.getParameter("user_id").trim();
        String password= request.getParameter("user_password").trim();
        //判断正误
        boolean check=false;
        try{
            userBeanData=loginCheck.loginMatch(userId,password);
        } catch (Exception e) {
            throw new ServletException("登录出错");
        }

        if(userBeanData!=null)
        {
            check=true;
        }

        try(PrintWriter pwt= response.getWriter()) {
            if(check==false)
            {
                response.setContentType("text/html;charset=utf-8");
                request.setCharacterEncoding("utf-8");
                String loginErrorMsg="账号或密码出错";

                request.setAttribute("loginErrorMsg",loginErrorMsg);
                request.getRequestDispatcher("/BlogL/login.jsp").forward(request,response);
            }
            else {
                //账号密码正确即写入session
                //跳转至首页
                HttpSession httpSession= request.getSession();
                httpSession.setAttribute("userBeanData",userBeanData);

                response.sendRedirect(request.getContextPath()+"/BlogL/home.jsp");
            }
        }

    }
}
