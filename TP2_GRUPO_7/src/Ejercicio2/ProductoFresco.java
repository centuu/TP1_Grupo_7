package Ejercicio2;

public class ProductoFresco extends Producto {
	
	private String FechaEnvasado;
	private String Pais;	
	
	public ProductoFresco()
	{
		super();
		this.FechaEnvasado = "01/01/2000";
		this.Pais = "None";
	}
	
	public ProductoFresco(String lote, String Fecha, String FechaEnv, String Pais)
	{
		super(lote,Fecha);
		this.FechaEnvasado = FechaEnv;
		this.Pais = Pais;
	}
	
	public String getFechaEnvasado() {
		return FechaEnvasado;
	}
	public void setFechaEnvasado(String fechaEnvasado) {
		FechaEnvasado = fechaEnvasado;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}

	@Override
	public String toString() {
		return "Producto Fresco - Fecha de Envasado= " + this.getFechaEnvasado() + ", Pais= " + this.getPais() + ", Fecha de Vencimiento = " + this.getFecha() + ", Lote= " + this.getnLote();
	}
}