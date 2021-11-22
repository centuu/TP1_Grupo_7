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
	public boolean update(int legajo) 
	{
		return dao.update(legajo);
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
}
