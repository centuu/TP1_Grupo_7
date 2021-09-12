package Ejercicio1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class Archivo {
	
	String ruta;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean crearArchivo(String path)
	{
		FileWriter escritura;
		try
		{
			escritura = new FileWriter (path,true);
			escritura.write("");
			escritura.close();
			return true;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean existe (String path)
	{
		File archivo = new File (path);
		if(archivo.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}	

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
	
	public void escribeLineas (String linea)
	{
		try
		{
			FileWriter entrada = new FileWriter (ruta,true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(linea);
			miBuffer.close();
			entrada.close();		
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void leeLineas()
	{
		FileReader entrada;
		try
		{
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = "";
			while(linea != null)
			{
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			
			miBuffer.close();
			entrada.close();
		}
		catch (IOException e)
		{
			System.out.println("No se encontro el archivo");
		}
	}
	
	//Pablo Torres
	public void crearNuevoArchivoDePersonas(String newPath, boolean isNewFile, ArrayList<Persona> personas) {
		Iterator<Persona> it = personas.iterator();
		try {
			if(isNewFile)
			{
				FileWriter entrada = new FileWriter(newPath, false);
				BufferedWriter miBuffer = new BufferedWriter(entrada);
				while(it.hasNext())
				{
					miBuffer.write(it.next().toString()+"\n");
				}
				miBuffer.close();
				entrada.close();
			}
			else
			{
				FileWriter entrada = new FileWriter(newPath, false);
				BufferedWriter miBuffer = new BufferedWriter(entrada);
				while(it.hasNext())
				{
					miBuffer.write(it.next().toString()+"\n");
				}
				miBuffer.close();
				entrada.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//Pablo Torres
}