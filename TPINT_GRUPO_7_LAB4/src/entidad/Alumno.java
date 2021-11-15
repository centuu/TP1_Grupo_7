package entidad;

public class Alumno 
{
	protected String legajo;
	protected int dni ;
	protected String Nombre ;
	protected String Apellido;
	protected String Provincia;
	protected String direccion ;	
    protected Nacionalidad nacionalidad;
    protected String mail;
    protected int telefono ;
    protected boolean estado;
    
    
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String prov) {
		this.Provincia = prov;
	}
	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(int nacionalidad) {
		 this.nacionalidad=new Nacionalidad();
		 
		this.nacionalidad.id = nacionalidad;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public boolean getestado() {
		return estado;
	}
	
	public void setestado(boolean estado)
	{
		this.estado=estado;
	}
}
