package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl  implements UsuarioDao
{
	public UsuarioDaoImpl()
	{
		
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
