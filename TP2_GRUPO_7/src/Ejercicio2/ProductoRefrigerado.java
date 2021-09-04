package Ejercicio2;

public class ProductoRefrigerado extends Producto {

	private String CodSA;
	
	public ProductoRefrigerado()
	{
		super();
		this.setCodSA("00");
	}
	
	public ProductoRefrigerado(String lote,String Fecha,String Cod)
	{
		super(lote,Fecha);
		this.setCodSA(Cod);
	}

	public String getCodSA() 
	{
		return CodSA;
	}

	private void setCodSA(String codSA) 
	{
		CodSA = codSA;
	}

	@Override
	public String toString() 
	{
		return "Producto Refrigerado -- Codigo Organismo Supervision Alimentaria =" + this.getCodSA() + ", Fecha de Vencimiento = " + this.getFecha() + ", Lote= " + this.getnLote();
	}
	
	
	
}
