package poo;

import java.util.Random;

public class AdivinaElNumero {
	private int aleatorio;
	
	private int numeroElegido;
	
	private int intentos = 0;
	
	public AdivinaElNumero(int minimo, int maximo) {
		aleatorio = new Random().nextInt(minimo, maximo + 1);
	}

	public void setNumeroElegido(int numeroElegido) {
		this.numeroElegido = numeroElegido;
		
		intentos++;
	}
	
	public String getRespuesta() {
		String respuesta;
		
		if(aleatorio > numeroElegido) {
			respuesta = "ES MAYOR";
		} else if(aleatorio < numeroElegido) {
			respuesta = "ES MENOR";
		} else {
			respuesta = "HAS ACERTADO";
		}
		
		return respuesta;
	}
	
	public boolean isAcertado() {
		return aleatorio == numeroElegido;
	}
	
	public int getIntentos() {
		return intentos;
	}
}
