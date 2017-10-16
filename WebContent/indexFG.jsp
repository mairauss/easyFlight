<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="easyflight.fluggesellschaft.Fluggesellschaft"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easyFlight: Welcome!</title>
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
	<form action="LogoutServlet" method="POST">
		<button style="width: auto;">Logout</button>
	</form>
	<br></br>
	<br></br>
	<br></br>
	 <center> <% Fluggesellschaft currentFG = null;
	 			currentFG = (Fluggesellschaft)((session.getAttribute("currentSessionFG")));%> 
	 			<br></br><h2>Wilkommen auf der Seite für Fluggesellschaften, <%= currentFG.getName() %> </h2>
	 </center>
	
	<br></br>
	
	
	<div id="wrapper">
	<br></br>
	<img id="flugzeug" src="css/flugzeug.jpg" width="600" height="255">
	<h1>Was ist easyFlight?</h1>
	
		easyFlight ist ein von 4 Studierenden entwickeltes Flugportal. Hier
		können Benutzer nach Flüge suchen und sobald sie registriert sind auch
		buchen. Selbstverständlich müssen Fluggesellschaften diese auch
		anbieten. Diese können sich einloggen und dann einen Flug anbieten.
		<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
			diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam
			erat, sed diam voluptua. At vero eos et accusam et justo duo dolores
			et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est
			Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur
			sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et
			dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam
			et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea
			takimata sanctus est Lorem ipsum dolor sit amet.
	</div> 
	
<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>