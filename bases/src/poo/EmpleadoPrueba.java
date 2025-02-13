package poo;

public class EmpleadoPrueba {
	public static void main(String[] args) {
		Empleado e = new Empleado("Javier Lete", 28, 4321.45);

		System.out.println(e);

		e.setSueldo(1234.56);

		System.out.println(e);

		Empleado e2 = new Empleado("Pepe Pérez", "Masculino", 18, 1234.56);

		System.out.println(e2);

		Persona p = e;

		System.out.println(p.getNombre());

		if (p instanceof Empleado e3) {
			System.out.println(e3.getSueldo());

			System.out.println(e == p);
			System.out.println(e3 == e);
		}

		Local l = new Local("Pruebas", e, 10);

		l.entrar(e2);
		l.entrar(e);
		l.entrar(new Persona());

		double sueldos = 0;

		for (Persona persona : l.getPersonas()) {
			if (persona instanceof Empleado) {
				Empleado empleado = (Empleado) persona;

				System.out.print("Es un empleado: ");

				sueldos += empleado.getSueldo();
			}

			System.out.println(persona);
		}

		System.out.println(sueldos);

		if (l.getPersonas().get(2) instanceof Empleado e4) {
			System.out.println(e4.getSueldo());
		} else {
			System.out.println("No es un empleado");
		}

		Persona francisco = new Persona();

		Persona javier = new Persona();

		System.out.println(javier == francisco); // ¿Son el mismo? NO
		System.out.println(javier.equals(francisco)); // ¿Son iguales? SÍ
	}
}
