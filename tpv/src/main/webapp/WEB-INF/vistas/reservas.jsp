<%@page import="modelos.Mesa"%>
<%@page import="modelos.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Reserva> reservas = (ArrayList<Reserva>) request.getAttribute("reservas");

@SuppressWarnings("unchecked")
ArrayList<Mesa> mesas = (ArrayList<Mesa>) request.getAttribute("mesas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservas</title>
</head>
<body>
	<h1>Reservas</h1>

	<p><%=session.getAttribute("usuario") %></p>

	<form method="post">
		<input name="hora" type="datetime-local" placeholder="Hora"> <input
			name="cuantos" type="number" placeholder="Cuantos"> <input
			name="cliente" placeholder="Cliente">

		<button>Añadir</button>
	</form>

	<% if(session.getAttribute("usuario") != null) { %>

	<ul>
		<%
		for (Reserva r : reservas) {
		%>
		<li>
			<form action="reserva">
				<%=r.getHora()%>
				:
				<%=r.getParaCuantos()%>
				para
				<%=r.getNombreCliente()%>

				<input type="hidden" name="id" value="<%=r.getId()%>"> <select
					name="mesa">
					<option value="0">NO</option>

					<%
					for (Mesa m : mesas) {
						if (m.getCapacidad() >= r.getParaCuantos()) {
					%>
					<option value="<%=m.getId()%>"
						<%=r.getMesa() == m.getId() ? "selected" : ""%>><%=m.getId()%>
						-
						<%=m.getCapacidad()%>pax
					</option>
					<%
						}
					}
					%>
				</select>

				<button>Reservar</button>
			</form>
		</li>
		<%
		}
		%>
	</ul>

	<% } %>
</body>
</html>