package Ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Principal extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private static DefaultListModel<Peliculas> listModel = new DefaultListModel<Peliculas>();
	
	public static void main(String[] args) 
	{	
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try 
				{
					Principal frame = new Principal();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() 
	{
		this.setTitle("Trabajo Practico N° 5 - Grupo N° 7");
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JMenuBar barra = new JMenuBar();	
		JMenu menu = new JMenu("Peliculas");
		
		JMenuItem item1 = new JMenuItem("Agregar");
		item1.addActionListener(new EventoAgregar());
		menu.add(item1);
		
		JMenuItem item2 = new JMenuItem("Listar");
		item2.addActionListener(new EventoListar());
		menu.add(item2);
		
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
			PanelAgregarPeliculas panel = new PanelAgregarPeliculas();
			panel.setDefaultListModel(listModel);
			contentPane.add(new PanelAgregarPeliculas(listModel));
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
			PanelListadoPeliculas panel = new PanelListadoPeliculas();
			contentPane.add(panel);
			panel.setDefaultListModel(listModel);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
}