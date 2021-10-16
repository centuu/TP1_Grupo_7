package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Persona;

public class PersonaDaoIml
{
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String list = "SELECT * FROM personas";

	public boolean Insert(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean registro = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				registro = true;
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
		
		return registro;
	}
	
    public boolean Delete(Persona persona) 
    {	
    	PreparedStatement state;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean eliminar = false;
		try
		{
			state = conexion.prepareStatement(delete);
			state.setString(1,Integer.toString(persona.getDni()));
			if(state.executeUpdate() > 0)
			{
				conexion.commit();
				eliminar = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return eliminar;
    }
    
    public ArrayList<Persona> List()
    {
    	ArrayList<Persona> Personas= new ArrayList<Persona>();
    	PreparedStatement state;
		Conexion conexion = Conexion.getConexion();
		try
		{
			state = conexion.getSQLConexion().prepareStatement(list);
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				Persona nuevo= new Persona();
				nuevo.setDni(rs.getInt("dni"));
				nuevo.setNombre(rs.getString("nombre"));
				nuevo.setApellido(rs.getString("apellido"));
				Personas.add(nuevo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return Personas;
     }
}