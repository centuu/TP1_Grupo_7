package Ejercicio1;
import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio1_a {

	public static void main(String[] args) {
	
		ArrayList<Profesor> ListaProfesores = new ArrayList<Profesor>();
	
	    Profesor profe1 = new Profesor("Angel", 35, "titular", 10);
	    Profesor profe2 = new Profesor("Maxi", 30, "titular", 8);
	    Profesor profe3 = new Profesor("Lorena", 40, "suplente", 10);
	    Profesor profe4 = new Profesor("Tamara", 28, "titular", 12);
	    Profesor profe5 = new Profesor("Horacio", 45, "suplente", 5);
	     
	    ListaProfesores.add(profe1);  
	    ListaProfesores.add(profe2);  
	    ListaProfesores.add(profe3);  
	    ListaProfesores.add(profe4);  
	    ListaProfesores.add(profe5);  
	     
	    Iterator<Profesor> it = ListaProfesores.iterator();
	     
	    while (it.hasNext())
	    {
	    	Profesor pro = it.next();
	    	System.out.println(pro.toString());
	    }	     
	}
}