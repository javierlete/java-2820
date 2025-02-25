<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/cabecera.jsp" %>

<%
Producto p = (Producto)request.getAttribute("producto");
%>

	<form method="post">
		<input name="idProducto" placeholder="Id"
			value="<%=p != null ? p.getId() : ""%>"> <input name="nombre"
			placeholder="Nombre" value="<%=p != null ? p.getNombre() : ""%>">
		<input type="number" step=".01" name="precio" placeholder="Precio"
			value="<%=p != null ? p.getPrecio() : ""%>">
		<textarea name="descripcion" placeholder="Descripción"><%=p != null ? p.getDescripcion() : ""%></textarea>

		<button>Guardar</button>
	</form>
<%@ include file="/includes/pie.jsp" %>