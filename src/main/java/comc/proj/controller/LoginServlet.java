package comc.proj.controller;

import comc.proj.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserDao dao=new UserDao();
        int result=0;
        //get the parameter
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
//        System.out.println(userName);
//        System.out.println(password);
        //invoke dao to make a query
        result=dao.logIn(userName,password);
        //write the result back to the browser using the response
        if(result>=1){
            response.sendRedirect("/hr/wenjuan.html");
        }
        else{

            response.sendRedirect("/hr/login_error.html");
        }



    }
}
