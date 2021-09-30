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
	
	/*public Peliculas(Categorias cat, String nombre)
	{
		contador++;
		this.id = contador;
		this.cat = cat;
		this.nombre = nombre;
	}*/	
	
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
	public void setCat(Categorias cat) 
	{
		this.cat = cat;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public Peliculas(String opc) 
	{	
		switch (opc) {
			case "Agregar":
				AgregarPeliculas();
				break;
			case "Listar":
				ListarPeliculas();
				break;
		}
	}
	
	public void AgregarPeliculas()
	{
		this.setTitle("Agregar Peliculas");
		
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Peliculas");
		JMenuItem item1 = new JMenuItem("Agregar");
		JMenuItem item2 = new JMenuItem("Listar");
		
		this.setJMenuBar(barra);
		barra.add(menu);
		
		menu.add(item1);
		menu.add(item2);
		
		this.setSize(600,400);
		this.setLocation(350, 150);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
	public void ListarPeliculas()
	{
		this.setTitle("Listar Peliculas");
		
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Peliculas");
		JMenuItem item1 = new JMenuItem("Agregar");
		JMenuItem item2 = new JMenuItem("Listar");
		
		this.setJMenuBar(barra);
		barra.add(menu);
		
		menu.add(item1);
		menu.add(item2);
		
		this.setSize(600,400);
		this.setLocation(350, 150);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
}