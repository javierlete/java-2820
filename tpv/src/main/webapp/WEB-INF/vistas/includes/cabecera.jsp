<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="modelos.*"%>
<%@ page import="java.util.ArrayList"%>
<%
String usuarioLogin = (String)session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TPV</title>
<link rel="stylesheet" href="css/tpv.css">
</head>
<body>

<nav>
	<ul>
		<%=usuarioLogin != null ? "<li>" + usuarioLogin + "</li>": "" %>
		<li><a href="reservas">Reservas</a></li>
		<li><a href="mesas">Mesas</a></li>
		<li><a href="login">Inicio sesión</a></li>
		<li><a href="logout">Cerrar sesión</a></li>
	</ul>
</nav>
