package entidad;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import daoImpl.SeguroImpl;

public class Seguro 
{	
	private int idSeguro;
	private String Descripcion;
	private int idTipo;
	private BigDecimal	CostoContratacion;
	private BigDecimal costoAsegurado;
	
	public Seguro()
	{
		
	}
	
	public Seguro(int ID,int tipo,String des,BigDecimal contratacion,BigDecimal maximo) 
	{
		super();
		
		this.idSeguro = ID;
		this.idTipo = tipo;
		this.Descripcion = des;		
		this.CostoContratacion = contratacion;
		this.costoAsegurado = maximo;
	}
	
	public int getIdSeguro() 
	{
		return idSeguro;
	}

	public void setIdSeguro(int id) 
	{
		SeguroImpl seguro = new SeguroImpl();
		//idSeguro = Integer.parseInt(seguro.GetNextId());
		this.idSeguro=id;
	}

	public String getDescripcion() 
	{
		return Descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		Descripcion = descripcion;
	}

	public int getTipo()
	{
		return idTipo;
	}

	public void setTipo(int tipo)
	{
		idTipo = tipo;
	}

	public BigDecimal getCostoContratacion() 
	{
		return CostoContratacion;
	}

	public void setCostoContratacion(BigDecimal costoContratacion) 
	{
		CostoContratacion = costoContratacion;
	}

	public BigDecimal getcostoAsegurado()
	{
		return costoAsegurado;
	}

	public void setcostoAsegurado(BigDecimal costoMaximo) 
	{
		costoAsegurado = costoMaximo;
	}

	@Override
	public String toString()
	{
		return "id  =  " + idSeguro + ", Descripcion = " + Descripcion + ", Tipo= " + idTipo + ", CostoContratacion=" + CostoContratacion + ", CostoMaximo=" + costoAsegurado + "]";
	}

}
