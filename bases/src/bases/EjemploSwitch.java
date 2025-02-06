package bases;

import java.util.Scanner;

public class EjemploSwitch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime una opción");

		int opcion = sc.nextInt();

		sc.close();
		
		switch (opcion) {
		case 1:
			System.out.println("Opción 1");
			break;
		case 2:
			System.out.println("Opción 2");
			break;
		default:
			System.out.println("No reconozco esa opción");
		}
	}
}
