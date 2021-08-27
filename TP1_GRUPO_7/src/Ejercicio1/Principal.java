package Ejercicio1;

public class Principal {
	
	public static void main(String[] args) {
		Empleado empleado  = new Empleado();
		empleado.setNombre("Jose");
		empleado.setEdad(30);		
		//Prueba del Ejercicio 1
		System.out.print("Ejercicio 1\n\n");
		System.out.print(empleado.toString());
		
		//Muestra de 5 empleados
		
		Empleado empleado1 = new Empleado();
		Empleado empleado2 = new Empleado();
		Empleado empleado3 = new Empleado("Agustin",26);
		Empleado empleado4 = new Empleado("Tomas",25);
		Empleado empleado5 = new Empleado("Pablo",24);
		
		System.out.print("\n\n"+empleado1.toString());
		System.out.print("\n\n"+empleado2.toString());
		System.out.print("\n\n"+empleado3.toString());
		System.out.print("\n\n"+empleado4.toString());
		System.out.print("\n\n"+empleado5.toString());
		
		//Prueba de funcion de proximo ID
		System.out.print("\n\n"+"Proximo ID de empleado: "+Empleado.devuelveProximoID());
		
	}

}
