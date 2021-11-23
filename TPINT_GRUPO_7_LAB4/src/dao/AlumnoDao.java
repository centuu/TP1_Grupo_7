package dao;
import java.util.ArrayList;
import entidad.Alumno;

public interface AlumnoDao 
{
	public boolean insert(Alumno alum);
	public ArrayList<Alumno> list();
	public int update(Alumno alumno);
	public boolean delete(int legajo);
	public String GetNextLegajo();
	public Alumno buscarAlumno(int legajo);
}
