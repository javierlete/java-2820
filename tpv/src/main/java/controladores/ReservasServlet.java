package controladores;

import java.io.IOException;

import daos.ReservaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reservas")
public class ReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservaDao dao = new ReservaDao("jdbc:sqlite:C:\\Users\\java.IPARTEKAULA\\git\\java-2820\\tpv\\bdd\\tpv.sqlite", "", "");
		
		request.setAttribute("reservas",  dao.buscarTodos());
		
		request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
	}

}
