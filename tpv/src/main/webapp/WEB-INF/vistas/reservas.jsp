<%@page import="modelos.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Reserva> reservas = (ArrayList<Reserva>)request.getAttribute("reservas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservas</title>
</head>
<body>
	<h1>Reservas</h1>
	
	<pre><%=reservas %></pre>
</body>
</html>