<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelos.Producto"%>
<%@page import="daos.ProductoDao"%>
<%
ProductoDao dao = new ProductoDao("jdbc:sqlite:C:\\Users\\java.IPARTEKAULA\\git\\java-2820\\bases\\bdd\\ejemplo.sqlite",
		"", "");

String sId = request.getParameter("id");

Producto p = null;

if (sId != null) {
	Integer id = Integer.parseInt(sId);
	p = dao.buscarPorId(id);
}

String nombre = request.getParameter("nombre");
String sPrecio = request.getParameter("precio");
String descripcion = request.getParameter("descripcion");

if (nombre != null) {

	double precio = Double.parseDouble(sPrecio);

	Producto producto = new Producto(null, nombre, precio, descripcion);

	dao.insertar(producto);

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
		<input name="nombre" placeholder="Nombre" value="<%=p != null ? p.getNombre() : ""%>">
		<input type="number" step=".01" name="precio" placeholder="Precio"
			value="<%=p != null ? p.getPrecio() : ""%>">
		<textarea name="descripcion" placeholder="Descripción"><%=p != null ? p.getDescripcion() : "" %></textarea>

		<button>Guardar</button>
	</form>

</body>
</html>