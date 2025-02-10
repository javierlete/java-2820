package bases;

public class Excepciones {
	public static void main(String[] args) {
		int a = 5, b = 2, div;
		
		System.out.println("Antes");
		
		try {
			div = a / b;
			
			System.out.println(div);
		} catch (ArithmeticException e) {
			System.out.println("No se puede dividir por 0");
		}
		
		System.out.println("FIN");
	}
}
