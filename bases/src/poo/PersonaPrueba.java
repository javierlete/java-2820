package poo;

public class PersonaPrueba {
	public static void main(String[] args) {
		Persona p;
		
		p = new Persona();
		
		System.out.println(p);
		
		p.setNombre("     asdf asf s a  ");
		p.setGenero("Masculino");
		p.setEdad(123);
		
		System.out.println(p.getNombre());
		System.out.println(p.getGenero());
		System.out.println(p.getEdad());
		
		Persona p2 = new Persona("     María    ", "Femenino", 34);
		
		System.out.println(p2);
		
		Persona[] personas = new Persona[3];
		
		personas[0] = p;
		personas[1] = p2;
		personas[2] = new Persona(" nueva ", "Femenino", 56);
		
		for(Persona per: personas) {
			System.out.println(per);
		}
	}
}
