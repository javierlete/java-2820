<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="modelos.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav>
	<ul>
		<li><%=session.getAttribute("usuario")%></li>
		<li><a href="reservas">Reservas</a></li>
		<li><a href="mesas">Mesas</a></li>
		<li><a href="login">Inicio sesión</a></li>
		<li><a href="logout">Cerrar sesión</a></li>
	</ul>
</nav>
