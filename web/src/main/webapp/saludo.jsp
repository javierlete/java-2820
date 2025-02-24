<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saludo</title>
</head>
<body>

<form action="saludo.jsp" method="post">
	<input name="nombre" placeholder="Nombre">
	<input type="password" name="password" placeholder="Contraseña">
	<button>Saludar</button>
	<span>Hola <%=request.getParameter("nombre") %></span>
</form>

</body>
</html>