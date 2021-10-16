package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener
{
	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
	}

	public void Inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)	{}
}