<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download complete</title>
</head>
<body>
<%
	File file = (File) request.getAttribute("file");
%>

	<div align="center">
	<p> File <%=file.getName() %> download complete!</p>
	</div>

</body>
</html>