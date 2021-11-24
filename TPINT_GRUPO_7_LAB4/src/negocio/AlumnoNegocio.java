package negocio;

import java.util.ArrayList;

import dao.AlumnoDao;
import daoImpl.AlumnoImpl;
import entidad.Alumno;

public class AlumnoNegocio implements AlumnoDao
{
	AlumnoImpl dao = new AlumnoImpl();
	
	@Override
	public boolean insert(Alumno alum) 
	{		
		return dao.insert(alum);
	}
	
	public int cantRegistros()
	{
		return dao.cantRegistros();
	}
	
	public ArrayList<Alumno> list(int start, int total) 
	{
		return dao.list(start, total);
	}

	@Override
	public int update(Alumno alumno) 
	{
		return dao.update(alumno);
	}

	@Override
	public boolean delete(int legajo) 
	{
		return dao.delete(legajo);
	}

	@Override
	public String GetNextLegajo() 
	{
		return dao.GetNextLegajo();
	}

	@Override
	public Alumno buscarAlumno(int legajo) 
	{
		return dao.buscarAlumno(legajo);
	}

	@Override
	public ArrayList<Alumno> list() {
		// TODO Auto-generated method stub
		return null;
	}
}
