package entidad;

import java.util.List;

public class Curso 
{
	private int idCurso;
	private int materia;
	private int idProfesor;
	private List<Alumno> listAlu;
	private String semestre;
	private int anio;
	private String descripcion;
	
	public Curso()
	{
		super();
	}
	
	public Curso(int materia, String semestre, String anio, int idProfesor, List<Alumno> listAlu) 
	{
		this.materia = materia;
		this.idProfesor = idProfesor;
		this.listAlu = listAlu;
	}

	public int getIdCurso() 
	{
		return idCurso;
	}

	public void setIdCurso(int curso) 
	{
		this.idCurso = curso;
	}

	public int getIdMateria() 
	{
		return this.materia;
	}
	
	/*public String getdesMateria()
	{
		return materia.getDescripcion();
	}*/
	
	public void setIdMateria(int materia) 
	{
		
		this.materia = materia;
	}
	
	public int getIdProfesor() 
	{
		return this.idProfesor;
	}
	
	public void setProfesor(int profesor) 
	{
		this.idProfesor = profesor;
	}
	
	public List<Alumno> getListAlu() 
	{
		return listAlu;
	}
	
	public void setListAlu(List<Alumno> listAlu) 
	{
		this.listAlu = listAlu;
	}
	
	public void setDescripcion(String desc)
	{
		this.descripcion = desc;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public String getSemestre()
	{
		return this.semestre;
	}
	
	public void setSemestre(String semestre)
	{
		this.semestre = semestre;
	}
	
	public int getAnio()
	{
		return this.anio;
	}
	
	public void setAnio(int anio)
	{
		this.anio = anio;
	}
	
}
