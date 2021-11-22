package negosioImpl;
import java.util.ArrayList;

import daoImpl.AlumnoImpl;
import entidad.Alumno;
import negosio.AlumnoNegosio;

public class AlumnoNegosioImpl implements AlumnoNegosio {
	
 AlumnoImpl alumDao= new AlumnoImpl();
	@Override
	public boolean insertar(Alumno alum) {
		
		return alumDao.insert(alum);
	}

	@Override
	public ArrayList<Alumno> listar() {
		// TODO Auto-generated method stub
		return alumDao.list();
	}

	@Override
	public int editar(Alumno alum) {
		
		return alumDao.update(alum);
	}
	
	public String GetNextLegajo()
	{
	   return alumDao.GetNextLegajo();
	}

	@Override
	public boolean eliminar(int legajo) {
	
		return alumDao.delete(legajo);
	}

	@Override
	public Alumno buscarAlumno(int id) {

		return (Alumno)alumDao.buscarAlumno(id);
	}

}
