<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola desde JSP</title>
</head>
<body>

	<h1>Hola desde JSP</h1>
	
	<h2><%= new Date() %></h2>
	
	<ul>
	<% for(int c = 1; c <= 5; c++) { %>
		<li><%=c %></li>
	<% } %>
	</ul>

</body>
</html>