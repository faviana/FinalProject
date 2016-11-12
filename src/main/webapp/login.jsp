<%--
  Created by IntelliJ IDEA.
  User: favianalopez
  Date: 11/9/16
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>

<body background="http://www.mochatini.org/wp-content/uploads/2009/03/simplystated-js-1.jpg">



    <c:out value="${message}"/>
</div>
<form action="/event/login" method="post">

        Event Planner:
        <br>
        <input type="text" name="username"/>
        <br>
        Password:
        <br>
        <input type="password" name="password"/>
        <br>
        <input type="submit" name="Login">
</form>

</body>
</html>
