package entidad;

public class Materia 
{
	private int id;
	private String descripcion;	
	private int anio;
	private int idCarrera;
	
	public Materia()
	{
		
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) 
	{
		this.idCarrera = idCarrera;
	}

	public int getAnio() 
	{
		return anio;
	}

	public void setAnio(int anio) 
	{
		this.anio = anio;
	}
	
}
