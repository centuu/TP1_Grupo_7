package Ejercicio1;

public class MainEjercicio1_b 
{
	public static void main(String[] args) 
	{		
		Profesor profe1 = new Profesor("Angel", 35, "titular", 10);
	    Profesor profe2 = new Profesor("Maxi", 30, "titular", 8);
	    Profesor profe3 = new Profesor("Lorena", 40, "suplente", 10);
	    Profesor profe4 = new Profesor("Tamara", 28, "titular", 12);
	    Profesor profe5 = new Profesor("Horacio", 45, "suplente", 5);
	    Profesor profe6 = new Profesor("Horacio", 45, "suplente", 5);

		System.out.println(" ");

		Profesor.showAllProfesores();

		if (profe2.compareTo(profe1)) System.out.println("Es el mismo profesor (Profesor 2 = Profesor 1)");   
	    if (profe3.compareTo(profe1)) System.out.println("Es el mismo profesor (Profesor 3 = Profesor 1)");
	    if (profe3.compareTo(profe2)) System.out.println("Es el mismo profesor (Profesor 3 = Profesor 2)");  
	    if (profe4.compareTo(profe1)) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 1)");
	    if (profe4.compareTo(profe2)) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 2)");
	    if (profe4.compareTo(profe3)) System.out.println("Es el mismo profesor (Profesor 4 = Profesor 3)");
	    if (profe5.compareTo(profe1)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 1)");
	    if (profe5.compareTo(profe2)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 2)");
	    if (profe5.compareTo(profe3)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 3)");
	    if (profe5.compareTo(profe4)) System.out.println("Es el mismo profesor (Profesor 5 = Profesor 4)");   
	    if (profe6.compareTo(profe1)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 1)");
	    if (profe6.compareTo(profe2)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 2)");
	    if (profe6.compareTo(profe3)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 3)");
	    if (profe6.compareTo(profe4)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 4)");
	    if (profe6.compareTo(profe5)) System.out.println("Es el mismo profesor (Profesor 6 = Profesor 5)");
	}
}