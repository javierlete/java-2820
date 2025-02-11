package poo;

public class Persona {
	private String nombre;
	private String genero;
	private int edad;
	
	public Persona(String nombre, String genero, int edad) {
		setNombre(nombre);
		setGenero(genero);
		setEdad(edad);
	}
	
	public Persona() {
		this("Anónimo", null, 0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.isBlank()) {
			throw new RuntimeException("No se admiten nombres nulos ni vacíos");
		}
		
		this.nombre = nombre.trim();
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + "]";
	}

	
}
