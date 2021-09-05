package Ejercicio1;
import java.util.TreeSet;
import java.util.Iterator;

public class Profesor extends Empleado 
{	
	private String cargo;
	private int antiguedadDocente;
	static private TreeSet<String> tsProfesores = new TreeSet<String>();
	
	Profesor() 
	{
		super();
	}
	
	Profesor(String nombre, int edad,String cargo,int antiguedad)
	{
		super(nombre,edad);
		this.setCargo(cargo);
		this.setAntiguedadDocente(antiguedad);
		tsProfesores.add(this.toString());
	}
	
	public String getCargo() 
	{
		return cargo;
	}
	
	private void setCargo(String cargo) 
	{
		this.cargo = cargo;
	}
	
	public int getAntiguedadDocente() 
	{
		return antiguedadDocente;
	}
	
	private void setAntiguedadDocente(int antiguedadDocente)
	{
		this.antiguedadDocente = antiguedadDocente;
	}
	
	public static void showAllProfesores()
	{
	    Iterator<String> it = tsProfesores.iterator();

		while (it.hasNext())
		{
	    	System.out.println(it.next());
		}
	}
	
	public Boolean compareTo(Profesor p) 
	{
		return (this.getNombre() == p.getNombre() && this.getEdad() == p.getEdad() && this.getCargo() == p.getCargo() && this.getAntiguedadDocente() == p.getAntiguedadDocente());
	}
	@Override
	public String toString() 
	{
		return "ID: " + this.getId() + ", Nombre: " + this.getNombre() + ", Edad: " + this.getEdad() + ", Cargo: " + this.getCargo() + ", Antiguedad: " + this.getAntiguedadDocente();
	}
}
