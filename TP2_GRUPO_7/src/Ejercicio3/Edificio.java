package Ejercicio3;

public abstract class Edificio {
	private String nombre;
	private double Superficie;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSuperficie() {
		return Superficie;
	}
	public double setSuperficie(double ancho, double largo) {
		return Superficie = ancho*largo;
	}
	
	//Metodos
	public abstract double getSuperficieEdificio(); 
	
	
}
