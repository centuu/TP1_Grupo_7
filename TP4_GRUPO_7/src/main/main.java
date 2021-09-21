package main;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.setSize(400,200);
		frame.setLocation(350, 150);
		//frame.setBounds(350, 350, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Trabajo Practico N° 4");
		
		JLabel l = new JLabel();
		
		// add text to label
        l.setText("GRUPO NRO: 7");
        l.setBounds(15, 15, 90, 15);
        
		frame.getContentPane().add(l);
		//frame.show();
		
		JButton boton = new JButton();
		boton.setText("Ejercicio 1");
		boton.setBounds(130,30, 140,30);
		boton.addActionListener(new EventoBoton());
		
		JButton boton2 = new JButton();
		boton2.setText("Ejercicio 2");
		boton2.setBounds(130,70, 140,30);
		boton2.addActionListener(new EventoBoton2());
		
		JButton boton3 = new JButton();
		boton3.setText("Ejercicio 3");
		boton3.setBounds(130,110, 140,30);
		boton3.addActionListener(new EventoBoton3());
		
		frame.setLayout(null);
		frame.getContentPane().add(boton);
		frame.getContentPane().add(boton2);
		frame.getContentPane().add(boton3);
		frame.setVisible(true);
	}
}

class EventoBoton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Prueba Boton 1");
	}
}

class EventoBoton2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Prueba Boton 2");
	}
}

class EventoBoton3 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Prueba Boton 3");
	}
}