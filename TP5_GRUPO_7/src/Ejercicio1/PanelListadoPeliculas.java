package Ejercicio1;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;



public class PanelListadoPeliculas extends JPanel 
{
	private DefaultListModel<Peliculas> listModel = new DefaultListModel<Peliculas>();

	public PanelListadoPeliculas(DefaultListModel<Peliculas> listModelRecibido) 
	{	
		JTextArea txtAreaPeliculas = new JTextArea();
		txtAreaPeliculas.setBounds(157, 11, 271, 278);
		this.add(txtAreaPeliculas);	

		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setBounds(101, 141, 46, 14);
		add(lblPeliculas);
		
		this.setDefaultListModel(listModelRecibido);
	}

	private void setDefaultListModel(DefaultListModel<Peliculas> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
}