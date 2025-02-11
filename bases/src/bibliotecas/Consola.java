package bibliotecas;

import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);
	
	public static String pedirTexto(String mensaje) {
		System.out.print(mensaje + ": ");
		return SC.nextLine();
	}
	
	public static int pedirEntero(String mensaje) {
		int entero = 0;
		
		boolean estaMal = true;
		
		do {
			try {
				entero = Integer.parseInt(pedirTexto(mensaje));
				estaMal = false;
			} catch (NumberFormatException e) {
				System.out.println("Debes introducir un número");
			}
		} while (estaMal);
		
		return entero;
	}
	
	public static int pedirEntero(String mensaje, int minimo, int maximo) {
		int entero;
		
		do {
			entero = pedirEntero("Dime un número");

			if (entero < minimo || entero > maximo) {
				System.out.println("El número debe ser entre " + minimo + " y " + maximo);
			}
		} while (entero < minimo || entero > maximo);
		
		return entero;
	}

}
