package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestorBD.gestorBD;
import modelo.Persona;

public class ControladorPersona {
	//sd
	public ArrayList<Persona> getPersonas(){
			gestorBD bd = new gestorBD();
			bd.conectarBD();
			ResultSet result = bd.getListaEntidad("PERSONA");
			ArrayList<Persona> personas = new ArrayList<Persona>();
			try {
				while(result.next()) {
					Persona p = new Persona(result.getString("DOCUMENTO"),result.getString("NOMBRE1"),result.getNString("NOMBRE2"),
									result.getString("APELLIDO1"),result.getString("APELLIDO2"),result.getDate("FEC_NAC"),result.getString("CLAVE"),
									result.getString("EMAIL"));
					personas.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return personas;
	}
}
