<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ page import="JavaBean.user" %>

<!DOCTYPE html>
<html lang="en" meta content="text/html"; charset="utf-8">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户系统</title>
    <style type="text/css">
        h1{
            text-align: center;
        }
        #before{
            text-align: center;
        }
        #head{
            background: #eeeeee;height: 80px;
        }
        #headLink{
            font-size: 20px;
        }
        #headWelLink{
            font-size: 20px;
        }
    </style>
</head>

<body>
    <%
        user thisUser =(user)session.getAttribute("thisUser");
        if(thisUser == null){
            response.sendRedirect("SignInUp.html");
        } else {
    %>
        <div id="head">
            <table width="100%">
                <td id="headWelLink">欢迎您：<%=thisUser.getUserName()%></td>
                <td align="right" id="headLink">
                    <a href="SignInUp.html">安全退出</a>
                </td>
            </table>
        </div>
    <%
        }
    %>
    <div>
        <h1>我的收藏</h1>
        <br>
        <table>
            <tr>

            </tr>
        </table>
    </div>
</body>