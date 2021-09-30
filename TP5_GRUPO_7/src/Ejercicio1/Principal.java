package Ejercicio1;

import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;

public class Principal extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame("Trabajo Practico N° 5 - Grupo N° 7");
	
	public static void main(String[] args) 
	{	
		new Principal();
	}
	
	public Principal() 
	{
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Peliculas");
		JMenuItem item1 = new JMenuItem("Agregar");
		JMenuItem item2 = new JMenuItem("Listar");
		
		frame.setJMenuBar(barra);
		barra.add(menu);
		
		menu.add(item1);
		menu.add(item2);
		
		item1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Peliculas("Agregar");
			}
		});
		
		item2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Peliculas("Listar");
			}
		});
		
		frame.setSize(600,400);
		frame.setLocation(350, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
}