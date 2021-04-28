<%--
  Created by IntelliJ IDEA.
  User: 23575
  Date: 2021/3/15
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!--method is GET-->
<form method="post"><!--what is method when we use form?--><!--its GET,why? default is GET-->
        Name :<input type="text" name="name"><br/>
    ID :<input type="text" name="id"><br/>
    <input type="submit" value="Send data to server"/>
    <br/>
    This is SunPeng's JSP page.
</form>
</body>
</html>
<%@include file="WEB-INF/views/footer.jsp"%>