package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CursoDao;
import entidad.Curso;
import entidad.Materia;
import entidad.Profesor;

import java.sql.ResultSet;

public class CursoImpl implements CursoDao
{
	private static final String insert = "INSERT INTO Cursos (idCurso, idMateria, semestre, ciclo, idDocente) VALUES (?,?,?,?,?)";
	private static final String list = "SELECT * FROM Cursos INNER JOIN materias ON materias.idMateria = cursos.idMateria INNER JOIN docentes ON docentes.legajo = cursos.idDocente";

	public boolean insert(Curso curso) 
	{
		int res = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try 
		{
			state = conexion.prepareStatement(insert);
			state.setString(1, curso.getIdCurso());
			state.setInt(2, curso.getIdMateria());
			state.setString(3, curso.getSemestre());
			state.setString(4, curso.getAnio());
			state.setInt(5, Integer.parseInt(curso.getIdProfesor()));
			
			res = state.executeUpdate();

			if (res > 0) 
			{
				conexion.commit();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return res > 0;
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
        		curso.setIdCurso(rs.getString("idCurso"));
        		Materia materia = new Materia();
        		materia.setId(rs.getInt("idMateria"));
        		materia.setDescripcion(rs.getString("descripcion"));
        		curso.setIdMateria(materia);
        		curso.setSemestre(rs.getString("semestre"));
        		curso.setAnio(rs.getString("ciclo"));
        		Profesor profesor = new Profesor();
        		profesor.setLegajo(rs.getString("legajo"));
        		profesor.setNombre(rs.getString("nombre"));
        		curso.setProfesor(profesor);
        		
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
