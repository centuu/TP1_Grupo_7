package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.CursadaDao;
import entidad.Alumno;
import entidad.Curso;

public class CursadaDaoImpl implements CursadaDao{

	private static final String listar = "SELECT * FROM cursada INNER JOIN alumnos on Alumnos.legajo =cursada.legajoAlumno inner join cursos on cursada.idCurso= cursos.idCurso where cursos.idcurso=";
	private static final String edit = "UPDATE cursada SET nota_pri = ?, nota_seg = ?, rec_pri = ?, rec_seg = ?, condicion = ? WHERE legajoAlumno = ? AND idCurso = ?";

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
   		
				alu.setIdCurso(rs.getInt("idCurso"));
				alu.setNota_pri(rs.getFloat("nota_pri"));
				alu.setNota_seg(rs.getFloat("nota_seg"));
				alu.setRec_pri(rs.getFloat("rec_pri"));
				alu.setRec_seg(rs.getFloat("rec_seg"));
				alu.setCondicion(rs.getString("condicion"));
				
        		listaAlumno.add(alu);
        	}	
        }
        catch(Exception  e)
        {
        	return listaAlumno;
        }
        
		return listaAlumno;
	}
	
	public boolean update(int idCurso, ArrayList <Alumno> listacursada)
	{
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement st;
		
		try
		{
			for(Alumno alumno : listacursada)
			{
				st = conexion.prepareStatement(edit);
				
				st.setFloat(1, alumno.getNota_pri());
				st.setFloat(2, alumno.getNota_seg());
				st.setFloat(3, alumno.getRec_pri());
				st.setFloat(4, alumno.getRec_seg());
				st.setString(5, alumno.getCondicion());
				st.setInt(6, alumno.getLegajo());
				st.setInt(7, idCurso);				
				
				if (st.executeUpdate() > 0) 
				{
					conexion.commit();
				}
				
				
			}
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

}
