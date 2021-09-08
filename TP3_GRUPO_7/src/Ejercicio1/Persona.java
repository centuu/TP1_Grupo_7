package Ejercicio1;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	
	Persona (String nombre,String apellido,String dni){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	@Override
	public String toString() {
		return "Nombre : " + nombre + ",  apellido : " + apellido + ", DNI : " + dni ;
	}

	public static boolean verificarDniInvalido(String dni) throws DniInvalido {
		if (!dni.matches("^[0-9]*$")){
			DniInvalido d = new DniInvalido();
			throw d;
		}
		return true;
	}
	
}