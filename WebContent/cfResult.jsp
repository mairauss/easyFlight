 page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easyFlight: Result</title>
    <link rel="stylesheet" type="text/css" href="css1/indexcss.css" />
</head>
<style type="text/css">
<%@include file="css1/indexcss.css" %>
body {
    background-image: url(css1/clouds_texture2909.jpg);
    }
</style>
<body>
<body>
	<img src="css/easyflight.jpg" alt="logo" width="294" height="112" align="left" padding=10px;>
	<ul>
	    <li><a href="CreateFlight.jsp">Create Flight</a></li>
		<li><a href="CancelFlight.jsp">Cancel Flight</a></li>
		<li><a href="CreateCombi.jsp">Create Combi</a></li>
		<li><a href="ChangeTicketPrice.jsp">Change Ticket Price</a></li>
	</ul>

	<br></br>
	<br></br>
	<h1>Flight: Result</h1>
    <p> ${Flug}</p>
    
<form action="indexFG.jsp">
 		<input type="submit" value="Zur Startseite">
</form>


<br></br><br></br><br></br> <br></br><br></br><br></br>
<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>