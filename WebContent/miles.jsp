<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="easyflight.fluggesellschaft.Fluggesellschaft"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easyFlight:Create Flight</title>
    <link rel="stylesheet" type="text/css" href="css1/indexcss.css" />
</head>
<style type="text/css">
<%@include file="css/indexcss.css" %>
body {
    background-image: url(css1/clouds_texture2909.jpg);
    }
</style>
<body>
<body>
	<img src="css/easyflight.jpg" alt="logo" width="294" height="112" align="left" padding=10px;>
	<br></br>
	<form action="indexcustomer.jsp" method="POST">
		<button style="width: auto;">Zurück</button>
	</form>
	<br></br>
	<br></br>
	<br></br>
	
<form method="POST" action="Miles">
<center>
	<h2>Möchtes sie Flugmeilen setzen?</h2>
	<input type="number" placeholder="Miles" name="Miles" id="Miles">
	<input type="submit" class="button" value="Bestätigen">

</center>
<br></br>
</form>


<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>