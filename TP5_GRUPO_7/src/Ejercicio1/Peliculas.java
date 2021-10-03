package Ejercicio1;

import java.awt.event.*;
import javax.swing.*;

import java.awt.BorderLayout;

public class Peliculas extends JFrame 
{	
	private static final long serialVersionUID = 1L;
	private int id;
	private Categorias cat;
	private String nombre;
	private static int contador = 0;
	private JTextField txtNombre;
	
	public Peliculas(Categorias cat, String nombre)
	{
		contador++;
		this.id = contador;
		this.setCat(cat);
		this.setNombre(nombre);
	}
	
	public static int devuelveProximoID() 
	{
		return contador+1;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public Categorias getCat() 
	{
		return cat;
	}
	
	private void setCat(Categorias cat) 
	{
		this.cat = cat;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	private void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
}