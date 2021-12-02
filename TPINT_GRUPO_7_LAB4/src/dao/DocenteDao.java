package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Docente;

public interface DocenteDao 
{
	public boolean insert(Docente docente)throws SQLException;
	public ArrayList<Docente> list();
	public ArrayList<Docente> list(int start, int total, String filter);
	public boolean update(int legajo);
	public boolean delete(int legajo);
	public String GetNextLegajo();
}
