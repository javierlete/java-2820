package bibliotecas;

import java.util.Scanner;

public class ConsolaPrueba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
		
		String texto = Consola.pedirTexto("Prueba");
		
		System.out.println(texto);
	}
}
