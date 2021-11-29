package negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DocenteDao;
import daoImpl.DocenteImpl;
import entidad.Alumno;
import entidad.Docente;

public class DocenteNegocio implements DocenteDao 
{
	DocenteImpl dao = new DocenteImpl();

	@Override
	public boolean insert(Docente docente) throws SQLException 
	{
		return dao.insert(docente);
	}
	
	public int update(Docente doc) 
	{
		return dao.update(doc);
	}

	@Override
	public ArrayList<Docente> list() 
	{
		return dao.list();
	}
	
	public int cantRegistros()
	{
		return dao.cantRegistros();
	}
	
	public ArrayList<Docente> list(int start, int total) 
	{
		return dao.list(start, total);
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
	
	
	public Docente buscarDocente(int legajo) 
	{
		return dao.buscarDocente(legajo);
	}
}
