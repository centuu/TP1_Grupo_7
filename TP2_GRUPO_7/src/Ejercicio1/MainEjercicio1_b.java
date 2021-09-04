package Ejercicio1;
import java.util.TreeSet;
import java.util.Iterator;

public class MainEjercicio1_b {

	public static void main(String[] args) {
		
		TreeSet<String> tsProfesores = new TreeSet<String>();
		
		Profesor profe1 = new Profesor("Angel", 35, "titular", 10);
	    Profesor profe2 = new Profesor("Maxi", 30, "titular", 8);
	    Profesor profe3 = new Profesor("Lorena", 40, "suplente", 10);
	    Profesor profe4 = new Profesor("Tamara", 28, "titular", 12);
	    Profesor profe5 = new Profesor("Horacio", 45, "suplente", 5);
	    Profesor profe6 = new Profesor("Horacio", 45, "suplente", 5);
	    
	    tsProfesores.add(profe1.toString());
	    tsProfesores.add(profe2.toString());
	    tsProfesores.add(profe3.toString());
	    tsProfesores.add(profe4.toString());
	    tsProfesores.add(profe5.toString());
	    tsProfesores.add(profe6.toString());
	    
	    Iterator<String> it = tsProfesores.iterator();
	     
		while (it.hasNext())
	    {
	    	System.out.println(it.next());
	    } 
		
		System.out.println(" ");
		
		if (profe2.compareTo(profe1) < 0) System.out.println("Es el mismo profesor (Profesor 2 = Profesor 1)");
	    
	    if (profe3.compareTo(profe1) < 0) System.out.println("Es el mismo profesor (Profesor 3 = Profesor 1)");
	    if (profe3.compareTo(profe2) < 0) System.out.println("Es el mismo profesor (Profesor 3 = Profesor 2)");
	    
	    if (profe4.compareTo(profe1) < 0) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 1)");
	    if (profe4.compareTo(profe2) < 0) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 2)");
	    if (profe4.compareTo(profe3) < 0) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 3)");
	    
	    if (profe5.compareTo(profe1) < 0) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 1)");
	    if (profe5.compareTo(profe2) < 0) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 2)");
	    if (profe5.compareTo(profe3) < 0) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 3)");
	    if (profe5.compareTo(profe4) < 0) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 4)");
	    
	    if (profe6.compareTo(profe1) < 0) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 1)");
	    if (profe6.compareTo(profe2) < 0) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 2)");
	    if (profe6.compareTo(profe3) < 0) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 3)");
	    if (profe6.compareTo(profe4) < 0) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 4)");
	    if (profe6.compareTo(profe5) < 0) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 5)");
	}
}