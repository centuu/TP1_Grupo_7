package dao;
import java.util.ArrayList;
import entidad.Alumno;

public interface AlumnoDao 
{
	public boolean insert(Alumno alum);
	public ArrayList<Alumno> list();
	public int update(Alumno alum);
	public String GetNextLegajo();
	public boolean delete(int legajo);
	public Alumno buscarAlumno(int id);
}
