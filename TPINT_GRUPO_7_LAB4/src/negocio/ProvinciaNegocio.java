package negocio;

import java.util.ArrayList;

import dao.ProvinciaDao;
import daoImpl.ProvinciaDaoImpl;
import entidad.Provincia;

public class ProvinciaNegocio implements ProvinciaDao 
{
	ProvinciaDaoImpl dao = new ProvinciaDaoImpl();
	
	@Override
	public ArrayList<Provincia> list() 
	{
		return dao.list();
	}

}
