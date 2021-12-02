package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.CursoDao;
import entidad.Alumno;
import entidad.Curso;
import entidad.Materia;
import entidad.Nacionalidad;
import entidad.Profesor;
import entidad.Provincia;

import java.sql.ResultSet;

public class CursoImpl implements CursoDao
{
	private static final String list =   "SELECT * FROM Cursos INNER JOIN materias ON materias.idMateria = cursos.idMateria INNER JOIN docentes ON docentes.legajo = cursos.idDocente";
	private static final String buscar = "SELECT * FROM Cursos INNER JOIN materias ON materias.idMateria = cursos.idMateria INNER JOIN docentes ON docentes.legajo = cursos.idDocente WHERE cursos.idCurso = ";
	private static final String listar = "SELECT * FROM Cursos INNER JOIN materias ON materias.idMateria = cursos.idMateria INNER JOIN docentes ON docentes.legajo = cursos.idDocente where docentes.legajo =";

	public boolean insert(Curso curso) 
	{
		boolean res = false;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			PreparedStatement state = conexion.prepareStatement("INSERT INTO cursos (idMateria, idDocente, semestre, anio) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			state.setInt(1, curso.getIdMateria());
			state.setInt(2, curso.getIdProfesor());
			state.setString(3, curso.getSemestre());
			state.setInt(4, curso.getAnio());

			if (state.executeUpdate() > 0) 
			{
				conexion.commit();
			}
			
			ResultSet rs = state.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			
			for(Alumno alumno : curso.getListAlu())
			{
				CallableStatement st = conexion.prepareCall("{CALL insert_Cursada(?,?)}");
				st.setInt(1, id);
				st.setInt(2, alumno.getLegajo());
				
				if (st.executeUpdate() > 0) 
				{
					conexion.commit();
				}
			}
			res = true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return res;
	}
	
	public ArrayList<Curso> list(int start, int total) 
	{
		PreparedStatement state;
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	
        	if (start > 1) {
        		state = conexion.prepareStatement(list + " LIMIT " + ((start-1)*total) + ", " + total);
        	}
        	else {
        		state = conexion.prepareStatement(list + " LIMIT " + (start-1) + ", " + total);
        	}
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Curso curso = new Curso();
        		curso.setIdCurso(rs.getInt("idCurso"));
        		
        		Materia materia = new Materia();
        		materia.setId(rs.getInt("idMateria"));
        		materia.setDescripcion(rs.getString("descripcion"));
        		
        		curso.setIdMateria(materia.getId());
        		curso.setDescripcion(materia.getDescripcion());
        		curso.setSemestre(rs.getString("semestre"));
        		curso.setAnio(rs.getInt("anio"));
        		
        		Profesor profesor = new Profesor();
        		profesor.setLegajo(rs.getString("legajo"));
        		profesor.setNombre(rs.getString("nombre"));
        		curso.setProfesor(profesor.getDni());
        		
        		listaCursos.add(curso);
        	}	
        }
        catch(Exception  e)
        {
        	return listaCursos;
        }
        
		return listaCursos;
	}
	
	public ArrayList<Curso> list() 
	{
		PreparedStatement state;
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	
        	state = conexion.prepareStatement(list);
        	
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Curso curso = new Curso();
        		curso.setIdCurso(rs.getInt("idCurso"));
        		
        		Materia materia = new Materia();
        		materia.setId(rs.getInt("idMateria"));
        		materia.setDescripcion(rs.getString("descripcion"));
        		
        		curso.setIdMateria(materia.getId());
        		curso.setDescripcion(materia.getDescripcion());
        		curso.setSemestre(rs.getString("semestre"));
        		curso.setAnio(rs.getInt("anio"));
        		
        		Profesor profesor = new Profesor();
        		profesor.setLegajo(rs.getString("legajo"));
        		profesor.setNombre(rs.getString("nombre"));
        		curso.setProfesor(profesor.getDni());
        		
        		listaCursos.add(curso);
        	}	
        }
        catch(Exception  e)
        {
        	return listaCursos;
        }
        
		return listaCursos;
	}
	
	public int cantRegistros() 
	{
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			PreparedStatement state = conexion.prepareStatement("SELECT COUNT(*) FROM Cursos INNER JOIN materias ON materias.idMateria = cursos.idMateria INNER JOIN docentes ON docentes.legajo = cursos.idDocente");
			
			ResultSet rs = state.executeQuery();
			
			while(rs.next()){
				return rs.getInt(1);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return -1;
	}
	
	public int cantRegistros(int legajo) 
	{
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			PreparedStatement state = conexion.prepareStatement("SELECT COUNT(*) FROM Cursos INNER JOIN materias ON materias.idMateria = cursos.idMateria INNER JOIN docentes ON docentes.legajo = cursos.idDocente where docentes.legajo = " + legajo);
			
			ResultSet rs = state.executeQuery();
			
			while(rs.next()){
				return rs.getInt(1);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public ArrayList<Curso> listar_X_Docente(int legajo, int start, int total) 
	{
		PreparedStatement state;
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	if (start > 1) {
        		state = conexion.prepareStatement(listar + legajo + " LIMIT " + ((start-1)*total) + ", " + total);
        	}
        	else {
        		state = conexion.prepareStatement(listar + legajo + " LIMIT " + (start-1) + ", " + total);
        	}
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Curso curso = new Curso();
        		curso.setIdCurso(rs.getInt("idCurso"));
        		
        		Materia materia = new Materia();
        		materia.setId(rs.getInt("idMateria"));
        		materia.setDescripcion(rs.getString("descripcion"));
        		
        		curso.setIdMateria(materia.getId());
        		curso.setDescripcion(materia.getDescripcion());
        		curso.setSemestre(rs.getString("semestre"));
        		curso.setAnio(rs.getInt("anio"));
        		
        		Profesor profesor = new Profesor();
        		profesor.setLegajo(rs.getString("legajo"));
        		profesor.setNombre(rs.getString("nombre"));
        		curso.setProfesor(profesor.getDni());
        		
        		listaCursos.add(curso);
        	}	
        }
        catch(Exception  e)
        {
        	return listaCursos;
        }
        
		return listaCursos;
	}
	
}
