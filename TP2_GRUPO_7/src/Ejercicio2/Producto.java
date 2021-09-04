package Ejercicio2;

public class Producto {

	private String nLote;
	private String Fecha;

	public Producto(){
		
		this.setnLote("0000");
		this.setFecha("01/01/2000");
	
	}
	
	public Producto(String lote, String Fecha){
		
		this.nLote = lote;
		this.Fecha = Fecha;
	
	}
	

	public String getnLote() {
		return nLote;
	}

	public void setnLote(String nLote) {
		this.nLote = nLote;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	@Override
	public String toString() {
		return "Producto - Numero de Lote= " + nLote + ", Fecha de Vencimiento= " + Fecha;
	}
	
}