package controladores;

import java.io.IOException;
import java.time.LocalDateTime;

import daos.Dao;
import daos.MesaDao;
import daos.ReservaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Mesa;
import modelos.Reserva;

@WebServlet("/reservas")
public class ReservasServlet extends HttpServlet {
	private static final String URL = "jdbc:sqlite:C:\\Users\\java.IPARTEKAULA\\git\\java-2820\\tpv\\bdd\\tpv.sqlite";
	private static final String USER = "";
	private static final String PASS = "";

	private static final long serialVersionUID = 1L;

	public static final Dao<Reserva> DAO_RESERVAS = new ReservaDao(
			URL, USER, PASS);
	public static final Dao<Mesa> DAO_MESAS = new MesaDao(URL, USER, PASS);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("reservas", DAO_RESERVAS.buscarTodos());
		request.setAttribute("mesas", DAO_MESAS.buscarTodos());

		request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recibir la información de la petición
		String sHora = request.getParameter("hora");
		String sCuantos = request.getParameter("cuantos");
		String cliente = request.getParameter("cliente");
		
//		Convertir los datos si es necesario
		LocalDateTime hora = LocalDateTime.parse(sHora);
		int cuantos = Integer.parseInt(sCuantos);
		
//		Empaquetar los datos en un objeto del modelo
		Reserva reserva = new Reserva(null, cliente, cuantos, hora);
		
//		Ejecutar la lógica de negocio
		DAO_RESERVAS.insertar(reserva);
		
//		Almacenar objeto de modelo para la vista
		
//		Saltar a la siguiente vista
		response.sendRedirect("reservas");
	}

}
