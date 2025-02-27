package modelos;

import java.util.Objects;

public class Mesa {
	private Integer id;
	private int capacidad;

	public Mesa(Integer id, int capacidad) {
		super();
		this.id = id;
		this.capacidad = capacidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacidad, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		return capacidad == other.capacidad && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("Mesa [id=%s, capacidad=%s]", id, capacidad);
	}

}
