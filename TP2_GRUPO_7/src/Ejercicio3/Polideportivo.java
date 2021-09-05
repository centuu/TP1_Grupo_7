package Ejercicio3;

public class Polideportivo extends Edificio implements IInstalacionDeportiva{
	
	private double largo;
	private double ancho;
	
	
	public Polideportivo()
	{
		this.setLargo(0);
		this.setAncho(0);
		this.setNombre("sin nombre");
		this.setSuperficie(this.ancho, this.largo);
	}
	
	public Polideportivo(double largo, double ancho, String nombre)
	{
		this.setLargo(largo);
		this.setAncho(ancho);
		this.setNombre(nombre);
		this.setSuperficie(this.ancho, this.largo);
	}
	
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	
	
	@Override
	public int getTipoDeInstalacion() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getSuperficieEdificio() {
		return this.getSuperficie();
	}

	@Override
	public String toString() {
		return "Polideportivo [largo=" + largo + ", ancho=" + ancho + ", getTipoDeInstalacion()=" + getTipoDeInstalacion() + ", getSuperficieEdificio()="
				+ getSuperficieEdificio() + ", getNombre()=" + getNombre() + "]";
	}
	
	

}
