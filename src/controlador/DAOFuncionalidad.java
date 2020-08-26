package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import gestorBD.DatabaseManager;
import modelo.Funcionalidad;

public class DAOFuncionalidad {
	private static final String CUENTA_FUNCIONALIDADES = "SELECT COUNT(ID_FUNCIONALIDAD) AS CUENTA FROM FUNCIONALIDAD";
	private static final String ALL_FUNCIONALIDADES = "SELECT * FROM FUNCIONALIDAD";
	private static final String INSERT_FUNCIONALIDADES = "INSERT INTO FUNCIONALIDAD (ID_FUNCIONALIDAD,NOMBRE,"
			+ "DESCRIPCION) "
			+ "values (?,?,?)";
	private static final String UPDATE_FUNCIONALIDADES = "UPDATE FUNCIONALIDAD SET ID_FUNCIONALIDAD=?, NOMBRE=?, "
			+ "DESCRIPCION=? "
			+ "WHERE ID_FUNCIONALIDAD=?";
	private static final String DELETE_FUNCIONALIDADES = "DELETE FROM FUNCIONALIDAD WHERE ID_FUNCIONALIDAD=?";
	private static final String SELECCIONAR_FUNCIONALIDAD_BY_ID = "SELECT * FROM FUNCIONALIDAD WHERE ID_FUNCIONALIDAD=?";
	private static final String BUSCAR_FUNCIONALIDAD= "SELECT * FROM FUNCIONALIDAD WHERE NOMBRE=?";
	
	public static int cuentaFuncionalidades() {
		int Cuenta = 0;
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_FUNCIONALIDADES);
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
		LinkedList<Funcionalidad> funcionalidades = new LinkedList<>();
		Statement statement;
		ResultSet resultado;
		try {
			
			statement = DatabaseManager.getConnection().createStatement();
			resultado = statement.executeQuery(ALL_FUNCIONALIDADES);
			return resultado;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean insert(Funcionalidad p) {
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_FUNCIONALIDADES);
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
	
	public static boolean edit (Funcionalidad funcionalidad){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_FUNCIONALIDADES);
			
			statement.setString(1, funcionalidad.getNombre());
			statement.setString(2, funcionalidad.getDescripcion());
			int retorno = statement.executeUpdate();
			
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean delete(int idFuncionalidad){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_FUNCIONALIDADES);
			statement.setInt(1, idFuncionalidad);
			
			int retorno = statement.executeUpdate();
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public static Funcionalidad findFuncionalidadId(String id) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECCIONAR_FUNCIONALIDAD_BY_ID);
			statement.setString(1, id);
			
			
			ResultSet resultado = statement.executeQuery();
			Funcionalidad funcionalidad = null;
			if(resultado.next()){
				funcionalidad = getFuncionalidadRS(resultado);
			}
			Funcionalidad fun = new Funcionalidad(funcionalidad.getNombre(), funcionalidad.getDescripcion(), null);
			return fun;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Funcionalidad findFuncionalidad(String nombre, String descripcion) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_FUNCIONALIDAD);
			statement.setString(1, nombre);
			statement.setString(2, descripcion);
			
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next()){
				return getFuncionalidadRS(resultado);
				
			}
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private static Funcionalidad getFuncionalidadRS(ResultSet resultado) throws SQLException {
		
		String nombre = resultado.getString(1);
		String descripcion = resultado.getString(2);
		
		
		
		Funcionalidad funcionalidad = new Funcionalidad(nombre, descripcion, null);
		
		return funcionalidad;
	
	}
}
