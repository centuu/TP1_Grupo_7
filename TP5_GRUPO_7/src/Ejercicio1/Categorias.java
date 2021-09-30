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
		this.nombre = nombre;
	}	
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public int getId() 
	{
		return id;
	}
}