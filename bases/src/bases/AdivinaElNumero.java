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

		// Buscar un número aleatorio
		int numero = new Random().nextInt(0, 101);

//		System.out.println(numero);

		int intentos = 0;

		int suNumero;

		do {
			// Pedir un número
			System.out.print("Dime un número: ");
			suNumero = sc.nextInt();
			intentos++;
			
//			System.out.println(suNumero);
			
			// Comprobar si el número es mayor que el introducido
			if (numero > suNumero) {
				System.out.println("El número es mayor");
			} else if (numero < suNumero) {
				System.out.println("El número es menor");
			} else {
				System.out.println("Has acertado");
				System.out.println("Te ha costado " + intentos + " intentos");
			}
			
		} while (numero != suNumero);
		// Repetir mientras no se haya acertado
		
		sc.close();
	}
}
