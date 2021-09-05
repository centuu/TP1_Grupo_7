package Ejercicio1;

public class MainEjercicio1_a 
{
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
			Profesor profe1 = new Profesor("Angel",35,"titular",10);
			Profesor profe2 = new Profesor("Maxi",30,"titular",8);
			Profesor profe3 = new Profesor("Lorena",40,"suplente",10);
			Profesor profe4 = new Profesor("Tamara",28,"titular",12);
			Profesor profe5 = new Profesor("Horacio",45,"suplente",5);
			
			Profesor.showAllProfesores();
	}
}
