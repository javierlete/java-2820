package ejemploconsolajdbc;

import bibliotecas.Consola;
import poo.Producto;

public class EjemploConsolaJdbcDao {
	private static final ProductoDao dao = new ProductoDao("jdbc:sqlite:bdd/ejemplo.sqlite", "", "");

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
		for (Producto p : dao.buscarTodos()) {
			mostrarProducto(p);
		}
	}

	private static void buscarPorId() {
		int id = Consola.pedirEntero("Dime el id a buscar");

		Producto producto = dao.buscarPorId(id);

		if (producto != null) {
			mostrarProducto(producto);
		} else {
			System.out.println("No se ha encontrado");
		}
	}

	private static void insertar() {
		String nombre = Consola.pedirTexto("Nombre");
		double precio = Consola.pedirEntero("Precio");
		String descripcion = Consola.pedirTexto("Descripción");

		Producto producto = new Producto(null, nombre, precio, descripcion);

		dao.insertar(producto);
	}

	private static void modificar() {
		int id = Consola.pedirEntero("Id");
		String nombre = Consola.pedirTexto("Nombre");
		double precio = Consola.pedirEntero("Precio");
		String descripcion = Consola.pedirTexto("Descripción");

		Producto producto = new Producto(id, nombre, precio, descripcion);

		dao.modificar(producto);
	}

	private static void borrar() {
		int id = Consola.pedirEntero("Dime el id a borrar");

		dao.borrar(id);
	}

	private static void mostrarProducto(Producto producto) {
		System.out.printf("%5s %-15s %10s %-20s\n", producto.getId(), producto.getNombre(), producto.getPrecio(),
				producto.getDescripcion());
	}
}
