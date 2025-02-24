<%@page import="globales.Global"%>
<%@page import="modelos.Producto"%>
<%@page import="daos.ProductoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String sIdBorrar = request.getParameter("idBorrar");

if(sIdBorrar != null) {
	Integer idBorrar = Integer.parseInt(sIdBorrar);
	
	Global.DAO.borrar(idBorrar);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo de JDBC con DAO en Web</title>
</head>
<body>

	<ul>
		<%
		for (Producto p : Global.DAO.buscarTodos()) {
		%>
		<li><a href="producto.jsp?id=<%=p.getId()%>"><%=p.getNombre()%>
		</a> <a href="productos.jsp?idBorrar=<%=p.getId()%>">Borrar</a></li>
		<%
		}
		%>

	</ul>

	<div>
		<a href="producto.jsp">Añadir</a>
	</div>

</body>
</html>