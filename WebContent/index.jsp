<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>easyFlight</title>
</head>
<style type="text/css">
<%@include file="css/indexcss.css" %>
</style>

<body>
	<img src="css/easyflight.png" alt="logo" width="294" height="112">
	<%-- Login start --%>

	<button onclick="document.getElementById('id01').style.display='block'"
		style="width: auto;">Login</button>

	<div id="id01" class="modal">

		<form class="modal-content animate" action="LoginServlet" method="post">

			<div class="container">
				<label><b>ID</b></label> <input type="text"
					placeholder="Enter ID" name="id" required> <label><b>Password</b></label>
				<input type="password" placeholder="Enter Password" name="psw"
					required>

				<button type="submit">Login</button>
			</div>

			<div class="container" style="background-color: #f1f1f1"></div>
			
		</form>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

	<%-- Login end --%>

	<ul>
		<li><a class="active" href="#hinflug">Hinflug</a></li>
		<form id="myForm" action="SeeCombi" method="post"> 
		<li><a href="#hinflug" class="active" onclick="myForm.submit();">Angebote</a></li>
		 </form>	

	
		<li style="float: right"><a class="active" href="register.jsp">Registrieren</a></li>
	</ul>
	

	<form action="SearchServlet" method="POST">
		<input type="text2" id="start" name="start"	placeholder="Start"> 
		<input type="text2" id="ziel" name="ziel" placeholder="Ziel">
		<input type="submit" value="Search">
	
<br></br>
	Bitte Datum eingeben:
	<input type="date" name="date" placeholder="TT-MM-YYYY">
	</form>
	<br></br>
	<img id="flugzeug" src="css/flugzeug.jpg" width="600" height="255">

	<h1>Was ist easyFlight?</h1>

	<div id="wrapper">
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