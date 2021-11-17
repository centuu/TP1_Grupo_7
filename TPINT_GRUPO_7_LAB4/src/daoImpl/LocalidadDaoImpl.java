package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.LocalidadDao;
import entidad.Localidad;

public class LocalidadDaoImpl implements LocalidadDao  
{
	private static final String list =   "SELECT * FROM Localidad";

	@Override
	public ArrayList <Localidad> list() 
	{
		PreparedStatement state;
		ArrayList<Localidad> listaLocalidad = new ArrayList<Localidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
        
        try
        {
        	state = conexion.prepareStatement(list);
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Localidad loc = new Localidad();
        		loc.setId(rs.getInt("idLocalidad"));
        		loc.setNombre(rs.getString("descripcion"));
        		listaLocalidad.add(loc);
        	}
        }
        catch(Exception  e)
        {
        	return listaLocalidad;
        }

        return listaLocalidad;
	}

}
