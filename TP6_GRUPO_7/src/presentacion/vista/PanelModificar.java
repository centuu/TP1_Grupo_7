package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelModificar extends JPanel
{
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	public PanelModificar() {
		setLayout(null);
		
		JTextArea txtLista = new JTextArea();
		txtLista.setBounds(69, 43, 370, 215);
		add(txtLista);
		
		JLabel lblSeleccione = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccione.setBounds(73, 18, 366, 14);
		add(lblSeleccione);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(350, 269, 89, 23);
		add(btnModificar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(69, 269, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(165, 270, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(261, 270, 86, 20);
		add(txtDNI);
		txtDNI.setColumns(10);
	}

}
