package dao;

import java.sql.SQLException;
import entidad.Usuario;

public interface UsuarioDao 
{
	public Usuario checkLogin(String usuario, String clave) throws SQLException, ClassNotFoundException;
}
