package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

import daoImpl.PersonaDaoIml;
import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelEliminar extends JPanel
{
	private JList<String> jListArea;
	private DefaultListModel<String> model; 

	private static final long serialVersionUID = 1L;

	public PanelEliminar() {
		setLayout(null);
		
		jListArea = new JList();
		jListArea.setBounds(130, 51, 200, 200);
		add(jListArea);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setBounds(130, 32, 132, 14);
		add(lblEliminarUsuarios);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(173, 262, 89, 23);
		add(btnEliminar);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setBounds(10, 312, 430, 14);
		add(lblMensaje);
		
		this.LlenarJList();

	}
	
	public JList getjListArea() {
		return jListArea;
	}

	public void setjListArea(JList jListArea) {
		this.jListArea = jListArea;
	}



	public void LlenarJList()
	{
		PersonaDaoIml mn = new PersonaDaoIml();
		
		ArrayList<Persona> lista = mn.List();
		
		model = new DefaultListModel<>();

		for (Persona p : lista)
		{
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			String DNI = p.getDni();
			
			model.addElement( nombre+ " "+ apellido + " "+ DNI );
		}
		
		jListArea.setModel(model);

	}
}
