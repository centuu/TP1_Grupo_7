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
	
	@Override
	public ArrayList<Alumno> list() 
	{
		return dao.list();
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
}
