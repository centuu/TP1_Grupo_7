package Ejercicio2;

public class MainEjercicio2 {

	public static void main(String[] args) {
		
		Producto prodComun = new Producto("1995AFC","04/05/2022");
		ProductoFresco prodFresco = new ProductoFresco("1234ASD","10/12/2023","05/04/2021","ARG");
		ProductoRefrigerado prodRefrigerado = new ProductoRefrigerado("7894CCK","10/12/2021","74478789877");
		ProductoCongelado prodCongelado = new ProductoCongelado("4561HGF","12/12/2024",-5);
		
		System.out.println(prodComun.toString());
		System.out.println(prodFresco.toString());
		System.out.println(prodRefrigerado.toString());
		System.out.println(prodCongelado.toString());
		
	}
}
