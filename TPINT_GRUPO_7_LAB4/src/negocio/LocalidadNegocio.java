package negocio;

import java.util.ArrayList;

import dao.LocalidadDao;
import daoImpl.LocalidadDaoImpl;
import entidad.Localidad;

public class LocalidadNegocio implements LocalidadDao
{
	LocalidadDaoImpl dao = new LocalidadDaoImpl();
	
	@Override
	public ArrayList<Localidad> list() 
	{
		return dao.list();
	}
}
