package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploJdbc {
	private static final String URL = "jdbc:sqlite:bdd/ejemplo.sqlite";
	private static final String USER = "";
	private static final String PASS = "";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	
	@SuppressWarnings("unused")
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=2";
	
	@SuppressWarnings("unused")
	private static final String SQL_INSERT = """
			INSERT INTO productos
			(nombre, precio, descripcion) 
			VALUES 
			('Nuevo', 1234.56, 'Descripción NUEVA');
			""";
	
	@SuppressWarnings("unused")
	private static final String SQL_UPDATE = """
			UPDATE productos 
			SET nombre='Modificado', precio=4321.12, descripcion='Registro modificado' 
			WHERE id=4
			""";
	
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=4";
	
	public static void main(String[] args) {
		consulta();
		modificacion();
		consulta();
	}

	private static void modificacion() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement st = con.createStatement()) {
			int numRegModificados = st.executeUpdate(SQL_DELETE);
			System.out.println(numRegModificados);
		} catch (SQLException e) {
			System.out.println("Ha habido un error con la base de datos");
			System.out.println(e);
		}
	}


	public static void consulta() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			while (rs.next()) {
				System.out.printf("%5s %-10s %10s %-20s\n", 
						rs.getInt("id"), rs.getString("nombre"), 
						rs.getDouble("precio"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error con la base de datos");
			System.out.println(e);
		}
	}
}
