package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DocenteDao;
import entidad.Docente;

public class DocenteImpl implements DocenteDao
{
	private static final String insert = "INSERT INTO Docentes (dni,nombre,apellido,fechaNac,domicilio,localidad,nacionalidad,email,telefono,estado) VALUES (?,?,?,?,?,?,?,?,?,true)";
	private static final String delete = "DELETE FROM Docentes WHERE legajo = ?";
	private static final String list = "SELECT * FROM Docentes";

	public boolean insert(Docente docente) 
	{
		int res = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try {
			state = conexion.prepareStatement(insert);
			state.setString(1, docente.getDni());
			state.setString(2, docente.getNombre());
			state.setString(3, docente.getApellido());
			state.setString(4, docente.getFechaNac());
			state.setString(5, docente.getDireccion());
			state.setString(6, docente.getLocalidad());
			state.setString(7, docente.getNacionalidad());
			state.setString(8, docente.getMail());
			state.setString(9, docente.getTelefono());
			
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
	public ArrayList<Docente> list()
	{
		PreparedStatement state;
		ArrayList<Docente> listaDocente = new ArrayList<Docente>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	state = conexion.prepareStatement(list);
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Docente docente = new Docente();
        		docente.setDni(rs.getString("dni"));
        		docente.setNombre(rs.getString("nombre"));
        		docente.setApellido(rs.getString("apellido"));
        		docente.setDireccion(rs.getString("domicilio"));
        		docente.setLocalidad(rs.getString("idlocalidad"));
        		docente.setNacionalidad(rs.getString("idnacionalidad"));
        		docente.setMail(rs.getString("email"));
        		docente.setTelefono(rs.getString("telefono"));
        		docente.setestado(rs.getBoolean("estado"));
        		listaDocente.add(docente);
        	}	
        }
        catch(Exception  e)
        {
        	return listaDocente;
        }
        
		return listaDocente;
	}

	public String GetNextLegajo() 
	{
		try 
		{
			String id = "";
			Connection conexion = Conexion.getConexion().getSQLConexion();
			ResultSet rs;
			rs = conexion.createStatement().executeQuery("SELECT COUNT(*) + 1 AS ID FROM cursada.docentes");
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

	@Override
	public boolean delete(int legajo) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
