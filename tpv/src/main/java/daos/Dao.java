package daos;

import java.util.ArrayList;

public interface Dao<T> {
	ArrayList<T> buscarTodos();

	default T buscarPorId(int id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default void insertar(T objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default void modificar(T objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default void borrar(int id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
