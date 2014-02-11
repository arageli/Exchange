<%@page import="org.exchange.entity.Currency"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Exchange/WebContent/jquery-1.9.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Convert</title>
</head>
<body>

	<div align="center">
		<form method="post" action="convert">
		Input amount to convert: <input type="text" value="0.00" name="amount"> 
								 <select name="currencyForExchange">
								 	<option value="1">USD
								 	<option value="2">EU
								 	<option value="3">RUB
								 	<option value="4">UA
								 </select>
		<input type="submit" value="Convert">
		</form> 
		

	</div>
</body>
</html>