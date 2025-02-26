package modelos;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
	private Integer id;
	private String nombreCliente;
	private int paraCuantos;
	private LocalDateTime hora;

	public Reserva(Integer id, String nombreCliente, int paraCuantos, LocalDateTime hora) {
		super();
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.paraCuantos = paraCuantos;
		this.hora = hora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getParaCuantos() {
		return paraCuantos;
	}

	public void setParaCuantos(int paraCuantos) {
		this.paraCuantos = paraCuantos;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hora, id, nombreCliente, paraCuantos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(hora, other.hora) && Objects.equals(id, other.id)
				&& Objects.equals(nombreCliente, other.nombreCliente) && paraCuantos == other.paraCuantos;
	}

	@Override
	public String toString() {
		return String.format("Reserva [id=%s, nombreCliente=%s, paraCuantos=%s, hora=%s]", id, nombreCliente,
				paraCuantos, hora);
	}

}
