package Ejercicio1;

import java.util.ArrayList;

public class MainEjercicio1_a 
{
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
			ArrayList<Profesor> ListaProfesores = new ArrayList<Profesor>();
			
			Profesor profe1 = new Profesor("Angel",35,"titular",10);
			ListaProfesores.add(profe1);
			Profesor profe2 = new Profesor("Maxi",30,"titular",8);
			ListaProfesores.add(profe2);
			Profesor profe3 = new Profesor("Lorena",40,"suplente",10);
			ListaProfesores.add(profe3);
			Profesor profe4 = new Profesor("Tamara",28,"titular",12);
			ListaProfesores.add(profe4);
			Profesor profe5 = new Profesor("Horacio",45,"suplente",5);
			ListaProfesores.add(profe5);
			
			Profesor.showAllProfesoresFromArrayList(ListaProfesores);
	}
}
