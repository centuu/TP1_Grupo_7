package Ejercicio1;

public class Categorias 
{
	private final int id;
	private String nombre;
	private static int contador = 0;
	
	public Categorias(String nombre)
	{
		contador++;
		this.id = contador;
		this.setNombre(nombre);
	}	
	
	public String getNombre() 
	{
		return nombre;
	}
	
	private void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public int getId() 
	{
		return id;
	}
}