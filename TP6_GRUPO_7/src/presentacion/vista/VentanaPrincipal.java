package presentacion.vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	
	public VentanaPrincipal() 
	{
		this.setTitle("Trabajo Practico N° 6 - Grupo N° 7");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JMenuBar barra = new JMenuBar();	
		JMenu menu = new JMenu("Persona");
		
		JMenuItem item1 = new JMenuItem("Agregar");
		item1.addActionListener(new EventoAgregar());
		menu.add(item1);
		
		JMenuItem item2 = new JMenuItem("Modificar");
		item2.addActionListener(new EventoModificar());
		menu.add(item2);

		JMenuItem item3 = new JMenuItem("Eliminar");
		item3.addActionListener(new EventoEliminar());
		menu.add(item3);
		
		JMenuItem item4 = new JMenuItem("Listar");
		item4.addActionListener(new EventoListar());
		menu.add(item4);
		
		barra.add(menu);
		
		this.setJMenuBar(barra);
		
		this.setSize(600,400);
		this.setLocation(350, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(contentPane);
		this.setVisible(true);
	}
	
	class EventoAgregar implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.removeAll();
			PanelAgregar panel = new PanelAgregar();
			contentPane.add(panel);
			contentPane.revalidate();
			contentPane.repaint();	
		}
	}
	
	class EventoListar implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.removeAll();
			PanelListar panel = new PanelListar();
			contentPane.add(panel);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
	
	class EventoModificar implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.removeAll();
			PanelModificar panel = new PanelModificar();
			contentPane.add(panel);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
	
	class EventoEliminar implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.removeAll();
			PanelEliminar panel = new PanelEliminar();
			contentPane.add(panel);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
}