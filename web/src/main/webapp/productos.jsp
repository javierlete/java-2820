<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp" %>
<%
@SuppressWarnings("unchecked")
ArrayList<Producto> productos = (ArrayList<Producto>)request.getAttribute("productos");
%>
	<ul>
		<%
		for (Producto p: productos) {
		%>
		<li><a href="producto?id=<%=p.getId()%>"><%=p.getNombre()%>
		</a> <a href="productos?idBorrar=<%=p.getId()%>">Borrar</a></li>
		<%
		}
		%>
	</ul>

	<div>
		<a href="producto">Añadir</a>
	</div>

<%@ include file="/includes/pie.jsp" %>