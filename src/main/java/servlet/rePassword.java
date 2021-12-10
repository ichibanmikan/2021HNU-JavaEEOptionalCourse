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

@WebServlet(value = "/rePassword", name="rePassword")
public class rePassword extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String usrName=request.getParameter("username");
        String pwd=request.getParameter("password");
        String oldPwd=request.getParameter("oldPassword");
        user oldUser=new user (usrName, oldPwd);
        DButil dbu=new DButil();
        Connection conn= dbu.getConnection();
        userDao usd=new userDao();
        try{
            if(!usd.isHaveUser(conn, oldUser)){
                response.sendRedirect("rePasswordError.html");
            } else {
                user toRepUser;
                try {
                    toRepUser=usd.loginUser(conn, oldUser);
                    if(toRepUser==null){
                        response.sendRedirect("errorRep.html");
                    } else {
                        user newUser=new user(usrName, pwd);
                        usd.delUserOnUsername(usrName, dbu);
                        usd.addUser(newUser, dbu);
                        response.sendRedirect("rePasswordSucc.html");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                usd.addUser(newUser, dbu);
            }
        } catch (Exception e){
            response.sendRedirect("rePasswordError.html");
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
}