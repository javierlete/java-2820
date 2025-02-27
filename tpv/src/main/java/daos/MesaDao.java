package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotecas.BaseDeDatos;
import modelos.Mesa;

public class MesaDao implements Dao<Mesa> {

	private static final String SQL_SELECT = "SELECT * FROM mesas";
	private BaseDeDatos bdd;
	
	public MesaDao(String url, String user, String pass) {
		bdd = new BaseDeDatos(url, user, pass);
	}

	public ArrayList<Mesa> buscarTodos() {
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();

		try (ResultSet rs = bdd.consulta(SQL_SELECT)) {
			while(rs.next()) {
				Mesa mesa = new Mesa(rs.getInt("id"), rs.getInt("capacidad"));
				
				mesas.add(mesa);
			}
			
			return mesas;
		} catch (SQLException e) {
			throw new RuntimeException("No se han encontrado las mesas");
		}
	}

}
