package Ejercicio1;

import java.awt.Color;
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
	private JPanel contentPane;
	private static JTextField txtNombre = new JTextField();
	private static JTextField txtApellido = new JTextField();
	private static JTextField txtTelefono = new JTextField();
	private static JTextField txtFechaNacimiento = new JTextField();
	private static JLabel lblResultado = new JLabel();
	private static JButton btnMostrar = new JButton("Mostrar");
	
	public Contactos()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblResultado = new JLabel("Resultado: ");
		lblResultado.setBounds(21, 298, 333, 14);
		this.getContentPane().add(lblResultado);
		
		txtNombre.setBounds(161, 48, 86, 20);
		this.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido.setColumns(10);
		txtApellido.setBounds(161, 73, 86, 20);
		this.getContentPane().add(txtApellido);
		
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(161, 109, 86, 20);
		this.getContentPane().add(txtTelefono);
		
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(161, 145, 86, 20);
		this.getContentPane().add(txtFechaNacimiento);
		

		btnMostrar.setBounds(141, 225, 89, 23);
		this.getContentPane().add(btnMostrar);
		btnMostrar.addActionListener(new EventoMostar(txtNombre, txtApellido, txtTelefono, txtFechaNacimiento, lblResultado));

		((JPanel)this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
	
}

class EventoMostar implements ActionListener
{
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNacimiento;
	private JLabel lblResultado;
	
	public EventoMostar(JTextField txtName, JTextField txtApe, JTextField txtTel, JTextField txtNac, JLabel lblResult)
	{
		txtNombre = txtName;
		txtApellido = txtApe;
		txtTelefono = txtTel;
		txtNacimiento = txtNac;
		lblResultado = lblResult;
	}
	
	public boolean CheckIsEmpty(JTextField txtField)
	{
		if(txtField.getText().isEmpty())
		{
			txtField.setBackground(Color.red);
			return true;
		}
		else
		{
			txtField.setBackground(Color.white);
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		boolean isCompleted = false;
		
		if(!CheckIsEmpty(txtNombre))
		{
			isCompleted = true;
		}
		if(!CheckIsEmpty(txtApellido))
		{
			isCompleted = true;
		}
		if(!CheckIsEmpty(txtTelefono))
		{
			isCompleted = true;
		}
		if(!CheckIsEmpty(txtNacimiento))
		{
			isCompleted = true;
		}
		
		if(isCompleted==true)
		{
			lblResultado.setText("Resultado: " +  txtNombre.getText() + "-" + txtApellido.getText() + "-" + txtTelefono.getText() + " " + txtNacimiento.getText());
		}
	}
	
	
}


