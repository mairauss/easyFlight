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

	<h1>Registrierung als Analyst</h1>
<div>     
	<form action="Analystregister" method="POST">   
    <label for="fname">Vorname</label>
    <input type="text" id="fname" name="fname" required>

    <label for="lname">Nachname</label>
    <input type="text" id="lname" name="lname" required>
    
    <label for="password">Passwort für Analysten</label>
    <input type="password" id=password1 name="password1" required>
    
    <label for="password">Ihr Passwort</label>
    <input type="password" id=password2 name="password2" required>
    
 	<input type="submit" value="Als Analyst registrieren">
	</form>
</div>

	<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>