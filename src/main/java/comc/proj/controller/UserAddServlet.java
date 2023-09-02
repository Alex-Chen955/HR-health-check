package comc.proj.controller;

import comc.proj.dao.UserDao;
import comc.proj.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddServlet", value = "/UserAddServlet")
public class UserAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
     response.setContentType("text/html;utf-8");
        UserDao dao=new UserDao();
        int result=0;
        Users user=null;
        //get the parameters from the form
        String companyName = request.getParameter("companyName");
        String businessSector = request.getParameter("businessSector");
        String companyLocation = request.getParameter("companyLocation");
        String contactName = request.getParameter("contactName");
        String contactJobTitle = request.getParameter("contactJobTitle");
        String contactEmail = request.getParameter("contactEmail");
        String contactTelephone = request.getParameter("contactTelephone");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String numberOfEmployees=request.getParameter("numberOfEmployees");
      user=new Users(companyName, businessSector, companyLocation, contactName, contactJobTitle, contactEmail,contactTelephone, userName,  password, numberOfEmployees) ;
       // invoke dao, to insert the information to the database, by using the JDBC
      result=dao.add(user);
      //invoke resp obj, write the result back to the browser
        PrintWriter out=response.getWriter();
        if(result==1){
            out.print("<font style:'grey' size:'45px'>Successfully Created!</font>");
            out.print("<a href='/hr/index.html'>Go back</a>");
        }
        else{
            out.print("<font style:'grey' size:'45px'>Fail to Create it, try again</font>");
            response.sendRedirect("/hr/signup.html");
        }

        }
}
