package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotecas.BaseDeDatos;
import modelos.Producto;

// DAO: Data Access Object

public class ProductoDao {
	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, descripcion) VALUES ('%s', %s, '%s')";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre='%s', precio=%s, descripcion='%s' WHERE id=%s";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=";

	private BaseDeDatos bdd;

	public ProductoDao(String url, String usuario, String password) {
		bdd = new BaseDeDatos(url, usuario, password);
	}

	public ArrayList<Producto> buscarTodos() {
		try (ResultSet rs = bdd.consulta(SQL_SELECT)) {
			ArrayList<Producto> productos = new ArrayList<>();

			while (rs.next()) {
				Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"));
				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta a la base de datos", e);
		}
	}

	public Producto buscarPorId(int id) {
		try (ResultSet rs = bdd.consulta(SQL_SELECT_ID + id)) {

			Producto producto = null;

			if (rs.next()) {
				producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"));
			}

			return producto;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta a la base de datos", e);
		}
	}

	public void insertar(Producto producto) {
		String sql = String.format(SQL_INSERT, producto.getNombre(), producto.getPrecio(), producto.getDescripcion());

		bdd.cambio(sql);
	}

	public void modificar(Producto producto) {
		String sql = String.format(SQL_UPDATE, producto.getNombre(), producto.getPrecio(), producto.getDescripcion(), producto.getId());

		bdd.cambio(sql);
	}

	public void borrar(int id) {
		bdd.cambio(SQL_DELETE + id);
	}

}
