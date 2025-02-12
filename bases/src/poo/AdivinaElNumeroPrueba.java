package poo;

import bibliotecas.Consola;

public class AdivinaElNumeroPrueba {
	private static final int MINIMO = 1;
	private static final int MAXIMO = 100;
	
	public static void main(String[] args) {
		
		String otraPartida;
		AdivinaElNumero aen;
		
		do {
			aen = new AdivinaElNumero(MINIMO, MAXIMO);
			
			do {
				aen.setNumeroElegido(Consola.pedirEntero("Dime un número", MINIMO, MAXIMO));
				System.out.println(aen.getRespuesta());
			} while (!aen.isAcertado());
			
			System.out.println(aen.getIntentos());
			
			otraPartida = Consola.pedirTexto("¿Otra partida?");
		} while (otraPartida.equalsIgnoreCase("s"));
	}
}
