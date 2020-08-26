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
			
			for (int i  = 0; i < cantColumna - 1; i++) {
				if(i != 0 || i != 8)
				modeloTabla.addColumn(datosColumna.getColumnName(i+1));
				
			}
			
			//JOptionPane.showMessageDialog(null, "Numero: " + size);
			while(resultado.next()) {
				
				String [] datosFila = new String[cantColumna];
				JOptionPane.showMessageDialog(null, "Numero: " + cantColumna);

				for (int i = 0; i < datosFila.length; i++) {
					JOptionPane.showMessageDialog(null, "Numero: " + 1);
					datosFila[i] = resultado.getString(i);
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
