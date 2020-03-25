package myjava.servlets;


import myjava.tables.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginSServlet")
public class LoginSServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("susername");
        String password = request.getParameter("spassword");
        StudentD td=new StudentD();
        Student t=td.search(username);
        if(t.getSpassword().equals(password)){
            System.out.println("yes");
            request.setAttribute( "susername ",username);
            request.getRequestDispatcher( "/student.jsp").forward(request,response);
        }else{
            System.out.println("no");
            request.getRequestDispatcher( "/failed.jsp").forward(request,response);
        }
    }

}
