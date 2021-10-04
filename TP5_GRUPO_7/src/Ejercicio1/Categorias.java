package Ejercicio1;

public class Categorias 
{
	private String nombre;

	
	public Categorias()
	{
	    
	}	
	public Categorias(String nombre)
	{
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

	@Override
	public String toString() {
		return nombre ;
	}
	

}