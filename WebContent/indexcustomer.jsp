<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"
  import="easyflight.customer.Customer"%>
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
 
  <form action="LogoutServlet" method="POST">
    <button style="width: auto;">Logout</button>
  </form>

  <ul>
    <li><a class="active" href="#hinflug">Hinflug</a></li>
    <form id="myForm" action="SeeCombi" method="post"> 
		<li><a href="#hinflug" class="active" onclick="myForm.submit();">Angebote</a></li>
	 </form>
  </ul>
  <form action="BuchungsServlet" method="POST">
    <button style="width: 70px;">Meine Buchungen</button>
  </form>
  <form action="SearchServletforRegistered" method="POST">
    <input type="text2" id="start" name="start"  placeholder="Start"> 
    <input type="text2" id="ziel" name="ziel" placeholder="Ziel">
    <input type="submit" value="Search">
  <br></br>
 
  Bitte Datum eingeben:
  <input type="date" name="date" placeholder="TT-MM-YYYY">
  </form>
   <form action="ShowFav" method="Post">
 	<button style="width: 70px;">Meine Favouriten</button>
 </form>
 
  <br></br>
   <br></br>
 <form action="meineMeilen" method="Post">
 	<button style="width: 70px;">Meine Meilen</button>
 </form>
 
<br></br>
  <center> <% Customer currentCustomer = null;
        currentCustomer = (Customer)((session.getAttribute("currentSessionCustomer")));%> 
         <h2>Wilkommen <%= currentCustomer.getVorname() %> </h2>
   </center>
   </form>
  <br></br>
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