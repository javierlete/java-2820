package daos;

import java.util.ArrayList;

import modelos.Mesa;

public class MesaDao {

	public MesaDao(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Mesa> buscarTodos() {
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();

		mesas.add(new Mesa(1, 4));
		mesas.add(new Mesa(2, 3));
		mesas.add(new Mesa(3, 2));
		mesas.add(new Mesa(4, 1));
		
		return mesas;
	}

}
