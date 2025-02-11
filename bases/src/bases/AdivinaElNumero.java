package bases;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {

	private static final int TOPE_INTENTOS = 5;
	private static final Scanner SC = new Scanner(System.in);
	private static Integer mejorPuntuacion = null;
	private static int intentos = 0;

	public static void main(String[] args) {
		Integer minimo = pedirMinimo();
		int maximo = pedirMaximo();

		String otraPartida;
		
		do {
			// Buscar un número aleatorio
			int numero = new Random().nextInt(minimo, maximo + 1);
			System.out.println(numero);
			int suNumero;
			boolean repetir;
			do {
				suNumero = pedirNumero(minimo, maximo);

				intentos++;

				repetir = calcularResultado(numero, suNumero);
			} while (repetir);
			// Repetir mientras no se haya acertado
			
			System.out.print("¿Otra partida? (s/N) ");
			otraPartida = SC.nextLine();
			
		} while (otraPartida.equalsIgnoreCase("s"));
		
		SC.close();
	}

	private static boolean calcularResultado(int numero, int suNumero) {
		boolean seHaPasado = intentos >= TOPE_INTENTOS;

		// Comprobar si el número es mayor que el introducido
		if (numero > suNumero && !seHaPasado) {
			System.out.println("El número es mayor");
		} else if (numero < suNumero && !seHaPasado) {
			System.out.println("El número es menor");
		} else if (numero == suNumero) {
			System.out.println("Has acertado");
			System.out.println("Te ha costado " + intentos + " intentos");
			
			if(mejorPuntuacion == null || intentos < mejorPuntuacion) {
				System.out.println("Felicidades. Has conseguido la mejor puntuación");
				mejorPuntuacion = intentos;
			}
			
			System.out.println("La mejor puntuación es " + mejorPuntuacion);
			
			return false;
		} else if (seHaPasado) {
			System.out.println("Te has pasado de intentos");
			return false;
		}
		
		return true;
	}

	private static int pedirMaximo() {
		System.out.print("Máximo: ");
		int maximo = Integer.parseInt(SC.nextLine());
		return maximo;
	}

	private static Integer pedirMinimo() {
		Integer minimo = null;
		
		boolean estaMal = true;
		
		do {
			System.out.print("Mínimo: ");
			
			try {
				minimo = Integer.parseInt(SC.nextLine());
				estaMal = false;
			} catch (NumberFormatException e) {
				System.out.println("Debes introducir un número");
			}
		} while (estaMal);
		
		return minimo;
	}

	private static int pedirNumero(Integer minimo, int maximo) {
		int suNumero;
		
		do {
			// Pedir un número
			System.out.print("Dime un número: ");
			suNumero = Integer.parseInt(SC.nextLine());

			if (suNumero < minimo || suNumero > maximo) {
				System.out.println("El número debe ser entre " + minimo + " y " + maximo);
			}
		} while (suNumero < minimo || suNumero > maximo);
		
		return suNumero;
	}
}
