package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao  
{
	private static final String list =   "SELECT * FROM provincias";

	@Override
	public ArrayList<Provincia> listaProvincia() 
	{
		PreparedStatement state;
		ArrayList<Provincia> lista = new ArrayList<Provincia>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
        ResultSet rs=null;
        try
        {
        	state = conexion.prepareStatement(list);
        	rs = state.executeQuery();
        	while(rs.next())
        	{
        		Provincia prov = new Provincia();
        		prov.setId(rs.getInt("idProvincia"));
        		prov.setNombre(rs.getString("descripcion"));
        		lista.add(prov);
        	}
        }
        catch(Exception  e)
        {
        	return lista;
        }

        return lista;
	}

}