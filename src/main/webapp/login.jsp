<%--
  Created by IntelliJ IDEA.
  User: favianalopez
  Date: 11/9/16
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<style>
        <%--New Acount link--%>
        a:link {
                color: crimson;
                background-color: transparent;
                text-decoration: none;
        }
        a:visited {
                color: pink;
                background-color: transparent;
                text-decoration: none;
        }
        a:hover {
                color: salmon;
                background-color: transparent;
                text-decoration: underline;
        }
        a:active {
                color: lightskyblue;
                background-color: transparent;
                text-decoration: underline;
        }

        <%--Login page--%>
        form {
                border: 3px solid orangered;
        }

        input[type=text], input[type=password] {
                width: 50%;
                padding: 6px 10px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid coral;
                box-sizing: border-box;
        }

        button {
                background-color: coral;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 20%;
        }

        .imgcontainer {
                text-align: center;
                margin: 12px 0 6px 0;
        }

        img.avatar {
                width: 20%;
                border-radius: 25%;
        }

        .container {
                padding: 16px;
        }


</style>
<body>

<a href="/createNewEventPlanner.jsp">Sign Up</a>

<form action="/event/login" method="post">

        <center>
                <h2 style="color:coral; font-family:cursive; font-size: xx-large;" class="text-muted">
                        Login
                </h2>
        </center>

        <div class="imgcontainer">
                <img src="http://pizzazzerie.com/wp-content/uploads/2011/05/ballerina-birthday-party-2-e1305933290317.jpg" alt="Avatar" class="avatar">
        </div>

        <div class="container">
                <center>
                        <label style="color:coral; font-family:cursive; font-size: large;">
                                <b>Username</b>
                        </label>

                        <br>

                        <input style="color:coral; font-family:cursive;" type="text" placeholder="Enter Username" name="username" required>

                        <br>

                        <label style="color:coral; font-family:cursive; font-size: large;">
                                <b>Password</b>
                        </label>

                        <br>

                        <input style="color:coral; font-family:cursive;" type="password" placeholder="Enter Password" name="password" required>

                        <br>

                        <h5 style="color:red; font-family:cursive">
                                <c:if test="${errorMessage != null}">
                                        <div class="alert alert-danger">
                                                <c:out value="${errorMessage}"/>
                                        </div>
                                </c:if>
                        </h5>

                        <br>

                        <button type="submit">Login</button>

                </center>
        </div>

</form>



<div id="main-wrapper">
<footer class="footer">
<p>&copy; 2016 5E, Inc.</p>
</footer>
</div>

</body>
</html>

















<%--<html>--%>
<%--<head>--%>
    <%--<title>Login</title>--%>
<%--</head>--%>

<%--<body background="http://www.mochatini.org/wp-content/uploads/2009/03/simplystated-js-1.jpg">--%>


<%--</div>--%>
<%--<form action="/event/login" method="post">--%>

        <%--Event Planner:--%>
        <%--<br>--%>
        <%--<input type="text" name="username"/>--%>
        <%--<br>--%>
        <%--Password:--%>
        <%--<br>--%>
        <%--<input type="password" name="password"/>--%>
        <%--<br>--%>

        <%--<div>--%>

                <%--<input type="submit" name="Login"  value=" Login " style="font-size:7pt;color:white;--%>
                <%--background-color:coral;border:2px solid palevioletred;padding:3px"/>--%>
        <%--</div>--%>
<%--</form>--%>

<%--<p/>--%>

<%--<div id="main-wrapper">--%>
<%--<footer class="footer">--%>
        <%--<p>&copy; 2016 5E, Inc.</p>--%>
<%--</footer>--%>
<%--</div>--%>


<%--</body>--%>
<%--</html>--%>
