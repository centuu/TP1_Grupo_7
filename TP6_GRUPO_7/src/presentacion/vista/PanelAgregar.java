package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import daoImpl.PersonaDaoIml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import entidad.Persona;

public class PanelAgregar extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre = new JTextField();
	private JTextField txtApellido = new JTextField();
	private JTextField txtDNI  = new JTextField();
	public PanelAgregar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(93, 45, 46, 14);
		add(lblNombre);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(93, 135, 46, 14);
		add(lblDNI);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(221, 45, 137, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(221, 90, 137, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(221, 135, 137, 20);
		add(txtDNI);
		txtDNI.setColumns(10);
		
		txtDNI.addKeyListener(new KeyListener() {

	        @Override
	        public void keyTyped(KeyEvent e) {
	            String filterStr = "0123456789";
	            char c = (char)e.getKeyChar();
	            if(filterStr.indexOf(c)<0){
	                e.consume();
	            }
	        }
	        @Override
	        public void keyReleased(KeyEvent e) {}

	        @Override
	        public void keyPressed(KeyEvent e) {}
	    });
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(93, 185, 118, 23);
		btnAceptar.addActionListener(new EventoBoton(txtDNI, txtApellido, txtNombre));
		add(btnAceptar);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(93, 90, 46, 14);
		add(lblApellido);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setBounds(264, 185, 156, 20);
		add(lblMensaje);
	}
}

class EventoBoton implements ActionListener 
{
	private JTextField txtDNI, txtApellido, txtNombre;
	
	EventoBoton(JTextField txtDNI, JTextField txtApellido, JTextField txtNombre)
	{
		this.txtDNI = txtDNI;
		this.txtApellido = txtApellido;
		this.txtNombre = txtNombre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (txtDNI.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos.");
		}
		else
		{
			PersonaDaoIml mn = new PersonaDaoIml();
			
			Persona prs = new Persona(txtDNI.getText(), txtNombre.getText(), txtApellido.getText());
			
			if (mn.Insert(prs)) {
				JOptionPane.showMessageDialog(null, "Persona agregada: " + prs.toString());
				Limpiar();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se pudo agregar a la Persona.");
				Limpiar();
			}
		}
	}
	
	private void Limpiar() 
	{
		txtNombre.setText("");
		txtDNI.setText("");
		txtApellido.setText("");
		
	}
}