package Ejercicio1;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	
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
	
	public static boolean verificarDniInvalido(String dni) throws DniInvalido {
		if (!dni.matches("^[0-9]*$")){
			DniInvalido d = new DniInvalido();
			throw d;
		}
		return true;
	}
}