package Ejercicio1;

public class Profesor extends Empleado {
	private String cargo;
	private int antiguedadDocente;
	
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
