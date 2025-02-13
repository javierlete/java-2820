package poo;

import java.util.Objects;

public class Empleado extends Persona {
	private double sueldo;

	public Empleado(String nombre, String genero, int edad, double sueldo) {
		super(nombre, genero, edad);
		
		this.sueldo = sueldo;
	}
	
	public Empleado(String nombre, int edad, double sueldo) {
		this(nombre, null, edad, sueldo);
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sueldo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
	}

	@Override
	public String toString() {
		return String.format("Empleado [nombre=%s, genero=%s, edad=%s, sueldo=%s]",
				getNombre(), getGenero(), getEdad(), getSueldo());
	}
	
	
}
