<%--
  Created by IntelliJ IDEA.
  User: favianalopez
  Date: 11/21/16
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    response.setHeader("Cache-Control","no-store, must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Latest compiled and minified CSS -->
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<center>
    <span class="message">Event Planner: ${eventPlanner.displayName}</span>
</center>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a style="color:lightsalmon;" href="/introduction.jsp">Introduction</a></li>
                <li role="presentation"><a style="color:lightsalmon;" href="/home.jsp">New Event</a></li>
                <li role="presentation" class="active"><a style="color:lightskyblue;" href="/event/ListAll">Events</a></li>
                <li role="presentation"><a style="color:lightsalmon;" href="/event/logout">Logout</a></li>
            </ul>
        </nav>
        <h2 style="color:coral;"class="text-muted"><font face="cursive">Event Planning With Favi</font></h2>
    </div>

    <div class="row marketing">
        <div class="col-lg-6">
            <h4 style="color:lightskyblue;"><font face="cursive">Details:</font></h4>

            <p/>

            <form method="post" action="/event/detailOption">

            <div style="float: left; width: 25%;">
                <tr>
                    <td>FOOD</td>

                    <td><textarea name="food" cols="20" rows="5"><c:out value="${detail.food}"/></textarea></td>
                </tr>
            </div>

                <div style="float: left; width: 25%;">
                    <tr>
                        <td>DECORATION</td>
                        <td><textarea name="decorations" cols="20" rows="5"><c:out value="${detail.decorations}"/></textarea></td>
                    </tr>
                </div>

                <div style="float: left; width: 25%;">
                    <tr>
                        <td>DRINK</td>
                        <td><textarea name="drinks" cols="20" rows="5"><c:out value="${detail.drinks}"/></textarea></td>
                    </tr>
                </div>

                <div style="float: left; width: 25%;">
                    <tr>
                        <td>DESSERT</td>
                        <td><textarea name="desserts" cols="20" rows="5"><c:out value="${detail.desserts}"/></textarea></td>
                    </tr>
                </div>

                <br/>

                <input type="submit" name ="Save"/>
                <input type="hidden" name="id" value="<c:out value="${detail.id}"/>"/>


            </form>
            </div>
        </div>
    </div>

    <p/>

    <footer class="footer">
        <p>&copy; 2016 5E, Inc.</p>
    </footer>

</div> <!-- /container -->

<p/>

</body>
</html>
