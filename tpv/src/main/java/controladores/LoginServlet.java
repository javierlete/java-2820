package controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recibir la información de la petición
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

//		Convertir los datos si es necesario
//		Empaquetar los datos en un objeto del modelo
//		Ejecutar la lógica de negocio
		if(usuario.equals("javier") && password.equals("ipartek")) {
//			Almacenar objeto de modelo para la vista
//			Saltar a la siguiente vista
			
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect("reservas");
		} else {
//			Almacenar objeto de modelo para la vista
//			Saltar a la siguiente vista
			response.sendRedirect("login");
		}
		

	}

}
