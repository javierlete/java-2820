package controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Reserva;

@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recibir la información de la petición
		String sId = request.getParameter("id");
		String sMesa = request.getParameter("mesa");
		
//		Convertir los datos si es necesario
		Integer id = Integer.parseInt(sId);
		Integer mesa = Integer.parseInt(sMesa);
		
//		Empaquetar los datos en un objeto del modelo
		Reserva reserva = new Reserva(id, null, null, null, mesa);
		
//		Ejecutar la lógica de negocio
		System.out.println(reserva);
		
//		Almacenar objeto de modelo para la vista
//		Saltar a la siguiente vista
		response.sendRedirect("reservas");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
