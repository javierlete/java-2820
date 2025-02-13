package poo;

public class LocalPrueba {
	public static void main(String[] args) {
		Persona responsable = new Persona("Pepe", "Masculino", 50);
		Local ipartek = new Local("Ipartek", responsable, 5);

		ipartek.entrar(responsable);
		ipartek.entrar(new Persona());
		ipartek.entrar(new Persona("Juan", "Masculino", 34));
		ipartek.entrar(new Persona("Pepa", "Femenino", 43));
		ipartek.entrar(new Persona("Pepa", "Femenino", 43));

		ipartek.getPersonas().get(1).setNombre("Pepillo");

		System.out.println(ipartek.getAforoActual());

		ipartek.salir(responsable);
		ipartek.salir(new Persona("Juan", "Masculino", 34));

		System.out.println(ipartek.getAforoActual());

		for (Persona p : ipartek.getPersonas()) {
			System.out.println(p);
		}
	}
}
