package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import poo.Producto;

public class EjemploJdbcObjetos {
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
	
	private static final String SQL_UPDATE = """
			UPDATE productos 
			SET nombre='%s', precio=%s, descripcion='%s' 
			WHERE id=%s
			""";
	
	@SuppressWarnings("unused")
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=4";
	
	public static void main(String[] args) {
		ArrayList<Producto> productos = consulta();
		
		mostrar(productos);
		
		Producto producto = new Producto(1, "MODIFICADO", 5678.0, "laksjdfklasd");
		
		int modificaciones = modificacion(producto);
		
		System.out.println(modificaciones);
		
		productos = consulta();
		
		mostrar(productos);
	}

	private static void mostrar(ArrayList<Producto> productos) {
		for(Producto p: productos) {
			System.out.printf("%5s %-10s %10s %-20s\n", 
					p.getId(), p.getNombre(), p.getPrecio(), p.getDescripcion());
		}
	}

	private static Integer modificacion(Producto producto) {
		String sql = String.format(SQL_UPDATE, 
				producto.getNombre(), producto.getPrecio(), 
				producto.getDescripcion(), producto.getId());

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement st = con.createStatement()) {
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Ha habido un error con la base de datos");
			System.out.println(e);
			
			return null;
		}
	}


	public static ArrayList<Producto> consulta() {
		ArrayList<Producto> productos = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			
			while (rs.next()) {
				Producto producto = new Producto(  
						rs.getInt("id"), rs.getString("nombre"), 
						rs.getDouble("precio"), rs.getString("descripcion"));
				productos.add(producto);
			}
			
		} catch (SQLException e) {
			System.out.println("Ha habido un error con la base de datos");
			System.out.println(e);
		}

		return productos;
	}
}
