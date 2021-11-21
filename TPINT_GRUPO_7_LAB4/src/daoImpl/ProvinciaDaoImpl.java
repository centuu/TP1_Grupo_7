package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao  
{
	private static final String list ="SELECT * FROM provincia";

	@Override
	public ArrayList <Provincia> list() 
	{
		PreparedStatement state;
		ArrayList<Provincia> listaProvincia = new ArrayList<Provincia>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
        
        try
        {
        	state = conexion.prepareStatement(list);
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Provincia prov = new Provincia();
        		prov.setId(rs.getInt("id"));
        		prov.setNombre(rs.getString("nombreProvincia"));
        		listaProvincia.add(prov);
        	}
        }
        catch(Exception  e)
        {
        	return listaProvincia;
        }

        return listaProvincia;
	}

}