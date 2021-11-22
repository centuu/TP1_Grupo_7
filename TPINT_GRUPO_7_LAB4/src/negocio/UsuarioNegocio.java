package negocio;

import java.sql.SQLException;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;

public class UsuarioNegocio implements UsuarioDao
{
	UsuarioDaoImpl dao = new UsuarioDaoImpl();
	
	@Override
	public Usuario checkLogin(String usuario, String clave) throws SQLException, ClassNotFoundException 
	{
		return dao.checkLogin(usuario, clave);
	}

}
