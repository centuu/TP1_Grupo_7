package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class PanelListar extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public PanelListar() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 48, 357, 187);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "DNI"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(74);
	}
}
