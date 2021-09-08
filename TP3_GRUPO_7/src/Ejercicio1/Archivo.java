package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Archivo {
	static ArrayList<Persona> Personas;
	
	
	public void leer_Archivo()
	{
		
	    Personas = new ArrayList<Persona>();
		FileReader entrada;
		try {
			entrada = new FileReader("Personas.txt");
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea;
			while ((linea=miBuffer.readLine())!= null) {
			 
				String []datos=linea.split("-");
				
				// Persona per=new Persona(datos[0],datos[1],datos[2]); //esta solo lee la posision 0
				String apellido="";
				String dni="";
				for(int i=0;i<datos.length;i++)   //con este parche si lee las 3 posisiones del arreglo
				{
					if (i==1) {apellido=datos[i];}
					if (i==2) { dni=datos[i];}
				}
							
				Persona per=new Persona(datos[0],apellido,datos[2]);
				Personas.add(per);
			}
			miBuffer.close();
			entrada.close();

		    }
		catch (IOException e)
		    {
			  System.out.println("No se encontro el archivo");
		    }
     }
	
	public void Mostrar_Personas()
	{			
		Iterator<Persona>it=Personas.iterator();

		while(it.hasNext())
		{
		Persona persona= it.next();
		    System.out.println(persona.toString());
		}
	}
	
}