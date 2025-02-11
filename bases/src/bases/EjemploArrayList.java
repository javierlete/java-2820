package bases;

import java.util.ArrayList;

public class EjemploArrayList {
	public static void main(String[] args) {
		ArrayList<String> textos = new ArrayList<String>();
		
		textos.add("Uno");
		textos.add("Tres");
		textos.add("ALSKJDFLASDJKF");
		textos.add("Cuatro");
		
		textos.add(1, "Dos");
		textos.remove(3);

		for(String dato: textos) {
			System.out.println(dato);
		}
		
		System.out.println(textos.size());
	}
}
