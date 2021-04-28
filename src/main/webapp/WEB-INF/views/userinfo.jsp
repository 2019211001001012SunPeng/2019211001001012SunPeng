<%--
  Created by IntelliJ IDEA.
  User: 23575
  Date: 2021/4/14
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.SunPeng.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp"%>
<h1>User Info</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>Birthday:</td><td><%=u.getBirthDate()%></td><br></tr>
    <tr><td><a href="updateUser">Update User</a></td></tr>
</table>
<%@include file="footer.jsp"%>