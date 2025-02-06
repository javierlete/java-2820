package bases;

public class EjemplosBucles {
	public static void main(String[] args) {
		int x = 1;

		while (x <= 5) { // Podría llegar a no repetirse ni una sola vez
			System.out.println(x);
			x = x + 1; // Quiero asignar a x el valor de la expresión x + 1
		}

		x = 1;

		do { // Va a repetirse al menos una vez
			System.out.println(x);
			x += 1; // Quiero sumarle a x el valor 1
		} while (x <= 5);

		for (int c = 1; c <= 5; c++) {
			System.out.println(c);
		}

		int c = 1;

		while (c <= 5) {
			System.out.println(c);
			c++;
		}

		System.out.println("Se acabó");

	}
}
