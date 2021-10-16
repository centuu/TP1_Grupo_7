package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PanelEliminar extends JPanel
{
	public PanelEliminar() {
		setLayout(null);
		
		JTextArea txtLista = new JTextArea();
		txtLista.setBounds(130, 51, 200, 200);
		add(txtLista);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setBounds(130, 32, 132, 14);
		add(lblEliminarUsuarios);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(173, 262, 89, 23);
		add(btnEliminar);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setBounds(10, 312, 430, 14);
		add(lblMensaje);
	}
}
