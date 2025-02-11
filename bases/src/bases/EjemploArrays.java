package bases;

import java.util.Arrays;

public class EjemploArrays {
	public static void main(String[] args) {
		int tamano = 3;

		String[] textos = new String[tamano];

		textos[0] = "Uno";
		textos[1] = "Dos";
		textos[2] = "Tres";

		System.out.println(textos);
		System.out.println(Arrays.toString(textos));

		for (int i = 0; i < textos.length; i++) {
			System.out.println(textos[i]);
		}

		for (String dato : textos) {
			System.out.println(dato);
		}
	}
}
