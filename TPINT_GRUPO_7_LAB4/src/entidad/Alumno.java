package entidad;

public class Alumno 
{
	protected int legajo;
	protected String dni;
	protected String Nombre ;
	protected String Apellido;
	protected String FechaNac;
	protected String Provincia;
	protected String direccion ;	
    protected String nacionalidad;
    protected String mail;
    protected String telefono ;
    protected boolean estado;
    
    public Alumno() 
    {
		super();
		
	}
    
	public Alumno(String dni,String nombre, String apellido,String fechaNac, String provincia, String direccion, String nacionalidad, String mail, String telefono) 
	{
		this.dni = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaNac = fechaNac;
		this.Provincia = provincia;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.mail = mail;
		this.telefono = telefono;
		this.estado = true;
	}
	
	public String getFechaNac()
	{
		return FechaNac;
	}
	
	public void setFechaNac(String fechaNac)
	{
		FechaNac = fechaNac;
	}
    
	public int getLegajo() 
	{
		return legajo;
	}
	
	public String getDni() 
	{
		return dni;
	}
	
	public void setDni(String dni) 
	{
		this.dni = dni;
	}
	
	public String getNombre() 
	{
		return Nombre;
	}
	
	public void setNombre(String nombre) 
	{
		Nombre = nombre;
	}
	
	public String getApellido() 
	{
		return Apellido;
	}
	
	public void setApellido(String apellido) 
	{
		Apellido = apellido;
	}
	
	public String getDireccion() 
	{
		return direccion;
	}
	
	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}
	
	public String getProvincia() 
	{
		return Provincia;
	}
	
	public void setProvincia(String prov) 
	{
		this.Provincia = prov;
	}
	
	public String getNacionalidad() 
	{
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) 
	{
		this.nacionalidad = nacionalidad;
		
	}
	
	public String getMail() 
	{
		return mail;
	}
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}
	
	public String getTelefono() 
	{
		return telefono;
	}
	
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public boolean getestado()
	{
		return estado;
	}
	
	public void setestado(boolean estado)
	{
		this.estado=estado;
	}
}
