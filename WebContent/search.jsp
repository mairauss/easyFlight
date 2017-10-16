<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"
  import="easyflight.customer.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search for flight</title>
</head>
<style type="text/css">
<%@include file="css/searchcss.css" %>
</style>
<body>
<% String s = null;
		Customer c = (Customer)((session.getAttribute("currentSessionCustomer")));
		if(c==null){
			s = "index.jsp";
		}else{
			s = "indexcustomer.jsp";
		}%> 
<form action=<%= s %> method="POST">
		<input type="submit" id="backtohome" value="<--Back to Home">
</form>


