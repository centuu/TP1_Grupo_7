package entidad;

public class Nacionalidad 
{
	protected int id;
	protected String nombre;	
	
	public Nacionalidad() 
    {
		super();
    }

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}	
}
