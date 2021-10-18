package presentacion.vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import daoImpl.PersonaDaoIml;
import entidad.Persona;

import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class PanelListar extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido","DNI"};
	
	public PanelListar() 
	{
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 48, 357, 187);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		table = new JTable(modelPersonas);

		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(74);
		
		scrollPane.setViewportView(table);
		
		this.LlenarTabla();
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public void LlenarTabla()
	{
		PersonaDaoIml mn = new PersonaDaoIml();
		
		ArrayList<Persona> lista = mn.List();
		
		this.getModelPersonas().setRowCount(0); 
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : lista)
		{
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			String DNI = p.getDni();
			Object[] fila = {nombre, apellido, DNI};
			
			this.getModelPersonas().addRow(fila);
		}
	}
}
