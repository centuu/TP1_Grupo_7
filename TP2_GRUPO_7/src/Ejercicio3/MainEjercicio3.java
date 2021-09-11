package Ejercicio3;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainEjercicio3 {

	public static void main(String[] args) {

		Polideportivo poli = new Polideportivo();
		Polideportivo poli2 = new Polideportivo(50,50,"Polideportivo Tigre");
		Polideportivo poli3 = new Polideportivo(30,20,"Polideportivo Pacheco");
		
		
		EdificioDeOficinas edificioOfi = new EdificioDeOficinas();
		EdificioDeOficinas edificioOfi2 = new EdificioDeOficinas(20, "Edificio de Oficinas Tigre");

		
		ArrayList<Edificio> ListaEdificio= new ArrayList<Edificio>();
		
		ListaEdificio.add(edificioOfi);
		ListaEdificio.add(edificioOfi2);
		ListaEdificio.add(poli);
		ListaEdificio.add(poli2);
		ListaEdificio.add(poli3);
		
		
		ListIterator<Edificio> it = ListaEdificio.listIterator();
		
		while(it.hasNext()) {
			Edificio edi = it.next();
	    	System.out.println("en while: " + edi.toString());
		}
	}
}
