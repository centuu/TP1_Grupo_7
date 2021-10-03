package Ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.EventQueue;

public class Principal extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame("Trabajo Practico N° 5 - Grupo N° 7");
	private JPanel contentPane;
	private static DefaultListModel<Peliculas> listModel;
	
	public static void main(String[] args) 
	{	
		EventQueue.invokeLater(new Runnable(){
		public void run() {
			try {
				Principal frame = new Principal();
				listModel = new DefaultListModel<Peliculas>();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	  });

	}
	
	public Principal() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		
		JMenu menu = new JMenu("Peliculas");
		JMenuItem item1 = new JMenuItem("Agregar");
		JMenuItem item2 = new JMenuItem("Listar");
		
		frame.setJMenuBar(barra);
		barra.add(menu);
		
		menu.add(item1);
		menu.add(item2);
		
		item1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				contentPane.removeAll();
				PanelAgregarPeliculas panel = new PanelAgregarPeliculas();
				panel.setDefaultListModel(listModel);
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		menu.add(item1);
		
		item2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				contentPane.removeAll();
				PanelListadoPeliculas panel = new PanelListadoPeliculas();
				panel.setDefaultListModel(listModel);
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menu.add(item2);
		
		frame.setSize(600,400);
		frame.setLocation(350, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
}