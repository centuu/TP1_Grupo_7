package Ejercicio1;

import java.util.Comparator;

public class ComparatorApellido implements Comparator<Persona> {

	@Override
	public int compare(Persona per1, Persona per2) {
		
		
		return per1.getApellido().compareTo(per2.getApellido());
	}

}
