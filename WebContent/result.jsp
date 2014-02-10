<%@page import="java.util.ArrayList"%>
<%@page import="org.exchange.entity.Currency"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Currency currency = (Currency)request.getAttribute("currency");
	String name = currency.getName();
	
	ArrayList<Double> rateOfUAH = (ArrayList<Double>)request.getAttribute("rateOfUAH");
	ArrayList<Double> results = (ArrayList<Double>)request.getAttribute("results");
	double result = results.get(0);
%>

	
	<div align="left">
	<div>Results : </div><input type="text" value="<%= results.get(0) %>" > <a><%=name %></a> <input type="text" size ="4" value="<%=rateOfUAH.get(0)%>">
						 <br>
						 <input type="text" value="<%= results.get(1) %>" > <a><%=name %></a> <input type="text" size ="4" value="<%=rateOfUAH.get(1)%>">
						 <br>
						 <input type="text" value="<%= results.get(2) %>" > <a><%=name %></a> <input type="text" size ="4" value="<%=rateOfUAH.get(2)%>">
	</div>
	
</body>
</html>