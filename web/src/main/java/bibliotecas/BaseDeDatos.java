package bibliotecas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {
	private String url;
	private String usuario;
	private String password;
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}
	
	public BaseDeDatos(String url, String usuario, String password) {
		super();
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}
	
	private Connection conectar() {
		try {
			
			return DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			throw new RuntimeException("Ha fallado la conexión a la base de datos", e);
		}
	}
	
	public ResultSet consulta(String sql) {
		try {
			Connection con = conectar();
			Statement st = con.createStatement();
			
			return st.executeQuery(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta", e);
		}
	}
	
	public int cambio(String sql) {
		try {
			Connection con = conectar();
			Statement st = con.createStatement();
			
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta", e);
		}
	}

}
