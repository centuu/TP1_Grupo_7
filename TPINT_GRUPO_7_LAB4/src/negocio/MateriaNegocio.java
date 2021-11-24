package negocio;

import java.util.ArrayList;

import dao.MateriaDao;
import daoImpl.MateriaImpl;
import entidad.Materia;

public class MateriaNegocio implements MateriaDao
{
	MateriaImpl dao = new MateriaImpl();
	
	@Override
	public ArrayList<Materia> list() 
	{
		return dao.list();
	}

}
