package negocio;

import java.util.ArrayList;

import dao.DocenteDao;
import daoImpl.DocenteImpl;
import entidad.Docente;

public class DocenteNegocio implements DocenteDao 
{
	DocenteImpl dao = new DocenteImpl();

	@Override
	public boolean insert(Docente docente) 
	{
		return dao.insert(docente);
	}

	@Override
	public ArrayList<Docente> list() 
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
