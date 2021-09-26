package Ejercicio3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class SeleccionMultiple extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static JPanel paneOS = new JPanel();
	private static ButtonGroup btnGroupOS = new ButtonGroup();
	private static JRadioButton rbtnWindows = new JRadioButton("Windows");
	private static JRadioButton rbtnMac = new JRadioButton("Mac");
	private static JRadioButton rbtnLinux = new JRadioButton("Linux");
	private static JLabel lblOs = new JLabel("Elije un sistema operativo");
	private static JPanel paneEspecialidad = new JPanel();
	private static JLabel lblEspecialidad = new JLabel("Elija una especialidad");
	private static JCheckBox chkboxProgramacion = new JCheckBox("Programacion");
	private static JCheckBox chkboxAdministracion = new JCheckBox("Administracion");
	private static JCheckBox chkboxDiseñoGrafico = new JCheckBox("Diseño Grafico");
	private static JLabel lblHoras = new JLabel("Cantidad de horas en el computador: ");
	private static JTextField txtHoras = new JTextField();
	private static JButton btnAceptar = new JButton("Aceptar");
	
	public SeleccionMultiple()
	{
		this.setBounds(100, 100, 458, 481);
		this.setLocation(350, 150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		paneOS.setBounds(18, 20, 400, 50);
		paneOS.setBorder(BorderFactory.createTitledBorder("Sistemas Operativos"));
		paneOS.setLayout(null);
		
		paneEspecialidad.setBounds(18, 80, 400, 200);
		paneEspecialidad.setBorder(BorderFactory.createTitledBorder("Especialidad"));
		paneEspecialidad.setLayout(null);
		
		rbtnWindows.setBounds(180,18,80,20);
		rbtnMac.setBounds(260,18,60,20);
		rbtnLinux.setBounds(320,18,70,20);
		lblOs.setBounds(22,18,150,20);
		
		btnGroupOS.add(rbtnWindows);
		btnGroupOS.add(rbtnMac);
		btnGroupOS.add(rbtnLinux);
		
		paneOS.add(rbtnWindows);
		paneOS.add(rbtnMac);
		paneOS.add(rbtnLinux);
		paneOS.add(lblOs);
		
		lblEspecialidad.setBounds(22,80,150,20);
		chkboxProgramacion.setBounds(220,30,130,20);
		chkboxAdministracion.setBounds(220,70,130,20);
		chkboxDiseñoGrafico.setBounds(220,110,130,20);
		
		paneEspecialidad.add(lblEspecialidad);
		paneEspecialidad.add(chkboxProgramacion);
		paneEspecialidad.add(chkboxAdministracion);
		paneEspecialidad.add(chkboxDiseñoGrafico);
		
		lblHoras.setBounds(22,300,250,20);
		txtHoras.setBounds(240,300,175,20);
		
		this.getContentPane().add(lblHoras);
		this.getContentPane().add(txtHoras);
		((JPanel)this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setLayout(null);
		this.getContentPane().add(paneOS);
		this.getContentPane().add(paneEspecialidad);
				
		btnAceptar.setBounds(250,350,150,50);
		btnAceptar.addActionListener(new EventoBoton(rbtnWindows, rbtnMac, rbtnLinux, chkboxProgramacion, chkboxAdministracion, chkboxDiseñoGrafico, txtHoras));
		this.getContentPane().add(btnAceptar);
		
		this.setVisible(true);	
	}
}

class EventoBoton implements ActionListener 
{
	private static JRadioButton rbtnWindows;
	private static JRadioButton rbtnMac;
	private static JRadioButton rbtnLinux;
	
	private static JCheckBox chkboxProgramacion;
	private static JCheckBox chkboxAdministracion;
	private static JCheckBox chkboxDiseñoGrafico;
	
	private static JTextField txtHoras;
	
	EventoBoton(JRadioButton rbtnWindows, JRadioButton rbtnMac, JRadioButton rbtnLinux, JCheckBox chkboxProgramacion,
			JCheckBox chkboxAdministracion, JCheckBox chkboxDiseñoGrafico, JTextField txtHoras)
	{
		this.rbtnWindows = rbtnWindows;
		this.rbtnMac = rbtnMac;
		this.rbtnLinux = rbtnLinux;
		
		this.chkboxProgramacion = chkboxProgramacion;
		this.chkboxAdministracion = chkboxAdministracion;
		this.chkboxDiseñoGrafico = chkboxDiseñoGrafico;
		
		this.txtHoras = txtHoras;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String msg = "", os = "", esp = "";
		
		if (rbtnWindows.isSelected())
			os = rbtnWindows.getText();
		
		if (rbtnMac.isSelected())
			os = rbtnMac.getText();
		
		if (rbtnLinux.isSelected())
			os = rbtnLinux.getText();
		
		if (chkboxProgramacion.isSelected())
		{
			esp += "" + chkboxProgramacion.getText();
		}
		
		if (chkboxAdministracion.isSelected())
		{
			if (chkboxProgramacion.isSelected())
				esp += " - " + chkboxAdministracion.getText();
			else
				esp += "" + chkboxAdministracion.getText();
		}
		
		if (chkboxDiseñoGrafico.isSelected())
		{
			if (chkboxProgramacion.isSelected() || chkboxAdministracion.isSelected())
				esp += " - " + chkboxDiseñoGrafico.getText();
			else
				esp += "" + chkboxDiseñoGrafico.getText();
		}
		
		msg = "" + os + " - " + esp + " - " + txtHoras.getText() + " hs";
			
		JOptionPane.showMessageDialog (null, msg);	
	}
}