<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buchung</title>
</head>
<style type="text/css">
<%@include file="css/registercss.css" %>
</style>
<body>

	<img src="css/easyflight.png" alt="logo" width="294" height="112">
	
	<h1>Buchung</h1>
	
	<%
	if(session.getAttribute("plaetzefrei") == "ja") {
		out.print("Sie haben den Platz erfolgreich gebucht!");
	}
	if(session.getAttribute("plaetzefrei") == "nein") 
		out.print("Der Flug ist komplett ausgebucht!");
	%>
	
	
<div>

	<form action="search.jsp">
		<input type="submit" value="Zurück zum Search">
	</form>

</div>

	<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>

</body>
</html>