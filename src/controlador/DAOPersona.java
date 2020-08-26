package controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import gestorBD.DatabaseManager;
import modelo.Persona;

public class DAOPersona {
	
	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CUENTA FROM PERSONA";
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONA";
	private static final String INSERT_PERSONAS = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,FEC_NAC, MAIL, CLAVE, ID_ROL) "
			+ "values (SEQ_ID_PERSONA.NEXTVAL,?,?,?,?,?,?,?,?,1)";
	private static final String UPDATE_PERSONAS = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=? "
			+ "WHERE ID_PERSONA=?";
	private static final String DELETE_PERSONAS = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
	private static final String SELECCIONAR_PERSONA_BY_ID = "SELECT * FROM PERSONA WHERE ID_PERSONA=?";
	private static final String BUSCAR_PERSONA= "SELECT * FROM PERSONA WHERE APELLIDO1=? AND NOMBRE1=?";
	
	public static int cuentaPersonas() {
		int Cuenta = 0;
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_PERSONAS);
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
		LinkedList<Persona> personas = new LinkedList<>();
		Statement statement;
		ResultSet resultado;
		try {
			
			statement = DatabaseManager.getConnection().createStatement();
			resultado = statement.executeQuery(ALL_PERSONAS);

//			while(resultado.next()) {
//				
//				String documento = resultado.getString(1);
//				String nombre1 = resultado.getString(4);
//				String nombre2 = resultado.getString(5);
//				String apellido1 = resultado.getString(2);
//				String apellido2 = resultado.getString(3);
//				Date fechaNac = resultado.getTimestamp(6);
//				String clave = resultado.getString(7);
//				String email = resultado.getString(8);
//				Persona p = new Persona(documento, nombre1, nombre2, apellido1, apellido2, null, clave, email);
//				
//				personas.add(p);
//			}
			return resultado;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean insert(Persona p) {
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PERSONAS);
			java.util.Date now = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(now.getTime());

			statement.setString(1, p.getDocumento());
			statement.setString(2, p.getApellido1());
			statement.setString(3, p.getApellido2());
			statement.setString(4, p.getNombre1());
			statement.setString(5, p.getNombre2());
			statement.setDate(6, sqlDate);
			statement.setString(7, p.getEmail());
			statement.setString(8, p.getClave());
			
			int Retorno = statement.executeUpdate();
			
			return Retorno>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit (Persona persona){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_PERSONAS);
			
			statement.setString(1, persona.getDocumento());
			statement.setString(2, persona.getApellido1());
			statement.setString(3, persona.getApellido2());
			statement.setString(4, persona.getNombre1());
			statement.setString(5, persona.getNombre2());
			statement.setDate(6, (java.sql.Date) persona.getFechaNac());
			statement.setString(7, persona.getClave());
			statement.setString(8, persona.getEmail());
			int retorno = statement.executeUpdate();
			
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean delete(int idPersona){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_PERSONAS);
			statement.setInt(1, idPersona);
			
			int retorno = statement.executeUpdate();
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public static Persona findPersonaId(String id) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECCIONAR_PERSONA_BY_ID);
			statement.setString(1, id);
			
			
			ResultSet resultado = statement.executeQuery();
			Persona persona = null;
			if(resultado.next()){
				persona = getPersonaRS(resultado);
			}
			Persona pe = new Persona(persona.getDocumento(), persona.getApellido1(),
					persona.getApellido2(), persona.getNombre1(), persona.getNombre2(), persona.getFechaNac(), persona.getClave(),
					persona.getEmail());
			return pe;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Persona findPersona(String apellido1, String nombre1) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_PERSONA);
			statement.setString(1, apellido1);
			statement.setString(2, nombre1);
			
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next()){
				return getPersonaRS(resultado);
				
			}
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private static Persona getPersonaRS(ResultSet resultado) throws SQLException {
		
		String documento = resultado.getString(1);
		String nombre1 = resultado.getString(4);
		String nombre2 = resultado.getString(5);
		String apellido1 = resultado.getString(2);
		String apellido2 = resultado.getString(3);
		Date fechaNac = resultado.getDate(6);
		String clave = resultado.getString(7);
		String email = resultado.getString(8);
		
		
		Persona persona = new Persona(documento, nombre1, nombre2, apellido1, apellido2, fechaNac, clave, email);
		
		return persona;
	
	}
}
