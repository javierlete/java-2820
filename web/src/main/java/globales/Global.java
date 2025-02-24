package globales;

import daos.ProductoDao;

public class Global {
	public static final ProductoDao DAO = new ProductoDao("jdbc:sqlite:C:\\Users\\java.IPARTEKAULA\\git\\java-2820\\bases\\bdd\\ejemplo.sqlite",
			"", "");
}
