package ejemploconsolajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bibliotecas.Consola;

public class EjemploConsolaJdbc {
	private static final String URL = "jdbc:sqlite:bdd/ejemplo.sqlite";
	private static final String USER = "";
	private static final String PASS = "";
	
	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=";
	
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, descripcion) VALUES ('%s', %s, '%s')";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre='%s', precio=%s, descripcion='%s' WHERE id=%s";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=";

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();

			opcion = Consola.pedirEntero("Elige una opción");

			procesarOpcion(opcion);
		} while (opcion != 0);
	}

	private static void mostrarMenu() {
		System.out.println("""
				Menú
				====

				1. Listado
				2. Buscar por id
				3. Añadir
				4. Modificar
				5. Borrar

				0. Salir

				""");
	}
	
	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			buscarPorId();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			System.out.println("Gracias por usar esta aplicación");
			break;
		default:
			System.out.println("Opción no reconocida");
		}
	}

	private static void listado() {
		try (ResultSet rs = consulta(SQL_SELECT)) {
			while (rs.next()) {
				mostrarRegistro(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta a la base de datos");
		}
	}

	private static void buscarPorId() {
		int id = Consola.pedirEntero("Dime el id a buscar");

		try (ResultSet rs = consulta(SQL_SELECT_ID + id)) {
			if (rs.next()) {
				mostrarRegistro(rs);
			} else {
				System.out.println("No se ha encontrado");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta a la base de datos");
		}
	}
	
	private static void insertar() {
		String nombre = Consola.pedirTexto("Nombre");
		double precio = Consola.pedirEntero("Precio");
		String descripcion = Consola.pedirTexto("Descripción");
		
		String sql = String.format(SQL_INSERT, nombre, precio, descripcion);
		
		cambio(sql);
	}

	private static void modificar() {
		int id = Consola.pedirEntero("Id");
		String nombre = Consola.pedirTexto("Nombre");
		double precio = Consola.pedirEntero("Precio");
		String descripcion = Consola.pedirTexto("Descripción");
		
		String sql = String.format(SQL_UPDATE, nombre, precio, descripcion, id);
		
		cambio(sql);
	}

	private static void borrar() {
		int id = Consola.pedirEntero("Dime el id a borrar");

		cambio(SQL_DELETE + id);
	}

	private static Connection conectar() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new RuntimeException("Ha fallado la conexión a la base de datos");
		}
	}
	
	private static ResultSet consulta(String sql) {
		try {
			Connection con = conectar();
			Statement st = con.createStatement();
			
			return st.executeQuery(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta");
		}
	}
	
	private static int cambio(String sql) {
		try {
			Connection con = conectar();
			Statement st = con.createStatement();
			
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta");
		}
	}

	private static void mostrarRegistro(ResultSet rs) throws SQLException {
		System.out.printf("%5s %-15s %10s %-20s\n", rs.getString("id"), rs.getString("nombre"),
				rs.getString("precio"), rs.getString("descripcion"));
	}
}
