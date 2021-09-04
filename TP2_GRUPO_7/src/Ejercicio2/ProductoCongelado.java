package Ejercicio2;

public class ProductoCongelado extends Producto {
	
	private int Temp;

	public ProductoCongelado()
	{
		super();
		this.Temp = 99;
	}
	
	public ProductoCongelado(String lote,String Fecha,int temp)
	{
		super(lote,Fecha);
		this.Temp = temp;
	}
	
	public int getTemp() {
		return Temp;
	}

	public void setTemp(int temp) {
		Temp = temp;
	}

	@Override
	public String toString() {
		return "Producto Congelado -- Mantener a= " + this.getTemp() + ", Fecha de Vencimiento = " + this.getFecha() + ", Lote= " + this.getnLote();
	}
	
}
