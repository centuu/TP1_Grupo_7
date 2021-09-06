package Ejercicio1;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Profesor extends Empleado 
{	
	private String cargo;
	private int antiguedadDocente;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + antiguedadDocente;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (antiguedadDocente != other.antiguedadDocente)
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		return true;
	}

	Profesor() 
	{
		super();
	}
	
	Profesor(String nombre, int edad,String cargo,int antiguedad)
	{
		super(nombre,edad);
		this.setCargo(cargo);
		this.setAntiguedadDocente(antiguedad);
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
	
	public static void showAllProfesoresFromTreeSet(TreeSet<String> tsProfesores)
	{
	    Iterator<String> it = tsProfesores.iterator();

		while (it.hasNext())
	    	System.out.println(it.next());
	}
	
	public static void showAllProfesoresFromArrayList(ArrayList<Profesor> ListaProfesores)
	{
	    Iterator<Profesor> it = ListaProfesores.iterator();

		while (it.hasNext())
	    	System.out.println(it.next().toString());
	}
	@Override
	public String toString() 
	{
		return "ID: " + this.getId() + ", Nombre: " + this.getNombre() + ", Edad: " + this.getEdad() + ", Cargo: " + this.getCargo() + ", Antiguedad: " + this.getAntiguedadDocente();
	}
}