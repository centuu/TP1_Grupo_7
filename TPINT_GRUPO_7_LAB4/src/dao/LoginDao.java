package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daoImpl.Conexion;

public class LoginDao {
	
	String sql = "SELECT * FROM usuarios WHERE usuario=? AND clave=?";
	public boolean check(String usuario, String clave) throws SQLException 
	{
		boolean status = false;
		try 
		{
			Connection conexion = Conexion.getConexion().getSQLConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1,usuario);
			ps.setString(2,clave);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				status = true;
				return status;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		return status;
		
	}

}
