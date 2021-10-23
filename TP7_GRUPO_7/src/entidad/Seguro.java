package entidad;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Seguro 
{	
	private int idSeguro;
	private String Descripcion;
	private int Tipo;
	private int 	CostoContratacion;
	private int CostoMaximo;
	
	public Seguro()
	{
		
	}
	public Seguro(int tipo,String des,int contratacion,int maximo) 
	{
		super();

		this.Tipo = tipo;
		this.Descripcion = des;		
		this.CostoContratacion = contratacion;
		this.CostoMaximo = maximo;
		
	}
	
	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}

	public int getCostoContratacion() {
		return CostoContratacion;
	}

	public void setCostoContratacion(int costoContratacion) {
		CostoContratacion = costoContratacion;
	}

	public int getCostoMaximo() {
		return CostoMaximo;
	}

	public void setCostoMaximo(int costoMaximo) {
		CostoMaximo = costoMaximo;
	}

	@Override
	public String toString() {
		return "id  =  " + idSeguro + ", Descripcion = " + Descripcion + ", Tipo= " + Tipo
				+ ", CostoContratacion=" + CostoContratacion + ", CostoMaximo=" + CostoMaximo + "]";
	}

}
