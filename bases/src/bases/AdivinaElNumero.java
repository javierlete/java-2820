package bases;

import java.util.Random;
import java.util.Scanner;

// Preguntar si se quiere otra partida
// Puntuación mínima

public class AdivinaElNumero {

	private static final int TOPE_INTENTOS = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Mínimo: ");
		int minimo = sc.nextInt();
		
		System.out.print("Máximo: ");
		int maximo = sc.nextInt();

		// Buscar un número aleatorio
		int numero = new Random().nextInt(minimo, maximo + 1);

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
				
				if(suNumero < minimo  || suNumero > maximo) {
					System.out.println("El número debe ser entre " + minimo + " y " + maximo);
				}
			} while (suNumero < minimo  || suNumero > maximo);
			
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
