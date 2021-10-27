package dao;

import java.util.ArrayList;
import java.util.List;

import entidad.Seguro;

public interface SeguroDao 
{
	public boolean insert(Seguro seguro);
	public boolean delete(Seguro eliminar);
	public ArrayList<Seguro>listarxTipo(String tipo);

}
