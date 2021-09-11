package Ejercicio1;

public class Main 
{
	public static void main(String[] args) 
	{
		/*Persona.leerPersonasDesdeArchivo();
		Persona.mostrarPersonas();*/
		
		Archivo archivo = new Archivo();
		archivo.setRuta("Prueba.txt");
		
		if(archivo.existe(archivo.getRuta()))
		{
			System.out.println("Existe Archivo");
		}
		else
		{
			System.out.println("No existe el archivo, por lo tanto sera creado");
			archivo.crearArchivo(archivo.getRuta());
		}		
		
		archivo.escribeLineas("Hola todo bien?");
		
		System.out.println("\nA continuacion se lee la linea");
		archivo.leeLineas();
	}
}
