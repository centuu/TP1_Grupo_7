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
	public ArrayList<Curso> list(int start, int total) 
	{
		return dao.list(start, total);
	}
	
	public ArrayList<Curso> list() 
	{
		return dao.list();
	}

	@Override
	public ArrayList<Curso> listar_X_Docente(int legajo, int start, int total) {
		// TODO Auto-generated method stub
		return dao.listar_X_Docente(legajo, start, total);
	}

	public int cantRegistros()
	{
		return dao.cantRegistros();
	}
	public int cantRegistros(int legajo)
	{
		return dao.cantRegistros(legajo);
	}
}
