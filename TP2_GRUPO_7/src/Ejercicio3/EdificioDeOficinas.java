package Ejercicio3;

public class EdificioDeOficinas extends Edificio{
	private int cantidadOficinas;
	
	public EdificioDeOficinas()
	{
		this.setCantidadOficinas(10);
		this.setNombre("sin nombre");
	}
	
	public EdificioDeOficinas(int cantidadOficinas, String nombre)
	{
		this.setCantidadOficinas(cantidadOficinas);
		this.setNombre(nombre);
	}

	public int getCantidadOficinas() {
		return cantidadOficinas;
	}

	public void setCantidadOficinas(int cantidadOficinas) {
		this.cantidadOficinas = cantidadOficinas;
	}


	@Override
	public double getSuperficieEdificio() {
		return this.getSuperficie();
	}
	
	@Override
	public String toString() {
		return "EdificioDeOficinas [cantidadOficinas=" + cantidadOficinas + ", getNombre()=" + getNombre() + "]";
	}
	
}
