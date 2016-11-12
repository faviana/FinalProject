<%--
  Created by IntelliJ IDEA.
  User: favianalopez
  Date: 11/10/16
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        div.background {
            background: url(http://domestikatedlife.files.wordpress.com/2011/10/moodboard_hillary.jpg) repeat;
            border: 2px solid black;
        }

        div.transbox {
            margin: 30px;
            background-color: #ffffff;
            border: 1px solid black;
            opacity: 0.6;
            filter: alpha(opacity=60);
        }

        div.transbox p {
            margin: 5%;
            font-weight: bold;
            color: #000000;
        }
    </style>
</head>
<body>

<div class="background">
    <div class="transbox">
        <p>Planning With Favi is a web application that helps an individual
            plan an event or a party.
            We are here to remind you of all the
            task that you may have forgotten about the event; like, sending
            invitations, or picking up candles for the birthday cake.
            Wemake your planning experience fun and stress free!!!.
            Click below to get started
        </p>

</div>
</div>
<p/>

<form action="home.jsp" method="get">

    <center>
        <button type="submit">
            Create New Event
        </button>
    </center>

</form>
<p/>

<form action="/event/ListAll" method="get">

    <center>
        <button type="submit">
            Go To existing Events
        </button>
    </center>


</form>

</body>
</html>
