package negosioImpl;

import java.util.ArrayList;

import daoImpl.NacionalidadDaoImpl;
import daoImpl.ProvinciaDaoImpl;
import entidad.Nacionalidad;
import entidad.Provincia;
import negosio.NacionalidadNegosio;

public class NacionalidadNegosioImpl implements NacionalidadNegosio {

	 ProvinciaDaoImpl proviDao= new ProvinciaDaoImpl();
	 NacionalidadDaoImpl nacionDao =new  NacionalidadDaoImpl ();
	 
	 
	public ArrayList <Nacionalidad> listNacion()
	{
	  return nacionDao.list();
	}

	public ArrayList<Provincia> listProvincia() {

		return proviDao.list();
	}

}
