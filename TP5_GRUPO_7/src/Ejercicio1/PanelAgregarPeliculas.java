package Ejercicio1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelAgregarPeliculas extends JPanel 
{
	private JTextField txtNombre = new JTextField();
	private JLabel lblID = new JLabel("ID");
	private JLabel lblNombre = new JLabel("Nombre");
	private JLabel lblGenero = new JLabel("Genero");
	private JLabel lblAutonumerico = new JLabel("New label");
	private JButton btnAceptar = new JButton("Aceptar");
	private JLabel lblError = new JLabel("New label");
	private JComboBox<String> cbGenero = new JComboBox<String>();
	private DefaultListModel<Peliculas> listModel = new DefaultListModel<Peliculas>();
	
	public PanelAgregarPeliculas(DefaultListModel<Peliculas> listModelRecibido) 
	{	
		lblID.setBounds(78, 50, 46, 14);
		this.add(lblID);
		
		lblNombre.setBounds(78, 100, 46, 14);
		this.add(lblNombre);
		
		lblGenero.setBounds(78, 150, 46, 14);
		this.add(lblGenero);
		
		lblAutonumerico.setBounds(223, 50, 46, 14);
		this.add(lblAutonumerico);
		
		txtNombre.setBounds(223, 97, 134, 20);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		cbGenero.setBounds(223, 147, 134, 20);
		this.add(cbGenero);
		
		cbGenero.addItem("Seleccione un genero");
		cbGenero.addItem("Terror");
		cbGenero.addItem("Accion");
		cbGenero.addItem("Suspenso");
		cbGenero.addItem("Romantica");
		
		btnAceptar.setBounds(78, 188, 122, 23);
		add(btnAceptar);
		
		lblError.setBounds(78, 246, 279, 14);
		add(lblError);
		
		this.setDefaultListModel(listModelRecibido);
	}
	
	public void setDefaultListModel(DefaultListModel<Peliculas> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
	
}
