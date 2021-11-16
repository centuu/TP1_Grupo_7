package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import dao.AlumnoDao;
import entidad.Alumno;

public class AlumnoImpl implements AlumnoDao {
	private static final String insert = "INSERT INTO Alumnos (dni,nombre,apellido,fechaNac,domicilio,provincia,nacionalidad,email,telefono,estado) VALUES (?,?,?,?,?,?,?,?,?,true)";
	private static final String delete = "DELETE FROM Alumnos WHERE legajo = ?";
	private static final String list = "SELECT * FROM Alumnos";

	public boolean insert(Alumno alum) {
		int res = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement state;
		try {
			state = conexion.prepareStatement(insert);
			state.setString(1, alum.getDni());
			state.setString(2, alum.getNombre());
			state.setString(3, alum.getApellido());
			state.setString(4, alum.getFechaNac());
			state.setString(5, alum.getDireccion());
			state.setString(6, alum.getProvincia());
			//state.setString(7, alum.getNacionalidad()); Falta obtener string de nacionalidad (Analizar)
			state.setString(7, "Argentina");
			state.setString(8, alum.getMail());
			state.setString(9, alum.getTelefono());
			
			res = state.executeUpdate();

			if (res > 0) {
				conexion.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
			}
			return false;
		}

		return res > 0;
	}

	@Override
	public ArrayList<Alumno> list() {
		PreparedStatement state;
		ArrayList<Alumno> listaAlum = new ArrayList<Alumno>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;

		try {
			state = conexion.prepareStatement(list);
			rs = state.executeQuery();
			while (rs.next()) {
				Alumno alu = new Alumno();
				alu.setDni(rs.getString("dni"));
				alu.setNombre(rs.getString("nombre"));
				alu.setApellido(rs.getString("apellido"));
				alu.setDireccion(rs.getString("domicilio"));
				alu.setProvincia(rs.getString("provincia"));
				alu.setNacionalidad(rs.getString("nacionalidad"));
				alu.setMail(rs.getString("email"));
				alu.setTelefono(rs.getString("telefono"));
				alu.setestado(rs.getBoolean("estado"));
				listaAlum.add(alu);
			}
		} catch (Exception e) {
			return listaAlum;
		}

		return null;
	}

	public String GetNextLegajo() {
		try {
			String id = "";
			Connection conexion = Conexion.getConexion().getSQLConexion();
			ResultSet rs;
			rs = conexion.createStatement().executeQuery("SELECT COUNT(*) + 1 AS ID FROM cursada.alumnos");
			while (rs.next()) {
				id = rs.getString("ID");
			}
			return id;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(int legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int legajo) {
		// TODO Auto-generated method stub
		return false;
	}
}
