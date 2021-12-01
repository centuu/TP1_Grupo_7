package negocio;

import java.util.ArrayList;

import dao.CursadaDao;
import daoImpl.CursadaDaoImpl;
import entidad.Alumno;

public class CursadaNegosio implements CursadaDao {

	CursadaDaoImpl dao=new CursadaDaoImpl();
	
	public ArrayList<Alumno> Alumnos_X_Docente(int id) {
		// TODO Auto-generated method stub
		return dao.Alumnos_X_Docente(id);
	}

}
