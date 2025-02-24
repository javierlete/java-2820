<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="modelos.Producto"%>
<%@page import="daos.ProductoDao"%>
<%
String nombre = request.getParameter("nombre");
String sPrecio = request.getParameter("precio");
String descripcion = request.getParameter("descripcion");

if(nombre != null) {
	
	double precio = Double.parseDouble(sPrecio);
	
	Producto producto = new Producto(null, nombre, precio, descripcion);
	
	ProductoDao dao = new ProductoDao("jdbc:sqlite:C:\\Users\\java.IPARTEKAULA\\git\\java-2820\\bases\\bdd\\ejemplo.sqlite", "", "");
	
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
		<input name="nombre" placeholder="Nombre">
		<input type="number" step=".01" name="precio" placeholder="Precio">
		<textarea name="descripcion" placeholder="Descripción"></textarea>
		
		<button>Guardar</button>
	</form>

</body>
</html>