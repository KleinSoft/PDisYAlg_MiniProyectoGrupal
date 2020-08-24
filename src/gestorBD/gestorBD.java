package gestorBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Persona;

public class gestorBD {
		private Connection connection = null;
		
		public void conectarBD() {
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JAVA","JAVA");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Conexión creada con éxito.");
			} catch (SQLException|ClassNotFoundException e) {
				e.printStackTrace();
			} 
		}
		
		public ResultSet getListaEntidad(String entidad) {
			String consulta = "SELECT * FROM "+entidad;
			Statement sentencia=null;
			ResultSet result=null;
			try {
				sentencia = connection.createStatement();
			    result = sentencia.executeQuery(consulta);
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	
		public ArrayList<Persona> getPersonas() {
			String consulta = "SELECT * FROM PERSONA";
			Statement sentencia=null;
			ArrayList<Persona> res= new ArrayList<Persona>();

			try {
				sentencia = connection.createStatement();
				ResultSet result = sentencia.executeQuery(consulta);
				while(result.next()) {
					Persona p = new Persona(result.getString("DOCUMENTO"),result.getString("NOMBRE1"),result.getNString("NOMBRE2"),
									result.getString("APELLIDO1"),result.getString("APELLIDO2"),result.getDate("FEC_NAC"),result.getString("CLAVE"),
									result.getString("EMAIL"));
					res.add(p);
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return res;

		}
		
		public void cargarTabla(JTable tabla, String consulta) {
			Statement sentencia=null;
			DefaultTableModel modeloTabla = new DefaultTableModel();

			try {
				sentencia = connection.createStatement();
				ResultSet result = sentencia.executeQuery(consulta);
				
				ResultSetMetaData datosTabla = result.getMetaData();
				
				
				int cantColumnas = datosTabla.getColumnCount();
				for (int i = 0; i < cantColumnas; i++) {
					modeloTabla.addColumn(datosTabla.getColumnName(i+1));

				}
			
				while(result.next()) {
					String [] datosFila = new String[cantColumnas];
					
					for (int i = 0; i < datosFila.length; i++) {
						datosFila[i] = result.getString(i+1);
					
					}
					
					modeloTabla.addRow(datosFila);
					

				}
				tabla.setModel(modeloTabla);
				modeloTabla.fireTableDataChanged();
				
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			

		}
}
