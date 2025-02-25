package controladores;

import java.io.IOException;
import java.util.ArrayList;

import globales.Global;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Producto;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recibir la información de la petición
		String sIdBorrar = request.getParameter("idBorrar");

		if(sIdBorrar != null) {
			// Convertir los datos si es necesario
			Integer idBorrar = Integer.parseInt(sIdBorrar);
			
			// Ejecutar la lógica de negocio
			Global.DAO.borrar(idBorrar);
		}
		
		// Ejecutar la lógica de negocio
		ArrayList<Producto> productos = Global.DAO.buscarTodos();

		// Almacenar objeto de modelo para la vista
		request.setAttribute("productos", productos);
		
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/productos.jsp").forward(request, response);
	}

}
