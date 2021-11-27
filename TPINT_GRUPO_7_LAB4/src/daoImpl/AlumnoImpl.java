package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.CallableStatement;

import java.sql.ResultSet;

import dao.AlumnoDao;
import entidad.Alumno;
import entidad.Nacionalidad;
import entidad.Provincia;

public class AlumnoImpl implements AlumnoDao 
{
    private static final String edit = "UPDATE Alumnos SET Dni = ?, nombre = ? , apellido = ?, fechaNac = ?, domicilio = ?, idprovincia = ?,idNacionalidad =?,email = ? , telefono = ? WHERE nrolegajo =?"; 
	
    public boolean insert(Alumno alum) 
	{
    	boolean res = false;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			CallableStatement state = conexion.prepareCall("{CALL insert_Alumno(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			state.setString(1, alum.getDni());
			state.setString(2, alum.getNombre());
			state.setString(3, alum.getApellido());			
			state.setString(4, alum.getFechaNac());
			state.setString(5, alum.getDireccion());			
			state.setInt(6, alum.getProvincia().getId());
			state.setInt(7, alum.getNacionalidad().getId());			
			state.setString(8, alum.getMail());
			state.setString(9, alum.getTelefono());

			if (state.executeUpdate() > 0) 
			{
				conexion.commit();
				res = true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return res;
	}
	
	public boolean delete(int legajo) 
	{
    	boolean res = false;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			CallableStatement state = conexion.prepareCall("{CALL delete_Alumno(?)}");
			state.setInt(1, legajo);

			if (state.executeUpdate() > 0) 
			{
				conexion.commit();
				res = true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1)
			{
					e1.printStackTrace();
			}
		}

		return res;
	}

	@Override
	public ArrayList<Alumno> list()
	{
		ArrayList<Alumno> listaAlum = new ArrayList<Alumno>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
			CallableStatement state = conexion.prepareCall("{CALL list_Alumnos()}");
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
        		Provincia provi= new Provincia();
        		provi.setId(rs.getInt("idprovincia"));
        		provi.setNombre(rs.getString("provincia"));       		
        		alu.setProvincia(provi);        		
        		Nacionalidad nacion= new Nacionalidad();
        		nacion.setId(rs.getInt("idnacionalidad"));
        		nacion.setNombre(rs.getString("nacionalidad"));       		
        		alu.setNacionalidad(nacion);        		
        		alu.setMail(rs.getString("email"));
        		alu.setTelefono(rs.getString("telefono"));
        		alu.setestado(rs.getBoolean("estado"));
        		
        		listaAlum.add(alu);
        	}	
        }
        catch(Exception  e)
        {
        	e.printStackTrace();
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
	public int update(Alumno alumno) 
	{
		PreparedStatement state;	
		Connection conexion = Conexion.getConexion().getSQLConexion();

		int res=-1;

		 try
		 {
			    state = conexion.prepareStatement(edit);
				state.setString(1, alumno.getDni());
				state.setString(2, alumno.getNombre());
				state.setString(3, alumno.getApellido());
				state.setString(4, alumno.getFechaNac());
				state.setString(5, alumno.getDireccion());

				state.setInt(6, alumno.getProvincia().getId());
				state.setInt(7, alumno.getNacionalidad().getId());

				state.setString(8, alumno.getMail());
				state.setString(9, alumno.getTelefono());
				state.setInt(10,alumno.getLegajo());
				res = state.executeUpdate();

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
			catch (SQLException e1) 
			{
					e1.printStackTrace();
			}
		 }
		 
		return alumno.getLegajo();
	}
	
	public Alumno buscarAlumno(int legajo)
	{
		Alumno alumno=new Alumno();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			CallableStatement state = conexion.prepareCall("{CALL find_Alumno(?)}");
			state.setInt(1, legajo);
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

					Provincia provi= new Provincia();
					provi.setId(rs.getInt("idprovincia"));
					provi.setNombre(rs.getString("provincia"));       		
					alu.setProvincia(provi);

					Nacionalidad nacion= new Nacionalidad();
					nacion.setId(rs.getInt("idnacionalidad"));
					nacion.setNombre(rs.getString("nacionalidad"));       		
					alu.setNacionalidad(nacion);

					alu.setMail(rs.getString("email"));
					alu.setTelefono(rs.getString("telefono"));
					alu.setestado(rs.getBoolean("estado"));
					alumno=alu;
		    }
	        return alumno;
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return alumno;
		}
	}
}
