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
			throw new RuntimeException("Ha fallado la conexión a la base de datos");
		}
	}
	
	public ResultSet consulta(String sql) {
		try {
			Connection con = conectar();
			Statement st = con.createStatement();
			
			return st.executeQuery(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta");
		}
	}
	
	public int cambio(String sql) {
		try {
			Connection con = conectar();
			Statement st = con.createStatement();
			
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta");
		}
	}

}
