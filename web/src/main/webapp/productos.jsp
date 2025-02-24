<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp" %>
<%
String sIdBorrar = request.getParameter("idBorrar");

if(sIdBorrar != null) {
	Integer idBorrar = Integer.parseInt(sIdBorrar);
	
	Global.DAO.borrar(idBorrar);
}

%>

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

<%@ include file="/includes/pie.jsp" %>