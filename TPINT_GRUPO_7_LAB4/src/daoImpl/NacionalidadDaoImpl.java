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
	public ArrayList <Nacionalidad> list() 
	{
		PreparedStatement state;
		ArrayList<Nacionalidad> listaNacionalidad = new ArrayList<Nacionalidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
        
        try
        {
        	state = conexion.prepareStatement(list);
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Nacionalidad nac = new Nacionalidad();
        		nac.setId(rs.getInt("idNacionalidad"));
        		nac.setNombre(rs.getString("descripcion"));
        		listaNacionalidad.add(nac);
        	}
        }
        catch(Exception  e)
        {
        	return listaNacionalidad;
        }

        return listaNacionalidad;
	}

}
