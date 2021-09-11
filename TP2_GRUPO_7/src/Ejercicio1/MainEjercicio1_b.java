package Ejercicio1;

import java.util.TreeSet;

public class MainEjercicio1_b 
{
	public static void main(String[] args) 
	{		
		TreeSet<String> tsProfesores = new TreeSet<String>();
		
		Profesor profe1 = new Profesor("Angel", 35, "titular", 10);
		tsProfesores.add(profe1.toString());
	    Profesor profe2 = new Profesor("Maxi", 30, "titular", 8);
	    tsProfesores.add(profe2.toString());
	    Profesor profe3 = new Profesor("Lorena", 40, "suplente", 10);
	    tsProfesores.add(profe3.toString());
	    Profesor profe4 = new Profesor("Tamara", 28, "titular", 12);
	    tsProfesores.add(profe4.toString());
	    Profesor profe5 = new Profesor("Horacio", 45, "suplente", 5);
	    tsProfesores.add(profe5.toString());
	    Profesor profe6 = new Profesor("Horacio", 45, "suplente", 5);
	    tsProfesores.add(profe6.toString());
	    
		Profesor.showAllProfesoresFromTreeSet(tsProfesores);
		
		if (profe2.equals(profe1)) System.out.println("Es el mismo profesor (Profesor 2 = Profesor 1)");

	    if (profe3.equals(profe1)) System.out.println("Es el mismo profesor (Profesor 3 = Profesor 1)");
	    if (profe3.equals(profe2)) System.out.println("Es el mismo profesor (Profesor 3 = Profesor 2)");  
	    
	    if (profe4.equals(profe1)) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 1)");
	    if (profe4.equals(profe2)) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 2)");
	    if (profe4.equals(profe3)) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 3)");
	    
	    if (profe5.equals(profe1)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 1)");
	    if (profe5.equals(profe2)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 2)");
	    if (profe5.equals(profe3)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 3)");
	    if (profe5.equals(profe4)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 4)"); 
	    
	    if (profe6.equals(profe1)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 1)");
	    if (profe6.equals(profe2)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 2)");
	    if (profe6.equals(profe3)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 3)");
	    if (profe6.equals(profe4)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 4)");
	    if (profe6.equals(profe5)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 5)");	
	}
}