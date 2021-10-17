package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelAgregar extends JPanel
{
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
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
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(93, 185, 118, 23);
		add(btnAceptar);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(93, 90, 46, 14);
		add(lblApellido);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setBounds(264, 185, 156, 20);
		add(lblMensaje);
	}
}
