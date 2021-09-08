package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		try
		{
			Persona.verificarDniInvalido("1234");
		}
		catch (DniInvalido d)
		{
			d.getMessage();
			d.printStackTrace();
		}
		
		Archivo ar =new Archivo();
		ar.leer_Archivo();
		ar.Mostrar_Personas();

	}
}
