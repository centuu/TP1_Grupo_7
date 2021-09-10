package Ejercicio1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {	
	public static ArrayList<String> leer_Archivo(String path)
	{		
		ArrayList<String> registros = new ArrayList<String>();

		try 
		{
			FileReader entrada = new FileReader(path);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea;
			while ((linea = miBuffer.readLine()) != null)
			{
				if(linea.trim().isEmpty()) 
					continue;
				else 
					registros.add(linea);	
			}
			
			miBuffer.close();
			entrada.close();		
		}
		catch (IOException e)
		{
			System.out.println("No se encontro el archivo");
		}
		
		return registros;
     }	
}