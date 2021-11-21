package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import dao.AlumnoDao;
import entidad.Alumno;
import entidad.Nacionalidad;
import entidad.Provincia;

public class AlumnoImpl implements AlumnoDao 
{
	private static final String insert = "INSERT INTO Alumnos (dni,nombre,apellido,fechaNac,domicilio,idprovincia,idnacionalidad,email,telefono,estado) VALUES (?,?,?,?,?,?,?,?,?,true)";
	private static final String delete = "UPDATE Alumnos SET estado = 0 WHERE legajo = ?";
	private static final String list = "SELECT * FROM Alumnos left join nacionalidad on `Alumnos`.`idNacionalidad`=`nacionalidad`.`id`\r\n" + 
			"inner join provincia on `Alumnos`.`idProvincia`=`provincia`.`id` where estado=1";

	public boolean insert(Alumno alum) 
	{
		int res = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try {
			state = conexion.prepareStatement(insert);
			state.setString(1, alum.getDni());
			state.setString(2, alum.getNombre());
			state.setString(3, alum.getApellido());
			state.setString(4, alum.getFechaNac());
			state.setString(5, alum.getDireccion());
			
			state.setInt(6, alum.getProvincia().getId());
			state.setInt(7, alum.getNacionalidad().getId());
			
			state.setString(8, alum.getMail());
			state.setString(9, alum.getTelefono());
			
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
	
	public boolean delete(int id) 
	{
		int res = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try {
			
			state = conexion.prepareStatement(delete);
			state.setInt(1, id);
			
			res = state.executeUpdate();

			if (res > 0) 
			{
				conexion.commit();
				return true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<Alumno> list()
	{
		PreparedStatement state;
		ArrayList<Alumno> listaAlum = new ArrayList<Alumno>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	state = conexion.prepareStatement(list);
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Alumno alu = new Alumno();
        		alu.setDni(rs.getString("dni"));
        		alu.setNroLegajo(rs.getInt("nroLegajo"));
        		alu.setFechaNac(rs.getString("fechaNac"));
        		alu.setNombre(rs.getString("nombre"));
        		alu.setApellido(rs.getString("apellido"));
        		alu.setDireccion(rs.getString("domicilio"));
        		
        		Provincia provi= new Provincia();
        		provi.setId(rs.getInt("idprovincia"));
        		provi.setNombre(rs.getString("nombreProvincia"));       		
        		alu.setProvincia(provi);
        		
        		Nacionalidad nacion= new Nacionalidad();
        		nacion.setId(rs.getInt("idnacionalidad"));
        		nacion.setNombre(rs.getString("nombreNacionalidad"));       		
        		alu.setNacionalidad(nacion);
        		
        		alu.setMail(rs.getString("email"));
        		alu.setTelefono(rs.getString("telefono"));
        		alu.setestado(rs.getBoolean("estado"));
        		listaAlum.add(alu);
        	}	
        }
        catch(Exception  e)
        {
        	return listaAlum;
        }
        
		return listaAlum;
	}

	public String GetNextLegajo() 
	{
		try 
		{
			String id = "";
			Connection conexion = Conexion.getConexion().getSQLConexion();
			ResultSet rs;
			rs = conexion.createStatement().executeQuery("SELECT COUNT(*) + 1 AS ID FROM cursada.alumnos");
			while (rs.next()) 
			{
				id = rs.getString("ID");
			}
			return id;
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(int legajo) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
}
