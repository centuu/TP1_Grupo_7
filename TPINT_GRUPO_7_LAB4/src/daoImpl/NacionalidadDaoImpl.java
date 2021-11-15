package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.NacionalidadDao;
import entidad.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao  
{
	private static final String list =   "SELECT * FROM Nacionalidad";

	@Override
	public ArrayList<Nacionalidad> listaNacion() 
	{
		PreparedStatement state;
		ArrayList<Nacionalidad> lista = new ArrayList<Nacionalidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
        ResultSet rs=null;
        try
        {
        	state = conexion.prepareStatement(list);
        	rs = state.executeQuery();
        	while(rs.next())
        	{
        		Nacionalidad nacion = new Nacionalidad();
        		nacion.setId(rs.getInt("idNacionalidad"));
        		nacion.setNombre(rs.getString("descripcion"));
        		lista.add(nacion);
        	}
        }
        catch(Exception  e)
        {
        	return lista;
        }

        return lista;
	}

}
