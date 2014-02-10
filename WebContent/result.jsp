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
	double rate = currency.getRate();
	double amount = currency.getAmount();
	Double result =(Double)request.getAttribute("result");
%>

<div align="left">
		Currency to convert : <%=name%>
		Current rate of UAH :<%=rate%>
		Amount to convert: <%=amount %>
</div>
	
	<div align="left">
	<div>Results : </div><input type="text" value="<%=result.doubleValue()%>" > <a><%=name %></a> <input type="text" size ="4" value="<%=rate%>">
	</div>
	
</body>
</html>