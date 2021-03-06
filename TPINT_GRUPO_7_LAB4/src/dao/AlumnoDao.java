package dao;
import java.sql.SQLException;
import java.util.ArrayList;

import daoImpl.AlumnoImpl;
import entidad.Alumno;

public interface AlumnoDao 
{
	public boolean insert(Alumno alum) throws SQLException;
	public ArrayList<Alumno> list();
	public ArrayList<Alumno> list(int start, int total, String filter);
	public int update(Alumno alumno);
	public boolean delete(int legajo);
	public String GetNextLegajo();
	public Alumno buscarAlumno(int legajo);
}
