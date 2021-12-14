package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import JavaBean.*;
import java.sql.Connection;
import dao.*;

import util.DButil;

@WebServlet(value = "/login", name="login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String isMngr=request.getParameter("auma");
        String username=request.getParameter("username");
        String pwd=request.getParameter("password");
        System.out.println(username+" "+pwd);
        DButil dbu=new DButil();
        Connection connLogin=dbu.getConnection();
        managerDao anMngrDao=new managerDao();
        userDao anUserDao=new userDao();

        if(isMngr.equals("mngr")){
            manager anMngr=new manager(username, pwd);
            manager toLogMngr;
            try {
                toLogMngr=anMngrDao.loginMngr(connLogin, anMngr);
                if(toLogMngr==null){
                    response.sendRedirect("errorLogin.html");
                } else {
                    request.getSession().setAttribute("thisMngr",toLogMngr);
                    response.sendRedirect("Mngr.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            user anUser=new user (username, pwd);
            user toLogUser;
            try{
                toLogUser=anUserDao.loginUser(connLogin, anUser);
                if(toLogUser==null){
                    response.sendRedirect("errorLogin.html");
                } else {
                    request.getSession().setAttribute("thisUser",toLogUser);
                    response.sendRedirect("User.jsp");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
//        String username=request.getParameter("username");
//        String pwd=request.getParameter("password");
//        System.out.println(username+" "+pwd);
//
//        if(username.equals("admin")&&pwd.equals("888")){
//            //重定向到BooKList
//            response.sendRedirect(" BookServlet");
//        }else{
//            //重定向
//            response.sendRedirect("login.html");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}