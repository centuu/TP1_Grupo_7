package Ejercicio1;

public class Empleado {
	
	private final int id;
	private String nombre;
	private int edad;
	private static int contador = 999;
	
	public Empleado(){
		contador++;
		this.setNombre("sin nombre");
		this.setEdad(99);
		this.id = contador;
	}
	
	public Empleado(String nombre, int edad){
		contador++;
		this.setNombre(nombre);
		this.setEdad(edad);
		this.id = contador;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//Metodos
	public static int devuelveProximoID() {
		return contador+1;
	}

	@Override
	public String toString() {
		return "Empleado " + nombre + ", Edad: " + edad + ", Legajo: " + id;
	}
}