<%@page import="globales.Global"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelos.Producto"%>
<%@page import="daos.ProductoDao"%>
<%
String sId = request.getParameter("id");

Producto p = null;

if (sId != null) {
	Integer id = Integer.parseInt(sId);
	p = Global.DAO.buscarPorId(id);
}

String sIdProducto = request.getParameter("idProducto");
String nombre = request.getParameter("nombre");
String sPrecio = request.getParameter("precio");
String descripcion = request.getParameter("descripcion");

if (nombre != null) {
	Integer idProducto = sIdProducto.isBlank() ? null : Integer.parseInt(sIdProducto);
	double precio = Double.parseDouble(sPrecio);

	Producto producto = new Producto(idProducto, nombre, precio, descripcion);

	if (idProducto == null) {
		Global.DAO.insertar(producto);
	} else {
		Global.DAO.modificar(producto);
	}

	response.sendRedirect("productos.jsp");

	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de producto</title>
</head>
<body>

	<form>
		<input name="idProducto" placeholder="Id"
			value="<%=p != null ? p.getId() : ""%>"> <input name="nombre"
			placeholder="Nombre" value="<%=p != null ? p.getNombre() : ""%>">
		<input type="number" step=".01" name="precio" placeholder="Precio"
			value="<%=p != null ? p.getPrecio() : ""%>">
		<textarea name="descripcion" placeholder="Descripción"><%=p != null ? p.getDescripcion() : ""%></textarea>

		<button>Guardar</button>
	</form>

</body>
</html>