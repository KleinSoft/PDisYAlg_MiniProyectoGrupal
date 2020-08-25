package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestorBD.DatabaseManager;
import modelo.Persona;

public class DAOEntidad {
	
	public static DefaultTableModel cargarTabla(ResultSet resultado) {
		
		DefaultTableModel modeloTabla = new DefaultTableModel();

		try {
			
			
		
			ResultSetMetaData datosColumna = resultado.getMetaData();
			int cantColumna = datosColumna.getColumnCount();
			
			for (int i  = 0; i < cantColumna - 1; i++) {
				modeloTabla.addColumn(datosColumna.getColumnName(i+1));
				
			}
			
			while(resultado.next()) {
				
				String [] datosFila = new String[cantColumna];
				
				for (int i = 0; i < datosFila.length; i++) {
					datosFila[i] = resultado.getString(i+1);	
					
				}
				
				modeloTabla.addRow(datosFila);
				

			}
	
			return modeloTabla;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}			

	}
}
