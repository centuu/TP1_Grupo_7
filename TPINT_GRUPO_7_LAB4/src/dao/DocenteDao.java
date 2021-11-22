package dao;

import java.util.ArrayList;

import entidad.Docente;

public interface DocenteDao 
{
	public boolean insert(Docente docente);
	public ArrayList<Docente> list();
	public boolean update(int legajo);
	public boolean delete(int legajo);
	public String GetNextLegajo();
}
