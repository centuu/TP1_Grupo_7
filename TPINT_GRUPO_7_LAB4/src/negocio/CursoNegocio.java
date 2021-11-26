package negocio;

import java.util.ArrayList;

import dao.CursoDao;
import daoImpl.CursoImpl;
import entidad.Curso;

public class CursoNegocio implements CursoDao 
{
	CursoImpl dao = new CursoImpl();

	@Override
	public boolean insert(Curso curso) 
	{
		return dao.insert(curso);
	}

	@Override
	public ArrayList<Curso> list() 
	{
		return dao.list();
	}

}
