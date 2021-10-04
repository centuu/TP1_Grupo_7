package Ejercicio1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelAgregarPeliculas extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre = new JTextField();
	private JLabel lblNum = new JLabel("ID");
	private JLabel lblNombre = new JLabel("Nombre");
	private JLabel lblGenero = new JLabel("Genero");
    private JLabel lblID = new JLabel("ID ");
	private JButton btnAceptar = new JButton("Aceptar");
	private JComboBox<Categorias> cbGenero;
	private DefaultListModel<Peliculas> listModel = new DefaultListModel<Peliculas>();
	
	public PanelAgregarPeliculas(DefaultListModel<Peliculas> listModelRecibido) 
	{
        setBackground(Color.white);
		setLayout(null);
		
		lblNum.setBounds(238, 74, 11, 14);
		lblNum.setText(String.valueOf(Peliculas.getContador()));
		this.add(lblNum);		
		
		lblID.setBounds(146, 74, 46, 14);
		this.add(lblID);
		
		lblNombre.setBounds(146, 102, 48, 14);
		this.add(lblNombre);
		
		txtNombre.setBounds(204, 99, 86, 20);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		cbGenero = new JComboBox<Categorias>();
		cbGenero.setBounds(204, 130, 86, 20);
		Categorias aux = new Categorias("seleccione genero");
		cbGenero.addItem(aux);
		cbGenero.addItem(new Categorias("Terror"));
		cbGenero.addItem(new Categorias("Accion"));
		cbGenero.addItem(new Categorias("Suspenso"));
		cbGenero.addItem(new Categorias("Romantica"));
		
	    lblGenero.setBounds(146, 133, 48, 14);
	    this.add(lblGenero);	
		add(cbGenero);
		
		
		btnAceptar.setBounds(193, 210, 86, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		

				if (cbGenero.getSelectedIndex() != 0 && !txtNombre.getText().isEmpty()) {
					Peliculas pelicula = new Peliculas();
					pelicula.setNombre(txtNombre.getText());
					pelicula.setCat( (Categorias)cbGenero.getSelectedItem() );
					listModel.addElement(pelicula);
					JOptionPane.showMessageDialog(null, "se agrego pelicula");
					limpiarPanel();
				}
				else {
					String msjError = new String();
					if (cbGenero.getSelectedIndex() == 0) {
						msjError = " Debe seleccionar un género";
					}
					if (txtNombre.getText().isEmpty()) {
						msjError += "\n* Debe ingresar nombre de película.";
					}
					JOptionPane.showMessageDialog(null, msjError);
				}
				
			}

			private void limpiarPanel() {
				txtNombre.setText("");
				cbGenero.setSelectedIndex(0);
				lblNum.setText(String.valueOf(Peliculas.getContador()));
				
			}
			

		});
		add(btnAceptar);		
		
		this.setDefaultListModel(listModelRecibido);
	}
	
	public void setDefaultListModel(DefaultListModel<Peliculas> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
}
