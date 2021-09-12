package Ejercicio1;

public class Main 
{
	public static void main(String[] args) 
	{

		Persona.leerPersonasDesdeArchivo();
		Persona.mostrarPersonas();
		
		Archivo archivo = new Archivo();
		/*
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
		*/
		
		//Pablo Torres
		archivo.setRuta("Resultado.txt");
		
		if(archivo.existe(archivo.getRuta()))
		{
			System.out.println("Existe Archivo '" + archivo.getRuta() + "'. Se sobreescribe archivo.");
			archivo.crearArchivo(archivo.getRuta());
			archivo.crearNuevoArchivoDePersonas(archivo.getRuta(), true, Persona.Personas);
		}
		else
		{
			System.out.println("No existe el archivo '" + archivo.getRuta() + "' por lo tanto sera creado");
			archivo.crearArchivo(archivo.getRuta());
			archivo.crearNuevoArchivoDePersonas(archivo.getRuta(), false, Persona.Personas);
		}
		//Pablo Torres
	}
}
