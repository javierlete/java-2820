<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Reserva> reservas = (ArrayList<Reserva>) request.getAttribute("reservas");

@SuppressWarnings("unchecked")
ArrayList<Mesa> mesas = (ArrayList<Mesa>) request.getAttribute("mesas");
%>

<form method="post">
	<input name="hora" type="datetime-local" placeholder="Hora" required
		min="<%=java.time.LocalDateTime.now().plusHours(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))%>">
	<input name="cuantos" type="number" placeholder="Cuantos" required
		min="1"> <input name="cliente" placeholder="Cliente" required
		minlength="2">

	<button>Añadir</button>
</form>

<%
if (usuarioLogin != null) {
%>

<ul>
	<%
	for (Reserva r : reservas) {
	%>
	<li>
		<form action="reserva">
			<%=r.getHora().format(DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm"))%>
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

<%
}
%>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>