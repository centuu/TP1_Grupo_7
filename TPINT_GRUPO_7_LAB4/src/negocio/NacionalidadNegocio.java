package negocio;

import java.util.ArrayList;

import dao.NacionalidadDao;
import daoImpl.NacionalidadDaoImpl;
import entidad.Nacionalidad;

public class NacionalidadNegocio implements NacionalidadDao
{
	NacionalidadDaoImpl dao = new NacionalidadDaoImpl();
	
	@Override
	public ArrayList<Nacionalidad> list() 
	{
		return dao.list();
	}
}
