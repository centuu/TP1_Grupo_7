package entidad;

public class TipoSeguro 
{
	private short idtipo;
	private String descripcion;
	
	public TipoSeguro() 
	{
		
	}
	
    public TipoSeguro(short id,String des) 
    {
    	this.idtipo=id;
    	this.descripcion=des;
		
	}
    
	public int getIdtipo() 
	{
		return idtipo;
	}
	
	public void setIdtipo(short idtipo) 
	{
		this.idtipo = idtipo;
	}
	
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	} 
}
