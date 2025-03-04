<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
String error = (String) request.getAttribute("error");
%>

<form method="post">
	<input name="usuario" placeholder="Usuario"> <input
		name="password" placeholder="Contraseña" type="password">

	<button>Iniciar sesión</button>

	<p class="error"><%= error != null ? error : "" %></p>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
