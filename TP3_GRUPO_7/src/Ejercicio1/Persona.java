package Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class Persona 
{
	static ArrayList<Persona> Personas = new ArrayList<Persona>();
	private String nombre;
	private String apellido;
	private String dni;
	
	Persona (String nombre,String apellido,String dni)
	{
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	private void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	private void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	
	public String getDni()
	{
		return dni;
	}
	
	private void setDni(String dni) 
	{
		this.dni = dni;
	}	
	
	@Override
	public String toString()
	{
		return "Nombre : " + nombre + ",  apellido : " + apellido + ", DNI : " + dni ;
	}

	public static boolean verificarDniInvalido(String dni) throws DniInvalido 
	{
		if (!dni.matches("^[0-9]*$"))
		{
			DniInvalido ex = new DniInvalido();
			throw ex;
		}
		return true;
	}
	
	private static Persona stringAPersona(String str)
	{
		String []datos = str.split("-");
		return new Persona(datos[0], datos[1], datos[2]);
	}
	
	public static void leerPersonasDesdeArchivo()
	{
		ArrayList<String> personas = Archivo.leer_Archivo("Personas.txt");
		
		for(int i = 0; i < personas.size(); i++)
		{
			try
			{
				Persona persona = stringAPersona(personas.get(i));
				if(Persona.verificarDniInvalido(persona.getDni())) 
						Personas.add(persona);
				else
						continue;
			}		
			catch (DniInvalido e)
			{
				e.getMessage();
				e.printStackTrace();
			}			
		}
	}
	
	public static void mostrarPersonas()
	{
		Iterator<Persona> it = Personas.iterator();

		while(it.hasNext())
		    System.out.println(it.next().toString());
	}
}