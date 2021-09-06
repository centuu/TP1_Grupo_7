package Ejercicio1;

public class Empleado {
	
	private final int id;
	private String nombre;
	private int edad;
	private static int contador = 999;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

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
		return "Empleado: " + nombre + ", Edad: " + edad + ", Legajo: " + id;
	}
}