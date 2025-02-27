<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Mesa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<Mesa> mesas = new ArrayList<Mesa>();

mesas.add(new Mesa(1, 4));
mesas.add(new Mesa(2, 6));
mesas.add(new Mesa(3, 3));
mesas.add(new Mesa(4, 10));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mesas</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Capacidad</th>
		</tr>
	</thead>
	
	<tbody>
		<% for(Mesa m: mesas) { %>
		<tr>
			<td><%=m.getId() %></td>
			<td><%=m.getCapacidad() %></td>
		</tr>
		<% } %>
	</tbody>
</table>

</body>
</html>