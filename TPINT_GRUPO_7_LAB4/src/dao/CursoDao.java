package dao;
import java.util.ArrayList;

import entidad.Curso;

public interface CursoDao 
{
	public boolean insert(Curso alum);
	public ArrayList<Curso> list();
	public ArrayList<Curso>listar_X_Docente(int legajo);

}

