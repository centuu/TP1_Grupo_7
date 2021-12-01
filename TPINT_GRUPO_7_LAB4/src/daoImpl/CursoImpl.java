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
import entidad.Profesor;

import java.sql.ResultSet;

public class CursoImpl implements CursoDao
{
	private static final String list =   "SELECT * FROM Cursos INNER JOIN materias ON materias.idMateria = cursos.idMateria INNER JOIN docentes ON docentes.legajo = cursos.idDocente";
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
				CallableStatement st = conexion.prepareCall("{CALL insert_Cursada(?, ?)}");
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

	@Override
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

	@Override
	public ArrayList<Curso> listar_X_Docente(int legajo) 
	{
		PreparedStatement state;
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	state = conexion.prepareStatement(listar + legajo);
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
