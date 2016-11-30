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

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Welcome</title>


    <style>
        div.background {
            background: url(http://domestikatedlife.files.wordpress.com/2011/10/moodboard_hillary.jpg) repeat;
            border: 2px solid coral;
        }

        div.transbox {
            margin: 30px;
            background-color: #ffffff;
            border: 1px solid chocolate;
            opacity: 0.6;
            filter: alpha(opacity=60);
        }

        div.transbox p {
            margin: 5%;
            font-weight: bold;
            color: #000000;
        }
    </style>

    <!-- DC Social Icons CSS -->
    <link rel="stylesheet" type="text/css" href="dreamcodes/social_icons/tsc_social_icons.css" />








</head>
<body>

<center>
    <span class="message">Welcome ${eventPlanner.displayName}</span>
</center>


<!-- DC Social Icons CSS -->
<link rel="stylesheet" type="text/css" href="dreamcodes/social_icons/tsc_social_icons.css" />


<div class="background">
    <div class="transbox">
            <font face="cursive">
                <center>
                    <br>
                        Planning With Favi is a web application that helps everyone plan an event or a party.
                    <br>
                        We are here to remind you of all the
                        We make your planning experience fun!
                    <br>
                        Click below to get started
                </center>
            </font>
                    <br>

</div>
</div>


<p/>

<form action="/home.jsp" method="get">

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
            Go To Existing Events
        </button>
    </center>

    <br>

    <div class="background">
        <div class="transbox">
            <center>
            <br>
                <font face="cursive">
                    The Iron Yard: Final Project
                    <br>
                    Originated by: Faviana Lopez
            <p/>
            Contact Information:
            <br>
                    &#9742; 407-473-0803
            <br>
                    &#x2709; ms.faviana@gmail.com
            <p/>

                    <a href="https://twitter.com/Ms_Faviana" class="twitter-follow-button" data-show-count="false">Follow @TwitterDev
                    </a>
                    <script async src="//platform.twitter.com/widgets.js" charset="utf-8">
                    </script>

                    <br>

                    <a href="https://www.linkedin.com/pub/faviana-lopez/12a/980/165">
                        <img src="https://static.licdn.com/scds/common/u/img/webpromo/btn_viewmy_160x25.png" width="160" height="25" border="0" alt="View Faviana Lopez's profile on LinkedIn">
                    </a>

            <br>

            </font>
            </center>


        </div>

    </div>


</form>

<footer class="footer">
    <p>&copy; 2016 5E, Inc.</p>
</footer>
</p>

</body>
</html>
