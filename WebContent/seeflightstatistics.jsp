<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="easyflight.analyst.Analyst"
    import="easyflight.flug.FlugManagement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easyFlight: Welcome!</title>
    <link rel="stylesheet" type="text/css" href="css/analyst.css" />
</head>
  <style type="text/css">
<%@include file="css/analyst.css" %>
body {
    background-image: url(css1/clouds_texture2909.jpg);
    }
</style>
<body>
<body>
	<img src="css/easyflight.jpg" alt="logo" width="294" height="112" align="left" padding=10px;>
	
	<ul>
		<li><a class="active" href="seestatistic.jsp">See Statistics</a></li>
		<li><a href="setparameters.jsp">set Parameters</a></li>
	</ul>
	<form action="LogoutServlet" method="POST">
		<button style="width: auto;">Logout</button>
	</form>
	<br></br>
	<br></br>
	<br></br>
	<center> <% FlugManagement currentFM = null;
				currentFM = (FlugManagement)((session.getAttribute("currentSessionFm")));%> 
	 			<br></br><h2><%= currentFM.seeFStatistics() %> </h2>
	 
	 <br></br>
	
	<br></br>
	 			<form action="Flightstatistic" method="POST">
				<input type="submit" value="See all Statistics">
				</form>
				
				<form action="Flightstatisticforselected" method="POST">
				<input type="submit" value="See statistics for flight:">
				<input type="text" id="idstat" name="idstat" placeholder="FlugID" required>
				</form>
	 </center>
	
	<br></br>
	
<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>