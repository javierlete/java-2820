package controladores;

import java.io.IOException;

import daos.Dao;
import daos.MesaDao;
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
		Dao<Mesa> dao = new MesaDao("jdbc:sqlite:C:\\Users\\java.IPARTEKAULA\\git\\java-2820\\tpv\\bdd\\tpv.sqlite", "", "");
		
		request.setAttribute("mesas", dao.buscarTodos());
		
		request.getRequestDispatcher("/WEB-INF/vistas/mesas.jsp").forward(request, response);
	}
}
