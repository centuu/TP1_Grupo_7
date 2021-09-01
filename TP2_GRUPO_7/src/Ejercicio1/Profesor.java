package Ejercicio1;

public class Profesor extends Empleado {
	private String cargo;
	private int antiguedadDocente;
	
	Profesor (){
		super();
	}
	
	Profesor (String nombre, int edad,String cargo,int antiguedad){
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
		return "id: " + this.getId() + ", nombre: " + this.getNombre() + ", edad: " + this.getEdad() + ", cargo: " + this.getCargo() + ", antiguedad: " + this.getAntiguedadDocente();
	}
}
