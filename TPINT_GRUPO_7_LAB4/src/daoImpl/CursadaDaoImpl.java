package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.CursadaDao;
import entidad.Alumno;

public class CursadaDaoImpl implements CursadaDao{

	private static final String listar = "select *from cursada inner join alumnos on Alumnos.legajo =cursada.legajoAlumno inner join cursos on cursada.idCurso= cursos.idCurso where cursos.idcurso=";

	@Override
	public ArrayList<Alumno> Alumnos_X_Docente(int id) {
		PreparedStatement state;
		ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	state = conexion.prepareStatement(listar + id);
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{      
                
                Alumno alu = new Alumno();
				alu.setDni(rs.getString("dni"));
				alu.setNroLegajo(rs.getInt("legajo"));
				alu.setFechaNac(rs.getString("fechaNacimiento"));
				alu.setNombre(rs.getString("nombre"));
				alu.setApellido(rs.getString("apellido"));
				alu.setDireccion(rs.getString("domicilio"));
				alu.setMail(rs.getString("email"));
				alu.setTelefono(rs.getString("telefono"));
   		
        		listaAlumno.add(alu);
        	}	
        }
        catch(Exception  e)
        {
        	return listaAlumno;
        }
        
		return listaAlumno;
	}

}
