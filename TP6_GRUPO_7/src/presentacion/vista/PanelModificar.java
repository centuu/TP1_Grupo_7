package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import daoImpl.PersonaDaoIml;
import entidad.Persona;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class PanelModificar extends JPanel
{

	private JList<String> jListArea;
	private DefaultListModel<String> model; 
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	public PanelModificar() {
		
		setLayout(null);
		
		JLabel lblSeleccione = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccione.setBounds(22, 16, 366, 14);
		add(lblSeleccione);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonaDaoIml personaModificada = new PersonaDaoIml();
				if(!txtNombre.getText().isEmpty())
				{
					personaModificada.Edit(txtNombre.getText(), txtApellido.getText(), txtDNI.getText());
					txtNombre.setText("");
					txtApellido.setText("");
					txtDNI.setText("");
					LlenarJList();
				}
					
				
			}
		});
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
		
		jListArea = new JList();
		jListArea.setBounds(22, 41, 401, 207);
		add(jListArea);
		
		this.LlenarJList();

		jListArea.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0) {
	                  Object item = target.getModel().getElementAt(index);
	                  String nombreSeleccionado = item.toString();
	          		String DNI = nombreSeleccionado.substring(nombreSeleccionado.length() - 8);
	        		String arr[] = nombreSeleccionado.split(" ");
	        		String Nombre = arr[0];
	        		String Apellido = arr[1];
	        		txtNombre.setText(Nombre);
	        		txtApellido.setText(Apellido);
	        		txtDNI.setText(DNI);
	                 
	               }
	            }
	         }
	      });

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
