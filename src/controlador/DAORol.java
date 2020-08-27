package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import gestorBD.DatabaseManager;
import modelo.Funcionalidad;
import modelo.Rol;

public class DAORol {
	private static final String CUENTA_ROLES = "SELECT COUNT(ID_ROL) AS CUENTA FROM ROL";
	private static final String ALL_ROLES = "SELECT * FROM ROL";
	private static final String INSERT_ROLES = "INSERT INTO ROL (ID_ROL,NOMBRE,"
			+ "DESCRIPCION) "
			+ "values (?,?,?)";
	private static final String UPDATE_ROLES = "UPDATE ROL SET NOMBRE=?, "
			+ "DESCRIPCION=? "
			+ "WHERE ID_ROL=?";
	private static final String DELETE_ROLES = "DELETE FROM ROL WHERE ID_ROL=?";
	private static final String SELECCIONAR_ROL_BY_ID = "SELECT * FROM ROL WHERE ID_ROL=?";
	private static final String BUSCAR_ROL= "SELECT * FROM ROL WHERE NOMBRE=?";
	
	public static int cuentaFuncionalidades() {
		int Cuenta = 0;
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_ROLES);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Cuenta = resultado.getInt("CUENTA");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return Cuenta;
	}
	
	public static ResultSet findAll() {
		LinkedList<Rol> rol = new LinkedList<>();
		Statement statement;
		ResultSet resultado;
		try {
			
			statement = DatabaseManager.getConnection().createStatement();
			resultado = statement.executeQuery(ALL_ROLES);
			return resultado;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean insert(Rol p) {
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_ROLES);
			int i = 500;
			statement.setLong(1, i);
			statement.setString(2, p.getNombre());
			statement.setString(3, p.getDescripcion());
			
			int Retorno = statement.executeUpdate();
			i++;
			return Retorno>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit (Rol rol){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_ROLES);
			
			statement.setString(1, rol.getNombre());
			statement.setString(2, rol.getDescripcion());
			int retorno = statement.executeUpdate();
			
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean delete(int idRol){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_ROLES);
			statement.setInt(1, idRol);
			
			int retorno = statement.executeUpdate();
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public static Rol findRolId(String id) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECCIONAR_ROL_BY_ID);
			statement.setString(1, id);
			
			
			ResultSet resultado = statement.executeQuery();
			Rol rol = null;
			if(resultado.next()){
				rol = getRolRS(resultado);
			}
			Rol r = new Rol(rol.getNombre(), rol.getDescripcion(), null, null);
			return r;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Rol findRol(String nombre) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_ROL);
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next()){
				return getRolRS(resultado);
				
			}
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private static Rol getRolRS(ResultSet resultado) throws SQLException {
		
		String nombre = resultado.getString(1);
		String descripcion = resultado.getString(2);
		
		
		
		Rol rol = new Rol(nombre, descripcion, null, null);
		
		return rol;
	
	}
}
