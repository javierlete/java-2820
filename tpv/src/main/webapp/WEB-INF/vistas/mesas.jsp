<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Mesa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Mesa> mesas = (ArrayList<Mesa>) request.getAttribute("mesas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mesas</title>
</head>
<body>
	
	<p><%=session.getAttribute("usuario") %></p>

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

</body>
</html>