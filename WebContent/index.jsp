<%@page import="org.exchange.entity.Currency"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Convert</title>
</head>
<body>

	<div align="center">
		Input amount to convert: <input type="text" value="0.00" id="amount"
			name="amount"> UAH 
	<button type="button" onclick=" sendDataToServer()">Convert</button>
	
	<br>
	<br>
	
	<input id="result1" type="text"> <input id="result4" size="4">  <input id="result7" size="4">
<br>
	<input id="result2" type="text"> <input id="result5" size="4">  <input id="result8" size="4">
<br>
	<input id="result3" type="text"> <input id="result6" size="4">  <input id="result9" size="4">
	</div>
	
	<script type="text/javascript">
		var xmlhttp;
		
		if (window.XMLHttpRequest)
		  {
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		
		function sendDataToServer() {
			xmlhttp.open("GET", "/Exchange/convert?amount="
					+ document.getElementById("amount").value, true);
			xmlhttp.send();
			document.getElementById("amount").value = "0.00";
		}
		
		xmlhttp.onreadystatechange = getResult;
		
		function getResult () {
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
				var str = xmlhttp.responseText;
				var res = [];
				res = str.split("|",9);
		    	for (var i=1; i<res.length+1; i++) {
		    		index = i-1;
		    		document.getElementById("result"+i).value=res[index];
		    	}
		    }
		}
	</script>
</body>
</html>