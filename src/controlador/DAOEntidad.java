package controlador;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOEntidad {
	
	public static void cargarTabla(JTable table, ResultSet resultado) {
		
		DefaultTableModel modeloTabla = new DefaultTableModel();

		try {
			
			ResultSetMetaData datosColumna = resultado.getMetaData();
			int cantColumna = datosColumna.getColumnCount();
			
			for (int i  = 1; i <= cantColumna; i++) {
					modeloTabla.addColumn(datosColumna.getColumnName(i));
				
			}
			
			while(resultado.next()) {
				String [] datosFila = new String[cantColumna];

				for (int i = 0; i < datosFila.length; i++) {
					if (resultado.getString(i+1) == null) {
						datosFila[i] = "-";
					} else {
						datosFila[i] = resultado.getString(i+1);
					}
				}			
				modeloTabla.addRow(datosFila);

			}
			
			table.setModel(modeloTabla);
			modeloTabla.fireTableDataChanged();
			
		} catch (Exception e) {
			e.printStackTrace();
		}			

	}
}
