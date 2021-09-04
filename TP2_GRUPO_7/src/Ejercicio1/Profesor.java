package Ejercicio1;

public class Profesor extends Empleado {
	
	private String cargo;
	private int antiguedadDocente;
	public int compareTo(Profesor p) {
		if (this.getNombre() == p.getNombre() && this.getEdad() == p.getEdad() && this.getCargo() == p.getCargo() 
			&& this.getAntiguedadDocente() == p.getAntiguedadDocente()) {  
	        return -1;  
	    }
		return 0;
	}
	
	Profesor() {
		super();
	}
	
	Profesor(String nombre, int edad,String cargo,int antiguedad) {
		super(nombre,edad);
		this.cargo=cargo;
		this.antiguedadDocente=antiguedad;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getAntiguedadDocente() {
		return antiguedadDocente;
	}
	public void setAntiguedadDocente(int antiguedadDocente) {
		this.antiguedadDocente = antiguedadDocente;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", Nombre: " + this.getNombre() + ", Edad: " + this.getEdad() + ", Cargo: " + this.getCargo() + ", Antiguedad: " + this.getAntiguedadDocente();
	}
}
