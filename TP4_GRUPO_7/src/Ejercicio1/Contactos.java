package Ejercicio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Contactos extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public Contactos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
	    setSize(402,400);
		setLocation(350, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(85, 51, 46, 14);
		contentPane.add(lbNombre);
		
		JLabel lbApellido = new JLabel("Apellido");
		lbApellido.setBounds(85, 76, 46, 14);
		contentPane.add(lbApellido);
		
		JLabel lbFechanac = new JLabel("FechaNac");
		lbFechanac.setBounds(85, 148, 46, 14);
		contentPane.add(lbFechanac);
		
		JLabel lbTelefono = new JLabel("Telefono");
		lbTelefono.setBounds(85, 112, 46, 14);
		contentPane.add(lbTelefono);
		
		textField = new JTextField();
		textField.setBounds(161, 48, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 73, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 109, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(161, 145, 86, 20);
		contentPane.add(textField_3);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(141, 225, 89, 23);
		contentPane.add(btnMostrar);
		btnMostrar.addActionListener(new EventoMostar());
	}
	
}

class EventoMostar implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mostrar");
		
	}
	
	
}


