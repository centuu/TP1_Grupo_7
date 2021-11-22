package negosio;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoNegosio {
	
	public boolean insertar(Alumno alum);
	public ArrayList<Alumno> listar();
	public int editar(Alumno alum);
	public String GetNextLegajo();
	public boolean eliminar(int legajo);
	public Alumno buscarAlumno(int id);

}
