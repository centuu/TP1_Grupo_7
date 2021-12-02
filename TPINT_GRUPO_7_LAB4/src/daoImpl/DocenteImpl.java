package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DocenteDao;
import entidad.Alumno;
import entidad.Docente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;

public class DocenteImpl implements DocenteDao
{
	private static final String insert = "INSERT INTO Docentes (dni,nombre,apellido,fechaNacimiento,domicilio,idlocalidad,idnacionalidad,email,telefono,clave,estado) VALUES (?,?,?,?,?,?,?,?,?,?,true)";
	private static final String delete = "DELETE FROM Docentes WHERE legajo = ?";
	private static String list = "SELECT * FROM docentes INNER JOIN nacionalidad ON docentes.idNacionalidad = nacionalidad.id INNER JOIN localidad ON docentes.idLocalidad = localidad.id WHERE docentes.estado = 1";
	private static final String edit = "UPDATE Docentes SET Dni = ?, nombre = ? , apellido = ?, fechaNacimiento = ?, domicilio = ?, idLocalidad = ?,idNacionalidad =?,email = ? , telefono = ? WHERE legajo =?"; 
	
	public boolean insert(Docente docente) throws SQLException
	{
		int res = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try 
		{
			state = conexion.prepareStatement(insert);
			state.setString(1, docente.getDni());
			state.setString(2, docente.getNombre());
			state.setString(3, docente.getApellido());
			state.setString(4, docente.getFechaNac());
			state.setString(5, docente.getDireccion());
			state.setInt(6, docente.getLocalidad().getId());
			state.setInt(7, docente.getNacionalidad().getId());
			state.setString(8, docente.getMail());
			state.setString(9, docente.getTelefono());
			state.setString(10, docente.getClave());
			
			res = state.executeUpdate();

			if (res > 0) 
			{
				conexion.commit();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}

		return res > 0;
	}
	
	public int cantRegistros() 
	{
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			CallableStatement state = conexion.prepareCall("{CALL count_Docentes()}");
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
	
	public ArrayList<Docente> list(int start, int total, String filter)
	{
		ArrayList<Docente> listaDoc = new ArrayList<Docente>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		list = "SELECT * FROM docentes INNER JOIN nacionalidad ON docentes.idNacionalidad = nacionalidad.id INNER JOIN localidad ON docentes.idLocalidad = localidad.id WHERE docentes.estado = 1";

		PreparedStatement state;
		
		if(filter != null && !filter.isEmpty())
		{
			list += " AND docentes.nombre LIKE \"%" + filter + "%\"";
		}
		
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
        		Docente doc = new Docente();
        		doc.setDni(rs.getString("dni"));
        		doc.setNroLegajo(rs.getInt("legajo"));
        		doc.setFechaNac(rs.getString("fechaNacimiento"));
        		doc.setNombre(rs.getString("nombre"));
        		doc.setApellido(rs.getString("apellido"));
        		doc.setDireccion(rs.getString("domicilio"));        		
        		Localidad loc = new Localidad();
        		loc.setId(rs.getInt("idLocalidad"));
        		loc.setNombre(rs.getString("localidad"));       		
        		doc.setLocalidad(loc);        		
        		Nacionalidad nacion= new Nacionalidad();
        		nacion.setId(rs.getInt("idNacionalidad"));
        		nacion.setNombre(rs.getString("nacionalidad"));       		
        		doc.setNacionalidad(nacion);        		
        		doc.setMail(rs.getString("email"));
        		doc.setTelefono(rs.getString("telefono"));
        		doc.setestado(rs.getBoolean("estado"));
        		
        		listaDoc.add(doc);
        	}	
        }
        catch(Exception  e)
        {
        	e.printStackTrace();
        }
        
		return listaDoc;
	}
	
	public Docente buscarDocente(int legajo)
	{
		Docente docente = new Docente();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			PreparedStatement state = conexion.prepareStatement(list + " AND docentes.legajo = ?");
			state.setInt(1, legajo);
            ResultSet rs = state.executeQuery();
			while(rs.next()) 
			{
				Docente doc = new Docente();
        		doc.setDni(rs.getString("dni"));
        		doc.setNroLegajo(rs.getInt("legajo"));
        		doc.setFechaNac(rs.getString("fechaNacimiento"));
        		doc.setNombre(rs.getString("nombre"));
        		doc.setApellido(rs.getString("apellido"));
        		doc.setDireccion(rs.getString("domicilio")); 
        		
        		Localidad loc = new Localidad();
        		loc.setId(rs.getInt("idLocalidad"));
        		loc.setNombre(rs.getString("localidad"));       		
        		doc.setLocalidad(loc);        		
        		
        		Nacionalidad nacion= new Nacionalidad();
        		nacion.setId(rs.getInt("idNacionalidad"));
        		nacion.setNombre(rs.getString("nacionalidad"));       		
        		doc.setNacionalidad(nacion);       
        		
        		doc.setMail(rs.getString("email"));
        		doc.setTelefono(rs.getString("telefono"));
        		doc.setestado(rs.getBoolean("estado"));
        		docente = doc;
		    }
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			
		}
		return docente;
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
        		Docente doc = new Docente();
        		doc.setDni(rs.getString("dni"));
        		doc.setNroLegajo(rs.getInt("legajo"));
        		doc.setFechaNac(rs.getString("fechaNacimiento"));
        		doc.setNombre(rs.getString("nombre"));
        		doc.setApellido(rs.getString("apellido"));
        		doc.setDireccion(rs.getString("domicilio"));        		
        		Localidad loc = new Localidad();
        		loc.setId(rs.getInt("idLocalidad"));
        		loc.setNombre(rs.getString("localidad"));       		
        		doc.setLocalidad(loc);        		
        		Nacionalidad nacion= new Nacionalidad();
        		nacion.setId(rs.getInt("idNacionalidad"));
        		nacion.setNombre(rs.getString("nacionalidad"));       		
        		doc.setNacionalidad(nacion);        		
        		doc.setMail(rs.getString("email"));
        		doc.setTelefono(rs.getString("telefono"));
        		doc.setestado(rs.getBoolean("estado"));
        		
        		listaDocente.add(doc);
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

	
	public int update(Docente docente) 
	{
		PreparedStatement state;	
		Connection conexion = Conexion.getConexion().getSQLConexion();

		int res=-1;

		 try
		 {
			    state = conexion.prepareStatement(edit);
				state.setString(1, docente.getDni());
				state.setString(2, docente.getNombre());
				state.setString(3, docente.getApellido());
				state.setString(4, docente.getFechaNac());
				state.setString(5, docente.getDireccion());

				state.setInt(6, docente.getLocalidad().getId());
				state.setInt(7, docente.getNacionalidad().getId());

				state.setString(8, docente.getMail());
				state.setString(9, docente.getTelefono());
				state.setInt(10, docente.getLegajo());
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
		 
		return docente.getLegajo();
	}

	@Override
	public boolean delete(int legajo) 
	{
		boolean res = false;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			PreparedStatement state = conexion.prepareStatement("UPDATE Docentes SET estado = 0 WHERE legajo = ?");
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
	public boolean update(int legajo) {
		// TODO Auto-generated method stub
		return false;
	}
}
