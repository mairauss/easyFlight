<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
        import="easyflight.fluggesellschaft.Fluggesellschaft"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easyFLight:Change Ticket Price</title>
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
		<li><a class="active" href="ChangeTicketPrice.jsp">Change Ticket Price</a></li>
	</ul>
	

	<br></br>
	<form action="LogoutServlet" method="POST">
		<button style="width: auto;">Logout</button>
	</form>
	<br></br>
	
<br></br>
<br></br>
<center> <% Fluggesellschaft currentFG = null;
	 			currentFG = (Fluggesellschaft)((session.getAttribute("currentSessionFG")));%> 
	 			<br></br><h2> Hier koennen Sie "Ticket Price" aendern, <%= currentFG.getName() %> </h2>
	 </center>
	<br></br>
	
	
<form method="GET" action="ChangeTicketPrice" class="grid_6">
<br></br><br></br>
	<br></br>
Flight ID <font color=red>*</font>: <input type="text" placeholder="ID" name="ID"><br></br>

New Ticket Price <font color=red>*</font>: <input type="text" placeholder="Ticket Price" name="TicketPrice"><br></br>
<br></br>
<input type="submit" class="button" value="Confirm">
<br></br> <br></br>
<font color=red>*</font> Indicates required field
</form>
<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>