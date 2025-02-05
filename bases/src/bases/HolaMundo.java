package bases;

import java.util.Scanner;

public class HolaMundo {
	public static void main(String[] args) {
		// Se puede crear con syso y CTRL-ESPACIO
		System.out.println("Hola a todos"); // Muestra un mensaje en pantalla

		// Comentario
		// Multilínea

		/*
		 * Declaración de variables
		 */

		int x = 5, y = 6, z = 7;

		int suma = x + y + z;

		System.out.println(suma);

		double total = 0.1 + 0.2;

		System.out.println(total);

		byte b = 127;

		b++;

		System.out.println(b);

		char c = 'ñ';

		System.out.println(c);

		String nombre = "Javier";

		System.out.println(nombre);

		System.out.println(nombre.toLowerCase());

		System.out.println(nombre.substring(0, 4).toUpperCase());
		
		String nombreAcortado = nombre.substring(0, 4);
		
		String nombreAcortadoEnMayusculas = nombreAcortado.toUpperCase();
		
		System.out.println(nombreAcortadoEnMayusculas);
		
		System.out.println(nombre.length());
		
		int dia = 5;
		
		System.out.println(dia);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime tu nombre: ");
		
		String recibido = sc.nextLine();
		
		System.out.println("Hola " + recibido);
		
		sc.close();
	}
}
