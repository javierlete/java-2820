package controladores;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Mesa;

@WebServlet("/mesas")
public class MesasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();

		mesas.add(new Mesa(1, 1));
		mesas.add(new Mesa(2, 2));
		mesas.add(new Mesa(3, 3));
		mesas.add(new Mesa(4, 4));
		
		request.setAttribute("mesas", mesas);
		
		request.getRequestDispatcher("/WEB-INF/vistas/mesas.jsp").forward(request, response);
	}
}
