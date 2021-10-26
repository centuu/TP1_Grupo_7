package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.TipoSeguroDao;
import entidad.TipoSeguro;


public class TipoSeguroImpl implements TipoSeguroDao 
{
	private static final String list = "select * from tipoSeguros";
	@Override
	
	public ArrayList<TipoSeguro> list()
	{
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<TipoSeguro> Lista = new ArrayList<TipoSeguro>();
		Connection conexion = Conexion.getConexion().getSQLConexion();

		try
		{
			ps = conexion.prepareStatement(list);
			rs = ps.executeQuery();
			while(rs.next()) 
			{
				TipoSeguro tipo = new TipoSeguro();
				
				tipo.setIdtipo(rs.getShort("idtipo"));
				tipo.setDescripcion(rs.getString("descripcion"));
				Lista.add(tipo);
			}
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
			return Lista;
		}
		
		return Lista;
	}
}
