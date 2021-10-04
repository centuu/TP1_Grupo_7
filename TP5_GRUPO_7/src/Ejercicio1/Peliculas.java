package Ejercicio1;

import javax.swing.*;

public class Peliculas extends JFrame 
{	
	private static final long serialVersionUID = 1L;
	private int id;
	private Categorias cat;
	private String nombre;
	private static int contador = 1;
	
	public Peliculas() {
		this.id = contador++;
	}
	public Peliculas(Categorias cat, String nombre)
	{
		this.id=contador++;
		this.setCat(cat);
		this.setNombre(nombre);
	}
	
	public int getId() 
	{
		return id;
	}
	
	public Categorias getCat() 
	{
		return cat;
	}
	
	public void setCat(Categorias cat) 
	{
		this.cat = cat;
	}
	public static int getContador() 
	{
		return contador;
	}
	public Categorias getCategoria() {
		return cat;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
}