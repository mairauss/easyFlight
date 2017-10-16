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
<%@include file="css1/indexcss.css" %>
body {
    background-image: url(css1/clouds_texture2909.jpg);
    }
</style>
<body>
<body>
	<img src="css/easyflight.jpg" alt="logo" width="294" height="112" align="left" padding=10px;>
	<ul>
		<li><a class="active" href="CreateFlight.jsp">Create Flight</a></li>
		<li><a href="CancelFlight.jsp">Cancel Flight</a></li>
		<li><a href="CreateCombi.jsp">Create Combi</a></li>
		<li><a href="ChangeTicketPrice.jsp">Change Ticket Price</a></li>
	</ul>

	<br></br>
	<form action="LogoutServlet" method="POST">
		<button style="width: auto;">Logout</button>
	</form>
	<br></br>
	
<form method="GET" action="CreateFlight" class="grid_6">
<br></br>
<center> <% Fluggesellschaft currentFG = null;
	 			currentFG = (Fluggesellschaft)((session.getAttribute("currentSessionFG")));%> 
	 			<br></br><h2>Hier können Sie einen Flug erstellen, <%= currentFG.getName() %> </h2>
	 </center>
	<br></br>
	<br></br>
ID <font color=red>*</font>: <input type="text" placeholder="ID" name="ID"><br></br>
Start Country <font color=red>*</font>: <input type="text" placeholder="Start Country" name="StartCountry"><br></br>
Destination Country <font color=red>*</font>: <input type="text" placeholder="Destination Country" name="DestinationCountry"><br></br>
Start Airport <font color=red>*</font>: <input type="text" placeholder="Start Airport" name="StartAirport"><br></br>
Destination Airport <font color=red>*</font>: <input type="text" placeholder="Destination Airport" name="DestinationAirport"><br></br><br></br>
Date <font color=red>*</font>: <input type="date" name="date" placeholder="TT-MM-YYYY"><br></br><br></br>
Start Time <font color=red>*</font>: <input type="text" placeholder="Start Time" name="StartTime"><br></br>
Arrival Time <font color=red>*</font>: <input type="text" placeholder="Arrival Time" name="ArrivalTime">
<br></br><br></br>
Capacity <font color=red>*</font>: <input type="number" placeholder="Capacity" name="Capacity">
Reserved Seats <font color=red>*</font>: <input type="number" placeholder="Reserved Seats" name="ReservedSeats">
Miles <font color=red>*</font>: <input type="number" placeholder="Miles" name="Miles">
Ticket Price <font color=red>*</font>: <input type="number" placeholder="Ticket Price" name="TicketPrice">
<br></br><br></br>
Additional Information: <font color=red>**</font>: <input type="text" placeholder="Additional Information" name="AddInfo">
<br></br>
<input type="submit" class="button" value="Confirm">
<br></br> <br></br>
<font color=red>*</font> Indicates required field
<br>
<font color=red>**</font> Indicates requires field under special circumstances
</form>


<footer> <section id="copyright">
	<div class="wrapper">&copy; Copyright 2016 by Team easyFlight.
		All Rights Reserved.</div>
	</section> </footer>
</body>
</html>