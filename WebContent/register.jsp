<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrierung</title>
</head>
<style type="text/css">
<%@include file="css/registercss.css" %>
</style>
<body>
	<img src="css/easyflight.png" alt="logo" width="294" height="112">

	<h1>Registrierung</h1>
<div>
  <form action="Userregister" method="POST">
    <label for="fname">Vorname</label>
    <input type="text" id="fname" name="fname" required>

    <label for="lname">Nachname</label>
    <input type="text" id="lname" name="lname" required>
	
    <label for="lname">Ort</label>
    <input type="text" id="ort" name="ort" required>
    
    <label for="password">Passwort</label>
    <input type="password" id=password name="password" required>
    <br></br>
    <label for="lname">Geburtsdatum</label>
    <input type="date" id=gdatum name="gdatum" placeholder = "TT-MM-YYYY" required>
    <br></br>
 
 	
 		<input type="submit" value="Als Kunde registrieren">
 	</form>
 	<form action="fgregister.jsp">
 		<input type="submit" value="Als Fluggesellschaft registrieren">
	</form>
	<form action="analystregister.jsp">
		<input type="submit" value="Als Analyst registrieren">
  	</form>
</div>

	<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>