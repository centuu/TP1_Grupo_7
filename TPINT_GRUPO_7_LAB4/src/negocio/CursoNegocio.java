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

	@Override
	public ArrayList<Curso> listar_X_Docente(int legajo) {
		// TODO Auto-generated method stub
		return dao.listar_X_Docente(legajo);
	}

}
