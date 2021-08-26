package Ejercicio1;

public class Empleado {
	
	private int id;
	private String nombre;
	private int edad;
	private static int contador = 1000;
	
	public Empleado(){
		contador++;
		this.setNombre("sin nombre");
		this.setEdad(99);
		this.setId(contador);
	}
	
	public Empleado(String nombre, int edad){
		contador++;
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setId(contador);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
