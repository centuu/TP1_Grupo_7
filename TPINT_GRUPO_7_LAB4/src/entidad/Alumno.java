package entidad;

public class Alumno 
{
	protected int legajo;
	protected String dni;
	protected String Nombre ;
	protected String Apellido;
	protected String FechaNac;
	protected Provincia Provincia;
	protected String direccion ;	
    protected Nacionalidad nacionalidad;
    protected String mail;
    protected String telefono ;
    protected boolean estado;
    
    public Alumno() 
    {
		super();
		
	}
    
	public Alumno(String dni,String nombre, String apellido,String fechaNac, Provincia provincia, String direccion, Nacionalidad nacionalidad, String mail, String telefono) 
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
	
	public void setNroLegajo(int legajo) 
	{
		this.legajo = legajo;
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
	
	public Provincia getProvincia() 
	{
		return Provincia;
	}
	
	public void setProvincia(Provincia prov) 
	{
		this.Provincia = prov;
	}
	
	public Nacionalidad getNacionalidad() 
	{
		return nacionalidad;
	}
	
	public void setNacionalidad(Nacionalidad nacionalidad) 
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
