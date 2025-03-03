<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
<%
@SuppressWarnings("unchecked")
ArrayList<Mesa> mesas = (ArrayList<Mesa>) request.getAttribute("mesas");
%>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Capacidad</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (Mesa m : mesas) {
			%>
			<tr>
				<td><%=m.getId()%></td>
				<td><%=m.getCapacidad()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>