package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bibliotecas.BaseDeDatos;
import modelos.Reserva;

public class ReservaDao implements Dao<Reserva> {
	private static final String SQL_SELECT = "SELECT * FROM reservas";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=";

	private static final String SQL_INSERT = "INSERT INTO reservas (nombre, cuantos, hora) VALUES ('%s', %s, '%s')";
	private static final String SQL_UPDATE = "UPDATE reservas SET nombre='%s', cuantos=%s, hora='%s' WHERE id=%s";
	private static final String SQL_DELETE = "DELETE FROM reservas WHERE id=";

	private BaseDeDatos bdd;

	public ReservaDao(String url, String usuario, String password) {
		bdd = new BaseDeDatos(url, usuario, password);
	}

	public ArrayList<Reserva> buscarTodos() {
		try (ResultSet rs = bdd.consulta(SQL_SELECT)) {
			ArrayList<Reserva> reservas = new ArrayList<>();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int cuantos = rs.getInt("cuantos");
				LocalDateTime hora = LocalDateTime.parse(rs.getString("hora"));

				Reserva reserva = new Reserva(id, nombre, cuantos, hora);

				reservas.add(reserva);
			}

			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta a la base de datos", e);
		}
	}

	public Reserva buscarPorId(int id) {
		try (ResultSet rs = bdd.consulta(SQL_SELECT_ID + id)) {

			Reserva reserva = null;

			if (rs.next()) {
				String nombre = rs.getString("nombre");
				int cuantos = rs.getInt("cuantos");
				LocalDateTime hora = LocalDateTime.parse(rs.getString("hora"));

				reserva = new Reserva(id, nombre, cuantos, hora);
			}

			return reserva;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta a la base de datos", e);
		}
	}

	public void insertar(Reserva reserva) {
		String nombre = reserva.getNombreCliente();
		int cuantos = reserva.getParaCuantos();
		String hora = reserva.getHora().toString();
		
		String sql = String.format(SQL_INSERT, nombre, cuantos, hora);

		bdd.cambio(sql);
	}

	public void modificar(Reserva reserva) {
		Integer id = reserva.getId();
		String nombre = reserva.getNombreCliente();
		int cuantos = reserva.getParaCuantos();
		String hora = reserva.getHora().toString();
		
		String sql = String.format(SQL_UPDATE, nombre, cuantos, hora, id);

		bdd.cambio(sql);
	}

	public void borrar(int id) {
		bdd.cambio(SQL_DELETE + id);
	}

}
