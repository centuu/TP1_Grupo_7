package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.MateriaDao;
import entidad.Materia;

public class MateriaImpl implements MateriaDao
{
	public ArrayList<Materia> list()
	{
		PreparedStatement state;
		ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		 
        try
        {
        	state = conexion.prepareStatement("SELECT * FROM materias");
            ResultSet rs = state.executeQuery();
        	while(rs.next())
        	{
        		Materia materia = new Materia();
        		materia.setId(rs.getInt("idMateria"));
        		materia.setDescripcion(rs.getString("descripcion"));
        		materia.setAnio(rs.getInt("anio"));
        		materia.setIdCarrera(rs.getInt("idCarrera"));
        		
        		listaMaterias.add(materia);
        	}	
        }
        catch(Exception  e)
        {
        	return listaMaterias;
        }
        
		return listaMaterias;
	}
}
