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
		<li><a href="seestatistic.jsp">See Statistics</a></li>
		<li><a class="active" href="setparameters.jsp">set Parameters</a></li>
	</ul>
	<form action="LogoutServlet" method="POST">
		<button style="width: auto;">Logout</button>
	</form>
	<br></br>
	<br></br>
	<br></br>
	
	 
	 <br></br>
	
	<br></br>
		<center>
		<h3>Hier können Sie eine Preissenkung aller Fluege mit den unten stehenden Kriterien veranlassen</h3>
	 			<form action="Setparametersservlet" method="POST">
	 			     
		 			<input type="text" id="auslastung" name="auslastung" placeholder="Auslastung in Prozent" required>
		 			<br>				
					<input type="text" id="verkleinert" name="verkleinert" placeholder="Ermäßing in Prozent" required>
					<br>
					<input type="submit" value="OK!">
					
				</form>				
	 </center>
	
	<br></br>
	
<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>