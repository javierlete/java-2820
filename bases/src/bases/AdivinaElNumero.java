package bases;

import java.util.Random;
import java.util.Scanner;

// Selección de límites
// Preguntar si se quiere otra partida
// Puntuación mínima

public class AdivinaElNumero {
	private static final int MINIMO = 1;
	private static final int MAXIMO = 10;

	private static final int TOPE_INTENTOS = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Buscar un número aleatorio
		int numero = new Random().nextInt(MINIMO, MAXIMO + 1);

		System.out.println(numero);

		int intentos = 0;
		
		int suNumero;
		
		boolean repetir = true;

		boolean seHaPasado = false;
		
		do {
			do {
				// Pedir un número
				System.out.print("Dime un número: ");
				suNumero = sc.nextInt();
				
				if(suNumero < MINIMO  || suNumero > MAXIMO) {
					System.out.println("El número debe ser entre " + MINIMO + " y " + MAXIMO);
				}
			} while (suNumero < MINIMO  || suNumero > MAXIMO);
			
			intentos++;

//			System.out.println(suNumero);

			seHaPasado = intentos >= TOPE_INTENTOS;
			
			// Comprobar si el número es mayor que el introducido
			if (numero > suNumero && !seHaPasado) {
				System.out.println("El número es mayor");
			} else if (numero < suNumero && !seHaPasado) {
				System.out.println("El número es menor");
			} else if (numero == suNumero) {
				System.out.println("Has acertado");
				System.out.println("Te ha costado " + intentos + " intentos");
				repetir = false;
			} else if (seHaPasado) {
				System.out.println("Te has pasado de intentos");
				repetir = false;
			}
		} while (repetir);
		// Repetir mientras no se haya acertado

		sc.close();
	}
}
