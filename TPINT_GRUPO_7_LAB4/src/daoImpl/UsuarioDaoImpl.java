package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidad.Docente;
import entidad.Usuario;

public class UsuarioDaoImpl  implements UsuarioDao
{
	public UsuarioDaoImpl()
	{
		super();
	}
	
	public boolean insert(Docente docente) throws SQLException
	{
		int res = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try 
		{
			state = conexion.prepareStatement("INSERT INTO usuarios (usuario, clave, legajo, rol) VALUES (?, ?, ?, 2)");
			state.setString(1, docente.getDni());
			state.setString(2, docente.getClave());
			state.setInt(3, docente.getLegajo());
			
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
	
	public Usuario checkLogin(String usuario, String clave) throws SQLException, ClassNotFoundException
	{
		try 
		{
			Connection conexion = Conexion.getConexion().getSQLConexion();
			PreparedStatement statement = conexion.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND clave = ?");
	        statement.setString(1, usuario);
	        statement.setString(2, clave);
	 
	        ResultSet result = statement.executeQuery();

	        Usuario user = null;
	 
	        if (result.next()) 
	        {
	            user = new Usuario(usuario, clave, result.getInt("legajo"), result.getInt("rol"));
	        }
	 
	        return user;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;			
		}
	}
}
