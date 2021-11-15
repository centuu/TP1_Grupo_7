package dao;
import java.util.ArrayList;
import entidad.Alumno;

public interface AlumnoDao 
{
	public boolean insert(Alumno alum);
	public ArrayList<Alumno> list();
	public boolean update(int legajo);
	public boolean delete(int legajo);
}
