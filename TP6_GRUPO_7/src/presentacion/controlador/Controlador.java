package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener
{
	private VentanaPrincipal ventanaPrincipal;
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		this.ventanaPrincipal = vista;
	}

	public void Inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)	{}
}