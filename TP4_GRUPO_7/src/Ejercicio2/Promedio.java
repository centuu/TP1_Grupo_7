package Ejercicio2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Promedio extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static JButton btnCalcular = new JButton("Calcular");
	private static JButton btnNuevo = new JButton("Nuevo");
	private static JButton btnSalir = new JButton("Salir");
	private static JPanel paneNotas = new JPanel();
	private static JLabel lblNota1 = new JLabel("Nota 1");
	private static JTextField txtNota1 = new JTextField();
	private static JLabel lblNota2 = new JLabel("Nota 2");
	private static JTextField txtNota2 = new JTextField();
	private static JLabel lblNota3 = new JLabel("Nota 3");
	private static JTextField txtNota3 = new JTextField();
	private static JLabel lblTPS = new JLabel("TPS");
	private static JPanel paneResultados = new JPanel();
	private static JLabel lblPromedio = new JLabel("Promedio");
	private static JLabel lblCondicion = new JLabel("Condicion");
	private static JTextField txtPromedio = new JTextField();
	private static JTextField txtCondicion = new JTextField();
	private static JLabel lblError = new JLabel("");
	private static JComboBox<String> cbTPS = new JComboBox<String>(new String[] {"Aprobado", "Desaprobado"} );
	
	public Promedio() 
	{
		this.setBounds(100, 100, 458, 481);
		this.setLocation(350, 150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btnCalcular.setBounds(324, 137, 89, 23);
		btnCalcular.addActionListener(new EventoCalcular());
		btnNuevo.setBounds(324, 187, 89, 23);
		btnNuevo.addActionListener(new EventoNuevo());
		btnSalir.setBounds(324, 232, 89, 23);
		
		btnSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
	
		paneNotas.setBounds(18, 45, 296, 210);
		paneNotas.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));
		paneNotas.setLayout(null);
		
		lblNota1.setBounds(27, 31, 49, 21);
		lblNota2.setBounds(27, 69, 46, 14);
		lblNota3.setBounds(27, 110, 46, 14);
		lblTPS.setBounds(27, 152, 46, 14);
		txtNota1.setBounds(141, 31, 118, 20);
		txtNota2.setBounds(141, 66, 118, 20);
		txtNota3.setBounds(141, 107, 118, 20);

		txtNota1.setColumns(10);
		txtNota2.setColumns(10);
		txtNota3.setColumns(10);

		cbTPS.setSelectedIndex(-1);
		cbTPS.setBounds(141, 149, 118, 20);
		
		paneNotas.add(lblNota1);
		paneNotas.add(lblNota2);
		paneNotas.add(lblNota3);
		paneNotas.add(lblTPS);
		paneNotas.add(txtNota1);
		paneNotas.add(txtNota2);
		paneNotas.add(txtNota3);
		paneNotas.add(cbTPS);
		
		paneResultados.setBounds(18, 294, 296, 126);
		paneResultados.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));
		paneResultados.setLayout(null);
		
		lblPromedio.setBounds(44, 26, 69, 32);
		lblCondicion.setBounds(44, 69, 69, 27);
		txtPromedio.setBounds(146, 32, 108, 20);
		txtCondicion.setBounds(146, 72, 108, 20);

		txtCondicion.setColumns(10);
		txtPromedio.setColumns(10);
		
		paneResultados.add(lblPromedio);
		paneResultados.add(lblCondicion);
		paneResultados.add(txtPromedio);
		paneResultados.add(txtCondicion);

		lblError.setForeground(Color.RED);
		lblError.setBounds(28, 269, 46, 14);
		
		((JPanel)this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setLayout(null);
		this.getContentPane().add(btnCalcular);
		this.getContentPane().add(btnNuevo);
		this.getContentPane().add(btnSalir);
		this.getContentPane().add(paneNotas);
		this.getContentPane().add(paneResultados);
		this.getContentPane().add(lblError);

		this.setVisible(true);
	}
	
	class EventoNuevo implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			txtPromedio.setText("");
			txtCondicion.setText("");
			txtNota1.setText("");
			txtNota2.setText("");
			txtNota3.setText("");
		}
	}
	
	class EventoCalcular implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			float resultado;
			if(txtNota1.getText().length() != 0 && txtNota2.getText().length() != 0 && txtNota3.getText().length() != 0)
			{
				resultado = Float.valueOf(txtNota1.getText()) + Float.valueOf(txtNota2.getText()) + Float.valueOf(txtNota3.getText());
				resultado = resultado / 3;
				txtPromedio.setText(String.valueOf(resultado));
				
				if(cbTPS.getSelectedItem() == "Desaprobado")
				{
					txtCondicion.setText("Libre");
				}
				else if(Float.valueOf(txtNota1.getText())<6 || Float.valueOf(txtNota2.getText())<6 || Float.valueOf(txtNota3.getText())<6)
				{
					txtCondicion.setText("Libre");
				}
				else if((Float.valueOf(txtNota1.getText())>=8 && Float.valueOf(txtNota2.getText())>=8 && Float.valueOf(txtNota3.getText())>=8) && cbTPS.getSelectedItem() == "Aprobado")
				{
					txtCondicion.setText("Promocionado");
				}
				else if(cbTPS.getSelectedItem() == "Aprobado")
				{
					txtCondicion.setText("Regular");
				}
				else
				{
					lblError.setText("Faltan completar datos");
				}
			}
		}
	}
}