package entidad;

public class Usuario {
	private String NomUsuario;
	private String Pass;
	private int tipo;
	private String dni;
	private String nombre;
	private String apellido;

	public Usuario()
	{
		
	}	
			
	public Usuario(String dni, String nombre, String apellido)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getDni() 
	{
		return this.dni;
	}

	public void setDni(String dni) 
	{
		this.dni = dni;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return this.apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return  "  Dni: "+dni+ ", Nombre: "+ nombre +", Apellido: "+ apellido;
	}
	

}
