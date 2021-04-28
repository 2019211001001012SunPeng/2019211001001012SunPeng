<%--
  Created by IntelliJ IDEA.
  User: 23575
  Date: 2021/3/21
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>>
<form method="post" action="register"><!-- within daPost() in servlet-->
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender: <input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    <!-- if name is same it make array -->
    Date of Birth :<input type="text name" name="birthDate"><br/>
    <input type="submit" value="Register"/>

</form>
<%@include file="WEB-INF/views/footer.jsp"%>>
