<%--
  Created by IntelliJ IDEA.
  User: 23575
  Date: 2021/4/12
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>Id</td><td>password</td><td>Email</td><td>Gender</td><td>
    </tr>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%
        /*while(rs.next()){
        //get one by one
         out.println("<tr>");

                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthdate")+"</td>");
                out.println("</tr>");
        }
         */
         //we will get data in next demo - 6.LiveDemo #3
        %>
<%@include file="footer.jsp"%>>