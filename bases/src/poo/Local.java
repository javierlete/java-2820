package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Local {
	private String nombre;
	private Persona responsable;
	private int aforoMaximo;

	private ArrayList<Persona> personas = new ArrayList<Persona>();

	public Local(String nombre, Persona responsable, int aforoMaximo) {
		super();
		this.nombre = nombre;
		this.responsable = responsable;
		this.aforoMaximo = aforoMaximo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

	public int getAforoMaximo() {
		return aforoMaximo;
	}

	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}

	public List<Persona> getPersonas() {
		return Collections.unmodifiableList(personas);
	}

	public void entrar(Persona persona) {
		if (aforoMaximo <= getAforoActual()) {
			throw new RuntimeException("Hemos superado el aforo máximo");
		}

		personas.add(persona);
	}

	public void salir(Persona persona) {
		personas.remove(persona);
	}

	public int getAforoActual() {
		return personas.size();
	}
}
