package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import dao.SeguroDao;
import entidad.Seguro;

public class SeguroImpl implements SeguroDao 
{
	private static final String insert = "INSERT INTO Seguros(idTipo,descripcion,costoContratacion,costoAsegurado) VALUES(?,?,?,?)";
	private static final String delete = "DELETE FROM Seguros WHERE idSeguro = ?";
	private static final String list =   "SELECT * FROM Seguros";
	
	@Override
	public boolean insert(Seguro seguro) 
	{
		int result = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement ps;
		try 
		{
			ps = conexion.prepareStatement(insert);
			ps.setInt(1,seguro.getTipo());
			ps.setString(2,seguro.getDescripcion());
			ps.setBigDecimal(3,seguro.getCostoContratacion());
			ps.setBigDecimal(4,seguro.getcostoAsegurado());
			
			result = ps.executeUpdate();
			if (result > 0) 
			{
				conexion.commit();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException ex) 
			{
				ex.printStackTrace();
				return false;
			}
			return false;
		}

		return result > 0;
	}
	
	public String GetNextId()
	{
		try 
		{
			String id= "";
			Connection conexion = Conexion.getConexion().getSQLConexion();
			ResultSet rs;
			rs = conexion.createStatement().executeQuery("SELECT COUNT(*) + 1 AS ID FROM Seguros");
			while(rs.next())
			{
				id= rs.getString("ID");
			}
			return id;
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Seguro eliminar) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Seguro> listarxTipo(String tipo) 
	{
		//if (tipo==null)tipo="1";
		
		PreparedStatement statement;
		ArrayList<Seguro> listaseguro = new ArrayList<Seguro>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(list);
			rs = statement.executeQuery();
			while(rs.next())
			{
				Seguro seguro = new Seguro();
				seguro.setIdSeguro(rs.getInt("idseguro"));
				seguro.setDescripcion(rs.getString("descripcion"));
				seguro.setTipo(rs.getInt("idTipo"));
				seguro.setCostoContratacion(rs.getBigDecimal("costoContratacion"));
				seguro.setcostoAsegurado(rs.getBigDecimal("costoAsegurado"));
				if (seguro.getTipo()==Integer.parseInt(tipo))
				{
					listaseguro.add(seguro);
					
				}
				
			}
			return listaseguro; //Envio la lista co
	       }
		catch(Exception e)
		{
			return listaseguro;
		}
	}
}
