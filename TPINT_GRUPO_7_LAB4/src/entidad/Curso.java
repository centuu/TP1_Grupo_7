package entidad;

import java.util.List;

public class Curso 
{
	private String idCurso;
	private Materia materia;
	private Profesor profesor;
	private List<Alumno> listAlu;
	
	public Curso()
	{
		super();
	}
	
	public Curso(Materia materia, String semestre, String anio, Profesor profesor, List<Alumno> listAlu) 
	{
		this.materia = materia;
		this.profesor = profesor;
		this.listAlu = listAlu;
	}

	public String getIdCurso() 
	{
		return idCurso;
	}

	public void setIdCurso(String curso) 
	{
		this.idCurso = curso;
	}

	public int getIdMateria() 
	{
		return materia.getId();
	}
	
	public String getdesMateria()
	{
		return materia.getDescripcion();
	}
	
	public void setIdMateria(Materia materia) 
	{
		
		this.materia = materia;
	}
	
	public String getIdProfesor() 
	{
		return profesor.getLegajo();
	}
	
	public void setProfesor(Profesor profesor) 
	{
		this.profesor = profesor;
	}
	
	public List<Alumno> getListAlu() 
	{
		return listAlu;
	}
	public void setListAlu(List<Alumno> listAlu) 
	{
		this.listAlu = listAlu;
	}
	
	
}
