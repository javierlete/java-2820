package bases;

import java.util.Random;

import bibliotecas.Consola;

public class AdivinaElNumero {
	private static final int TOPE_INTENTOS = 5;
	private static Integer mejorPuntuacion = null;
	private static int intentos;

	public static void main(String[] args) {
		int minimo = Consola.pedirEntero("Mínimo");
		int maximo = Consola.pedirEntero("Máximo");

		String otraPartida;
		
		do {
			intentos = 0;
			int numero = new Random().nextInt(minimo, maximo + 1);
			System.out.println(numero);
			int suNumero;
			boolean repetir;
			
			do {
				suNumero = Consola.pedirEntero("Dime un número", minimo, maximo);

				intentos++;

				repetir = calcularResultado(numero, suNumero);
			} while (repetir);
			
			otraPartida = Consola.pedirTexto("¿Otra partida? (s/N)");
			
		} while (otraPartida.equalsIgnoreCase("s"));
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

}
