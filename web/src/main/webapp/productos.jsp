<%@page import="modelos.Producto"%>
<%@page import="daos.ProductoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ProductoDao dao = new ProductoDao("jdbc:sqlite:C:\\Users\\java.IPARTEKAULA\\git\\java-2820\\bases\\bdd\\ejemplo.sqlite", "", ""); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo de JDBC con DAO en Web</title>
</head>
<body>

<ul>
	<% for(Producto p: dao.buscarTodos()) { %>
		<li><a href="producto.jsp?id=<%=p.getId()%>"><%=p.getNombre()%> </a></li>
	<% } %>
</ul>

</body>
</html>