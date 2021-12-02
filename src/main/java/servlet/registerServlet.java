package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import JavaBean.*;
import dao.*;

import util.DButil;

@WebServlet(value = "/register", name="register")
public class registerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String usrName=request.getParameter("username");
        String pwd=request.getParameter("password");
        user newUser=new user (usrName, pwd);
        DButil dbu=new DButil();
        Connection conn= dbu.getConnection();
        userDao usd=new userDao();
        try{
            if(usd.isHaveUser(conn, newUser)){
                response.sendRedirect("RegErrorIsHave.html");
            } else {
                usd.addUser(newUser, dbu);
                response.sendRedirect("regSucc.html");
            }
        } catch (Exception e){
            response.sendRedirect("RegError.html");
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
}