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
import modelo.Rol;

public class DAOPersona {
	
	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CUENTA FROM PERSONA";
	private static final String ALL_PERSONAS = "SELECT R.ID_ROL, P.ID_PERSONA, P.DOCUMENTO, P.NOMBRE1, P.NOMBRE2, P.APELLIDO1, "
												+ "P.APELLIDO2, P.FEC_NAC, P.MAIL, P.CLAVE, R.NOMBRE AS ROL FROM PERSONA "
												+ "P INNER JOIN ROL R ON P.ID_ROL = R.ID_ROL";
	private static final String INSERT_PERSONAS = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,"
			+ "NOMBRE2,FEC_NAC, MAIL, CLAVE, ID_ROL) "
			+ "values (SEQ_ID_PERSONA.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_PERSONAS = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, "
			+ "NOMBRE2=?, FEC_NAC=?, MAIL=?, CLAVE=?, ID_ROL=?"
			+ "WHERE ID_PERSONA=?";
	private static final String DELETE_PERSONAS = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
	private static final String SELECCIONAR_PERSONA_BY_ID = "SELECT * FROM PERSONA WHERE ID_PERSONA=?";
	private static final String BUSCAR_PERSONA= "SELECT * FROM PERSONA WHERE APELLIDO1=? AND NOMBRE1=?";
	private static final String BUSCAR_PERSONA_BY_DOC= "SELECT R.ID_ROL, P.ID_PERSONA, P.DOCUMENTO, P.NOMBRE1, P.NOMBRE2, P.APELLIDO1, "
			+ "P.APELLIDO2, P.FEC_NAC, P.MAIL, P.CLAVE, R.NOMBRE AS ROL FROM PERSONA "
			+ "P INNER JOIN ROL R ON P.ID_ROL = R.ID_ROL WHERE P.DOCUMENTO = ?";
	private static final String CONTRASENA = "SELECT MAIL, CLAVE, ID_ROL FROM PERSONA WHERE MAIL=?";
	
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
			statement.setDate(6, p.getFechaNac());
			statement.setString(7, p.getEmail());
			statement.setString(8, p.getClave());
			statement.setInt(9, p.getRol().getId());
			
						
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
			statement.setString(7, persona.getEmail());
			statement.setString(8, persona.getClave());
			statement.setInt(9, persona.getRol().getId());
			
			statement.setInt(10, persona.getId());
						
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
	
	public static Persona findPersona(String documento) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_PERSONA_BY_DOC);
			statement.setString(1, documento);
						
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
	
	public static boolean login(Persona pLogin) { 

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CONTRASENA);
			statement.setString(1, pLogin.getEmail());

			ResultSet resultado = statement.executeQuery();

			if (resultado.next()) {
				/*
				 * resultado.getString(1); // MAIL 
				 * resultado.getString(2);// CLAVE
				 * resultado.getString(3) // ROL
				 */
				
				
				if (pLogin.getEmail().equals(resultado.getString(1))
						&& pLogin.getClave().equals(resultado.getString(2))) {
					return true;
				}

				return false;

			}
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}

	}
	
	
	
	private static Persona getPersonaRS(ResultSet resultado) throws SQLException {
//		"SELECT R.ID_ROL, P.ID_PERSONA, P.DOCUMENTO, P.NOMBRE1, P.NOMBRE2, P.APELLIDO1, "
//				+ "P.APELLIDO2, P.FEC_NAC, P.MAIL, P.CLAVE, R.NOMBRE AS ROL FROM PERSONA "
//				+ "P INNER JOIN ROL R ON P.ID_ROL = R.ID_ROL WHERE P.DOCUMENTO = ?";
//		
		
		String documento = resultado.getString(3);
		String nombre1 = resultado.getString(4);
		String nombre2 = resultado.getString(5);
		String apellido1 = resultado.getString(6);
		String apellido2 = resultado.getString(7);
		java.sql.Date fechaNac = resultado.getDate(8);
		String email = resultado.getString(9);
		String clave = resultado.getString(10);
		
		
		Persona persona = new Persona(documento, nombre1, nombre2, apellido1, apellido2, fechaNac, clave, email);
		Rol r = new Rol();
		r.setId(resultado.getInt(1));
		r.setNombre(resultado.getString(11));
		persona.setRol(r);
		
		return persona;
	
	}
}
