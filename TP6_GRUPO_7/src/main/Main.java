package main;

import negocio.PersonaNegocio;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Main 
{
	public static void main(String[] args) 
	{	
		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio pNeg = new PersonaNegocio();
		
		Controlador controlador = new Controlador(vista, pNeg);
		
		controlador.Inicializar();
	}
}
