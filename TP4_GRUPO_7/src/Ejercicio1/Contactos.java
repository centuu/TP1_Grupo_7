package Ejercicio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Contactos extends JFrame  
{
	private static final long serialVersionUID = 1L;
	private static JTextField textField = new JTextField();
	private static JTextField textField_1 = new JTextField();
	private static JTextField textField_2 = new JTextField();
	private static JTextField textField_3 = new JTextField();
	private static JButton btnMostrar = new JButton("Mostrar");
	
	public Contactos()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
	    setSize(402,400);
		setLocation(350, 150);

		
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(85, 51, 46, 14);
		this.getContentPane().add(lbNombre);
		
		JLabel lbApellido = new JLabel("Apellido");
		lbApellido.setBounds(85, 76, 46, 14);
		this.getContentPane().add(lbApellido);
		
		JLabel lbFechanac = new JLabel("FechaNac");
		lbFechanac.setBounds(85, 148, 46, 14);
		this.getContentPane().add(lbFechanac);
		
		JLabel lbTelefono = new JLabel("Telefono");
		lbTelefono.setBounds(85, 112, 46, 14);
		this.getContentPane().add(lbTelefono);
		
		textField.setBounds(161, 48, 86, 20);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1.setColumns(10);
		textField_1.setBounds(161, 73, 86, 20);
		this.getContentPane().add(textField_1);
		
		textField_2.setColumns(10);
		textField_2.setBounds(161, 109, 86, 20);
		this.getContentPane().add(textField_2);
		
		textField_3.setColumns(10);
		textField_3.setBounds(161, 145, 86, 20);
		this.getContentPane().add(textField_3);
		

		btnMostrar.setBounds(141, 225, 89, 23);
		this.getContentPane().add(btnMostrar);
		btnMostrar.addActionListener(new EventoMostar());

		((JPanel)this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
	
}

class EventoMostar implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		System.out.println("Mostrar");	
	}
	
	
}


