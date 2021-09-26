package main;
import Ejercicio1.Contactos;
import Ejercicio2.VentanaPromedio;
import Ejercicio3.SeleccionMultiple;

import java.awt.event.*;
import javax.swing.*;

public class main extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame("Trabajo Practico N° 4");
	private static JLabel lblGrupo = new JLabel("GRUPO NRO: 7");
	private static JButton btnEjercicio1 = new JButton("Ejercicio 1");
	private static JButton btnEjercicio2 = new JButton("Ejercicio 2");
	private static JButton btnEjercicio3 = new JButton("Ejercicio 3");
	
	public static void main(String[] args)
	{
		frame.setSize(400,200);
		frame.setLocation(350, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblGrupo.setBounds(15, 15, 90, 15);

		btnEjercicio1.setBounds(130,30, 140,30);
		btnEjercicio1.addActionListener(new EventoBoton());
		
		btnEjercicio2.setBounds(130,70, 140,30);
		btnEjercicio2.addActionListener(new EventoBoton2());
		
		btnEjercicio3.setBounds(130,110, 140,30);
		btnEjercicio3.addActionListener(new EventoBoton3());
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnEjercicio1);
		frame.getContentPane().add(btnEjercicio2);
		frame.getContentPane().add(btnEjercicio3);
		frame.getContentPane().add(lblGrupo);
		frame.setVisible(true);
	}
}

class EventoBoton implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new Contactos();	
	}
}

class EventoBoton2 implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		new VentanaPromedio();
	}
}

class EventoBoton3 implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new SeleccionMultiple();
	}
}