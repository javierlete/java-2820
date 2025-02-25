package controladores;

import java.io.IOException;

import globales.Global;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Producto;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recibir la información de la petición
		String sId = request.getParameter("id");

		if (sId != null) {
			// Convertir los datos si es necesario
			Integer id = Integer.parseInt(sId);

			// Ejecutar la lógica de negocio
			Producto producto = Global.DAO.buscarPorId(id);

			// Almacenar objeto de modelo para la vista
			request.setAttribute("producto", producto);
		}
		
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/producto.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recibir la información de la petición
		String sIdProducto = request.getParameter("idProducto");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");
		
		// Convertir los datos si es necesario
		Integer idProducto = sIdProducto.isBlank() ? null : Integer.parseInt(sIdProducto);
		double precio = Double.parseDouble(sPrecio);

		// Empaquetar los datos en un objeto del modelo
		Producto producto = new Producto(idProducto, nombre, precio, descripcion);

		// Ejecutar la lógica de negocio
		if (idProducto == null) {
			Global.DAO.insertar(producto);
		} else {
			Global.DAO.modificar(producto);
		}

		// Saltar a la siguiente vista
		response.sendRedirect("productos");
	}

}
