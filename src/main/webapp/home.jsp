<%--
  Created by IntelliJ IDEA.
  User: favianalopez
  Date: 11/9/16
  Time: 12:23 PM
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
    <span class="message"><font color="#f08080", face="cursive"> Event Planner: ${eventPlanner.displayName}</font></span>
</center>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a style="color:lightsalmon;" href="/introduction.jsp">Introduction</a></li>
                <li role="presentation"><a style="color:lightskyblue;" href="/home.jsp">New Event</a></li>
                <li role="presentation"><a style="color:lightsalmon;"href="/event/ListAll">Events</a></li>
                <li role="presentation"><a style="color:lightsalmon;" href="/event/logout">Logout</a></li>
            </ul>
        </nav>
        <h2 style="color:coral;"class="text-muted"><font face="cursive">Event Planning With Favi</font></h2>
    </div>

    <div class="row marketing">
        <div class="col-lg-6">
            <h4 style="color:lightskyblue;"><font face="cursive">Create a new event:</font></h4>


            <form method="post" action="/event/create">

            <table class="table">
                <thead>

                <tr><td>Name of Event:</td><td><input type="text" name="nameOfEvent" value="<c:out value="${nameOfEvent}"/>"></td></tr>
                <tr><td>Budget:</td><td><input type="text" name="budget" value="<c:out value="${budget}"/>"></td></tr>
                <tr><td>Number of Guests:</td><td><input type="text" name="numberOfGuests" value="<c:out value="${numberOfGuests}"/>"></td></tr>
                <tr><td>Date of Event:</td><td><input type="text" name="dateOfEvent" value="<c:out value="${dateOfEvent}"/>"></td></tr>
                <tr><td>Time of Event:</td><td><input type="text" name="timeOfEvent" value="<c:out value="${tiemOfEvent}"/>"></td></tr>
                <tr><td>Location:</td><td><input type="text" name="location" value="<c:out value="${location}"/>"></td></tr>

            </table>

                <div>
                    <input type="submit" name="Save"/>
                </div>

                <div>
                    <font face="cursive">
                        <center>
                            <br>
                            Once you create your event click on "details" link to add and see more fun things about your event

                        </center>
                    </font>
                    <br>

                </div>

           </form>

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
