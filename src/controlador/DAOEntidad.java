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
			
			if (!resultado.isBeforeFirst() ) {
			    System.out.println("no data");
			} 
			while(resultado.next()) {
				
				String [] datosFila = new String[cantColumna];
				JOptionPane.showMessageDialog(null, "Numero: " + cantColumna);

				for (int i = 0; i < datosFila.length; i++) {


					datosFila[i] = resultado.getString(i+1);
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
