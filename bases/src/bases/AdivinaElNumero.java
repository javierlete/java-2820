package bases;

import java.util.Random;
import java.util.Scanner;

// Número de intentos que se han necesitado para acertar
// Tope de intentos
// Detección de límites
// Selección de límites
// Preguntar si se quiere otra partida
// Puntuación mínima

public class AdivinaElNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numero = new Random().nextInt(0, 101);

//		System.out.println(numero);

		int suNumero;

		do {
			System.out.print("Dime un número: ");
			suNumero = sc.nextInt();
			
//			System.out.println(suNumero);
			
			if (numero > suNumero) {
				System.out.println("El número es mayor");
			} else if (numero < suNumero) {
				System.out.println("El número es menor");
			} else {
				System.out.println("Has acertado");
			}
		} while (numero != suNumero);
		
		sc.close();
	}
}
