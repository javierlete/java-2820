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
	
	<form method="post">
		<input name="hora" type="datetime-local" placeholder="Hora">
		<input name="cuantos" type="number" placeholder="Cuantos">
		<input name="cliente" placeholder="Cliente">
		
		<button>Añadir</button>
	</form>
	
	<ul>
		<% for(Reserva r: reservas) { %>
			<li>
				<%=r.getHora()%>
				:
				<%=r.getParaCuantos()%>
				para
				<%=r.getNombreCliente()%>
			</li>
		<% } %>
	</ul>
	
</body>
</html>