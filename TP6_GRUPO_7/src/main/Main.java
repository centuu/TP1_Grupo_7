package main;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

import java.util.ArrayList;
import java.util.Iterator;

import daoImpl.PersonaDaoIml;

public class Main 
{
	public static void main(String[] args) 
	{
		/*PersonaDaoIml mn = new PersonaDaoIml();
			
		//Probando la conexion a base de dtaos
		
		//Persona per=new Persona(45,"Josefina","Fernandez");				
		//mn.insert(per);
		//System.out.print(per.toString());

	    //	mn.Delete(per);
		
				
		ArrayList<Persona>personas= new ArrayList<Persona>();
		personas=mn.List();
		
       Iterator <Persona> it=personas.iterator();
       
       while(it.hasNext())
       {
    	   System.out.println(it.next().toString());
       }*/
		
		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio pNeg = new PersonaNegocio();
		
		Controlador controlador = new Controlador(vista, pNeg);
		
		controlador.Inicializar();
	}
}
