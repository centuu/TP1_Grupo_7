package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import dao.AlumnoDao;
import entidad.Alumno;

public class AlumnoImpl implements AlumnoDao 
{
	private static final String insert = "INSERT INTO Alumnos (dni,nombre,apellido,domicilio,provincia,idnacionalidad,email,telefono) VALUES(?,?,?,?,?,?,?,?)";
	private static final String delete = "DELETE FROM Alumnos WHERE legajo = ?";
	private static final String list =   "SELECT * FROM Alumnos";
		
	public boolean insert(Alumno alum) 
	{
		int res=-1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try
		{
			state = conexion.prepareStatement(insert);
			state.setInt(1, alum.getDni());
			state.setString(2,alum.getNombre());
			state.setString(3,alum.getApellido());
			state.setString(4,alum.getDireccion());
		    state.setString(5,alum.getProvincia());
			state.setInt(6,alum.getNacionalidad().getId());
			state.setString(7,alum.getMail());
			state.setInt(8,alum.getTelefono());

			res=state.executeUpdate();
			
			if (res>0)
			{
				conexion.commit();
			}	
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException ex) 
			{
				ex.printStackTrace();
				return false;
			}
			return false;
		}
		
		return res>0 ;
	}

	@Override
	public ArrayList<Alumno> list() 
	{
		PreparedStatement state;
		ArrayList<Alumno> listaAlum= new ArrayList<Alumno>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
        ResultSet rs=null;
        
        try
        {
        	state = conexion.prepareStatement(list);
        	rs = state.executeQuery();
        	while(rs.next())
        	{
        		Alumno alu=new Alumno();
        		alu.setLegajo(rs.getString("Legajo"));
        		alu.setDni(rs.getInt("dni"));
        		alu.setNombre(rs.getString("nombre"));
        		alu.setApellido(rs.getString("apellido"));
        		alu.setDireccion(rs.getString("domicilio"));
        		alu.setProvincia(rs.getString("provincia"));
        		alu.setNacionalidad(rs.getInt("idnacionalidad"));
        		alu.setMail(rs.getString("email"));
        		alu.setTelefono(rs.getInt("telefono"));
        		alu.setestado(rs.getBoolean("estado"));
        		listaAlum.add(alu);
        	}
        }
        catch(Exception  e)
        {
        	return listaAlum;
        }
        
		return null;
	}

	@Override
	public boolean update(int legajo) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int legajo) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
