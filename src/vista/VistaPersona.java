package vista;

import java.awt.EventQueue;

import modelo.Persona;

import javax.swing.JFrame;

import controlador.DAOEntidad;
import controlador.DAOPersona;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaPersona {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPersona window = new VistaPersona();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaPersona() {
		initialize();

		DAOEntidad.cargarTabla(table, DAOPersona.findAll());
		ajustesTabla();

	}
		
	private void ajustesTabla() {
		 table.getColumnModel().getColumn(0).setMinWidth(0);
		 table.getColumnModel().getColumn(0).setMaxWidth(0);
		 table.getColumnModel().getColumn(0).setWidth(0);
	}

	private JScrollPane scrollPane;
	private JTable table;
	private JTextField documentoInsertarTexto;
	private JTextField primerNombreInsertarTexto;
	private JTextField segundoNombreInsertarTexto;
	private JTextField primerApellidoInsertarTexto;
	private JTextField segundoApellidoInsertarTexto;
	private JTextField correoInsertarTexto;
	private JTextField claveInsertarTexto;
	private JLabel Documento_1_2;
	private JLabel Documento_1_3;
	private JLabel Documento_1_4;
	private JPanel panelModificacion;
	private JLabel documentoModificarLabel;
	private JTextField documentoModificarTexto;
	private JLabel Documento_1_1_2;
	private JLabel Documento_3;
	private JTextField claveModificarTexto;
	private JButton ModificarBoton;
	private JLabel Documento_1_5;
	private JTextField primerNombreModificarTexto;
	private JLabel Documento_1_6;
	private JTextField segundoNombreModificarTexto;
	private JLabel Documento_1_7;
	private JTextField correoModificarTexto;
	private JLabel Documento_1_8;
	private JTextField segundoApellidoModificarTexto;
	private JTextField primerApellidoModificarTexto;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel Documento_2;
	private JTextField documentoEliminarTexto;
	private JLabel Documento_1_1_3;
	private JLabel Documento_4;
	private JTextField claveEliminarTexto;
	private JButton EliminarBoton;
	private JLabel Documento_1_9;
	private JTextField primerNombreEliminarTexto;
	private JLabel Documento_1_10;
	private JTextField segundoNombreEliminarTexto;
	private JLabel Documento_1_11;
	private JTextField correoEliminarTexto;
	private JLabel Documento_1_12;
	private JTextField segundoApellidoEliminarTexto;
	private JTextField primerApellidoEliminarTexto;
	private JPanel panel_3;
	private JLabel Documento_5;
	private JTextField textField_8;
	private JLabel Documento_1_1_4;
	private JLabel Documento_6;
	private JTextField textField_9;
	private JButton InsertarBoton_2;
	private JLabel Documento_1_13;
	private JTextField textField_10;
	private JLabel Documento_1_14;
	private JTextField textField_11;
	private JLabel Documento_1_15;
	private JTextField textField_12;
	private JLabel Documento_1_16;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField fechaDiaInsertTexto;
	private JTextField fechaMesInsertTexto;
	private JTextField fechaAnioInsertTexo;
	private JLabel Documento_1_4_1_2;
	private JLabel Documento_1_4_2;
	private JTextField fechaDiaModifTexto;
	private JLabel Documento_1_4_1_3;
	private JTextField fechaMesModifTexto;
	private JLabel Documento_1_4_1_4;
	private JTextField fechaAnioModifTexto;
	private JLabel Documento_1_4_3;
	private JTextField fechaDiaElimTexto;
	private JLabel Documento_1_4_1_5;
	private JTextField fechaMesElimTexto;
	private JLabel Documento_1_4_1_6;
	private JTextField fechaAnioElimTexto;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1323, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 961, 254);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
	        	try {
			    	if (!lse.getValueIsAdjusting()) {
			        	// Carga a valores de modificacion
			            documentoModificarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			            primerNombreModificarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
			            segundoNombreModificarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 5).toString());
			            primerApellidoModificarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
			            segundoApellidoModificarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
			            claveModificarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 7).toString());
			            correoModificarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 9).toString());
			            
			            String[] fechaNac = table.getModel().getValueAt(table.getSelectedRow(), 6).toString().split(" ");
			            String[] valoresFec = fechaNac[0].split("-");
			            
			            fechaDiaModifTexto.setText(valoresFec[2]);
			            fechaMesModifTexto.setText(valoresFec[1]);
			            fechaAnioModifTexto.setText(valoresFec[0]);
			            
			            //Carga a valores de baja
			            documentoEliminarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			            primerNombreEliminarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
			            segundoNombreEliminarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 5).toString());
			            primerApellidoEliminarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
			            segundoApellidoEliminarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
			            claveEliminarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 7).toString());
			            correoEliminarTexto.setText(table.getModel().getValueAt(table.getSelectedRow(), 9).toString());
			            
			            fechaDiaElimTexto.setText(valoresFec[2]);
			            fechaMesElimTexto.setText(valoresFec[1]);
			            fechaAnioElimTexto.setText(valoresFec[0]);

			        }
				} catch (Exception e) {
					// TODO: handle exception
				}
		    }
		});
		scrollPane.setViewportView(table);
		JTabbedPane panelABM = new JTabbedPane(JTabbedPane.TOP);
		panelABM.setToolTipText("");
		panelABM.setBounds(978, 5, 322, 254);
		frame.getContentPane().add(panelABM);
		
		panel = new JPanel();
		panelABM.addTab("Insertar", null, panel, null);
		panel.setLayout(null);
		
		JLabel Documento_1 = new JLabel("Documento");
		Documento_1.setBounds(5, 5, 150, 15);
		panel.add(Documento_1);
		
		documentoInsertarTexto = new JTextField();
		documentoInsertarTexto.setBounds(5, 25, 150, 22);
		panel.add(documentoInsertarTexto);
		documentoInsertarTexto.setColumns(10);
		
		JLabel Documento_1_1_1 = new JLabel("Primer Apellido");
		Documento_1_1_1.setBounds(160, 52, 150, 15);
		panel.add(Documento_1_1_1);
		
		JLabel Documento = new JLabel("Clave");
		Documento.setBounds(160, 5, 129, 16);
		panel.add(Documento);
		
		claveInsertarTexto = new JTextField();
		claveInsertarTexto.setBounds(160, 25, 150, 22);
		panel.add(claveInsertarTexto);
		claveInsertarTexto.setColumns(10);
		
		JButton InsertarBoton = new JButton("Insertar Nuevo");
		InsertarBoton.setBounds(5, 193, 305, 25);
		panel.add(InsertarBoton);
		
		JLabel Documento_1_1 = new JLabel("Primer Nombre");
		Documento_1_1.setBounds(5, 52, 129, 15);
		panel.add(Documento_1_1);
		
		primerNombreInsertarTexto = new JTextField();
		primerNombreInsertarTexto.setBounds(5, 72, 150, 22);
		panel.add(primerNombreInsertarTexto);
		primerNombreInsertarTexto.setColumns(10);
		
		Documento_1_2 = new JLabel("Segundo Nombre");
		Documento_1_2.setBounds(5, 99, 150, 15);
		panel.add(Documento_1_2);
		
		segundoNombreInsertarTexto = new JTextField();
		segundoNombreInsertarTexto.setBounds(5, 119, 150, 22);
		panel.add(segundoNombreInsertarTexto);
		segundoNombreInsertarTexto.setColumns(10);
		
		Documento_1_4 = new JLabel("Correo");
		Documento_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4.setBounds(5, 146, 150, 15);
		panel.add(Documento_1_4);
		
		correoInsertarTexto = new JTextField();
		correoInsertarTexto.setBounds(5, 166, 150, 22);
		panel.add(correoInsertarTexto);
		correoInsertarTexto.setColumns(10);
		
		Documento_1_3 = new JLabel("Segundo Apellido");
		Documento_1_3.setBounds(160, 99, 129, 15);
		panel.add(Documento_1_3);
		
		segundoApellidoInsertarTexto = new JTextField();
		segundoApellidoInsertarTexto.setBounds(160, 119, 150, 22);
		panel.add(segundoApellidoInsertarTexto);
		segundoApellidoInsertarTexto.setColumns(10);
		
		primerApellidoInsertarTexto = new JTextField();
		primerApellidoInsertarTexto.setBounds(160, 72, 150, 22);
		panel.add(primerApellidoInsertarTexto);
		primerApellidoInsertarTexto.setColumns(10);
		
		fechaDiaInsertTexto = new JTextField();
		fechaDiaInsertTexto.setColumns(10);
		fechaDiaInsertTexto.setBounds(160, 166, 35, 22);
		panel.add(fechaDiaInsertTexto);
		
		fechaMesInsertTexto = new JTextField();
		fechaMesInsertTexto.setColumns(10);
		fechaMesInsertTexto.setBounds(207, 166, 35, 22);
		panel.add(fechaMesInsertTexto);
		
		fechaAnioInsertTexo = new JTextField();
		fechaAnioInsertTexo.setColumns(10);
		fechaAnioInsertTexo.setBounds(254, 166, 56, 22);
		panel.add(fechaAnioInsertTexo);
		
		JLabel Documento_1_4_1 = new JLabel("Fecha");
		Documento_1_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_1.setBounds(160, 145, 150, 15);
		panel.add(Documento_1_4_1);
		
		JLabel Documento_1_4_1_1 = new JLabel("/");
		Documento_1_4_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_1_1.setBounds(199, 165, 16, 22);
		panel.add(Documento_1_4_1_1);
		
		Documento_1_4_1_2 = new JLabel("/");
		Documento_1_4_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_1_2.setBounds(245, 166, 16, 22);
		panel.add(Documento_1_4_1_2);
		
		panelModificacion = new JPanel();
		panelModificacion.setLayout(null);
		panelABM.addTab("Modificar", null, panelModificacion, null);
		
		documentoModificarLabel = new JLabel("Documento");
		documentoModificarLabel.setBounds(5, 5, 150, 15);
		panelModificacion.add(documentoModificarLabel);
		
		documentoModificarTexto = new JTextField();
		documentoModificarTexto.setColumns(10);
		documentoModificarTexto.setBounds(5, 25, 150, 22);
		panelModificacion.add(documentoModificarTexto);
		
		Documento_1_1_2 = new JLabel("Primer Apellido");
		Documento_1_1_2.setBounds(160, 52, 150, 15);
		panelModificacion.add(Documento_1_1_2);
		
		Documento_3 = new JLabel("Clave");
		Documento_3.setBounds(160, 5, 129, 16);
		panelModificacion.add(Documento_3);
		
		claveModificarTexto = new JTextField();
		claveModificarTexto.setColumns(10);
		claveModificarTexto.setBounds(160, 25, 150, 22);
		panelModificacion.add(claveModificarTexto);
		
		ModificarBoton = new JButton("Modificar Persona");
		ModificarBoton.setBounds(5, 193, 305, 25);
		panelModificacion.add(ModificarBoton);
		
		Documento_1_5 = new JLabel("Primer Nombre");
		Documento_1_5.setBounds(5, 52, 129, 15);
		panelModificacion.add(Documento_1_5);
		
		primerNombreModificarTexto = new JTextField();
		primerNombreModificarTexto.setColumns(10);
		primerNombreModificarTexto.setBounds(5, 72, 150, 22);
		panelModificacion.add(primerNombreModificarTexto);
		
		Documento_1_6 = new JLabel("Segundo Nombre");
		Documento_1_6.setBounds(5, 99, 150, 15);
		panelModificacion.add(Documento_1_6);
		
		segundoNombreModificarTexto = new JTextField();
		segundoNombreModificarTexto.setColumns(10);
		segundoNombreModificarTexto.setBounds(5, 119, 150, 22);
		panelModificacion.add(segundoNombreModificarTexto);
		
		Documento_1_7 = new JLabel("Correo");
		Documento_1_7.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_7.setBounds(5, 146, 150, 15);
		panelModificacion.add(Documento_1_7);
		
		correoModificarTexto = new JTextField();
		correoModificarTexto.setColumns(10);
		correoModificarTexto.setBounds(5, 166, 150, 22);
		panelModificacion.add(correoModificarTexto);
		
		Documento_1_8 = new JLabel("Segundo Apellido");
		Documento_1_8.setBounds(160, 99, 129, 15);
		panelModificacion.add(Documento_1_8);
		
		segundoApellidoModificarTexto = new JTextField();
		segundoApellidoModificarTexto.setColumns(10);
		segundoApellidoModificarTexto.setBounds(160, 119, 150, 22);
		panelModificacion.add(segundoApellidoModificarTexto);
		
		primerApellidoModificarTexto = new JTextField();
		primerApellidoModificarTexto.setColumns(10);
		primerApellidoModificarTexto.setBounds(160, 72, 150, 22);
		panelModificacion.add(primerApellidoModificarTexto);
		
		Documento_1_4_2 = new JLabel("Fecha");
		Documento_1_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_2.setBounds(160, 145, 150, 15);
		panelModificacion.add(Documento_1_4_2);
		
		fechaDiaModifTexto = new JTextField();
		fechaDiaModifTexto.setColumns(10);
		fechaDiaModifTexto.setBounds(160, 166, 35, 22);
		panelModificacion.add(fechaDiaModifTexto);
		
		Documento_1_4_1_3 = new JLabel("/");
		Documento_1_4_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_1_3.setBounds(199, 165, 16, 22);
		panelModificacion.add(Documento_1_4_1_3);
		
		fechaMesModifTexto = new JTextField();
		fechaMesModifTexto.setColumns(10);
		fechaMesModifTexto.setBounds(207, 166, 35, 22);
		panelModificacion.add(fechaMesModifTexto);
		
		Documento_1_4_1_4 = new JLabel("/");
		Documento_1_4_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_1_4.setBounds(245, 166, 16, 22);
		panelModificacion.add(Documento_1_4_1_4);
		
		fechaAnioModifTexto = new JTextField();
		fechaAnioModifTexto.setColumns(10);
		fechaAnioModifTexto.setBounds(254, 166, 56, 22);
		panelModificacion.add(fechaAnioModifTexto);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panelABM.addTab("Eliminar", null, panel_2, null);
		
		Documento_2 = new JLabel("Documento");
		Documento_2.setBounds(5, 5, 150, 15);
		panel_2.add(Documento_2);
		
		documentoEliminarTexto = new JTextField();
		documentoEliminarTexto.setEditable(false);
		documentoEliminarTexto.setColumns(10);
		documentoEliminarTexto.setBounds(5, 25, 150, 22);
		panel_2.add(documentoEliminarTexto);
		
		Documento_1_1_3 = new JLabel("Primer Apellido");
		Documento_1_1_3.setBounds(160, 52, 150, 15);
		panel_2.add(Documento_1_1_3);
		
		Documento_4 = new JLabel("Clave");
		Documento_4.setBounds(160, 5, 129, 16);
		panel_2.add(Documento_4);
		
		claveEliminarTexto = new JTextField();
		claveEliminarTexto.setEditable(false);
		claveEliminarTexto.setColumns(10);
		claveEliminarTexto.setBounds(160, 25, 150, 22);
		panel_2.add(claveEliminarTexto);
		
		EliminarBoton = new JButton("Eliminar Registro");
		EliminarBoton.setBounds(5, 193, 305, 25);
		panel_2.add(EliminarBoton);
		
		Documento_1_9 = new JLabel("Primer Nombre");
		Documento_1_9.setBounds(5, 52, 129, 15);
		panel_2.add(Documento_1_9);
		
		primerNombreEliminarTexto = new JTextField();
		primerNombreEliminarTexto.setEditable(false);
		primerNombreEliminarTexto.setColumns(10);
		primerNombreEliminarTexto.setBounds(5, 72, 150, 22);
		panel_2.add(primerNombreEliminarTexto);
		
		Documento_1_10 = new JLabel("Segundo Nombre");
		Documento_1_10.setBounds(5, 99, 150, 15);
		panel_2.add(Documento_1_10);
		
		segundoNombreEliminarTexto = new JTextField();
		segundoNombreEliminarTexto.setEditable(false);
		segundoNombreEliminarTexto.setColumns(10);
		segundoNombreEliminarTexto.setBounds(5, 119, 150, 22);
		panel_2.add(segundoNombreEliminarTexto);
		
		Documento_1_11 = new JLabel("Correo");
		Documento_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		Documento_1_11.setBounds(5, 146, 150, 15);
		panel_2.add(Documento_1_11);
		
		correoEliminarTexto = new JTextField();
		correoEliminarTexto.setEditable(false);
		correoEliminarTexto.setColumns(10);
		correoEliminarTexto.setBounds(5, 166, 150, 22);
		panel_2.add(correoEliminarTexto);
		
		Documento_1_12 = new JLabel("Segundo Apellido");
		Documento_1_12.setBounds(160, 99, 129, 15);
		panel_2.add(Documento_1_12);
		
		segundoApellidoEliminarTexto = new JTextField();
		segundoApellidoEliminarTexto.setEditable(false);
		segundoApellidoEliminarTexto.setColumns(10);
		segundoApellidoEliminarTexto.setBounds(160, 119, 150, 22);
		panel_2.add(segundoApellidoEliminarTexto);
		
		primerApellidoEliminarTexto = new JTextField();
		primerApellidoEliminarTexto.setEditable(false);
		primerApellidoEliminarTexto.setColumns(10);
		primerApellidoEliminarTexto.setBounds(160, 72, 150, 22);
		panel_2.add(primerApellidoEliminarTexto);
		
		Documento_1_4_3 = new JLabel("Fecha");
		Documento_1_4_3.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_3.setBounds(160, 146, 150, 15);
		panel_2.add(Documento_1_4_3);
		
		fechaDiaElimTexto = new JTextField();
		fechaDiaElimTexto.setEditable(false);
		fechaDiaElimTexto.setColumns(10);
		fechaDiaElimTexto.setBounds(160, 167, 35, 22);
		panel_2.add(fechaDiaElimTexto);
		
		Documento_1_4_1_5 = new JLabel("/");
		Documento_1_4_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_1_5.setBounds(199, 166, 16, 22);
		panel_2.add(Documento_1_4_1_5);
		
		fechaMesElimTexto = new JTextField();
		fechaMesElimTexto.setEditable(false);
		fechaMesElimTexto.setColumns(10);
		fechaMesElimTexto.setBounds(207, 167, 35, 22);
		panel_2.add(fechaMesElimTexto);
		
		Documento_1_4_1_6 = new JLabel("/");
		Documento_1_4_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		Documento_1_4_1_6.setBounds(245, 167, 16, 22);
		panel_2.add(Documento_1_4_1_6);
		
		fechaAnioElimTexto = new JTextField();
		fechaAnioElimTexto.setEditable(false);
		fechaAnioElimTexto.setColumns(10);
		fechaAnioElimTexto.setBounds(254, 167, 56, 22);
		panel_2.add(fechaAnioElimTexto);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panelABM.addTab("Buscar", null, panel_3, null);
		
		Documento_5 = new JLabel("Documento");
		Documento_5.setBounds(5, 5, 150, 15);
		panel_3.add(Documento_5);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(5, 25, 150, 22);
		panel_3.add(textField_8);
		
		Documento_1_1_4 = new JLabel("Primer Apellido");
		Documento_1_1_4.setBounds(160, 52, 150, 15);
		panel_3.add(Documento_1_1_4);
		
		Documento_6 = new JLabel("Clave");
		Documento_6.setBounds(160, 5, 129, 16);
		panel_3.add(Documento_6);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(160, 25, 150, 22);
		panel_3.add(textField_9);
		
		InsertarBoton_2 = new JButton("Insertar Nuevo");
		InsertarBoton_2.setBounds(5, 193, 305, 25);
		panel_3.add(InsertarBoton_2);
		
		Documento_1_13 = new JLabel("Primer Nombre");
		Documento_1_13.setBounds(5, 52, 129, 15);
		panel_3.add(Documento_1_13);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(5, 72, 150, 22);
		panel_3.add(textField_10);
		
		Documento_1_14 = new JLabel("Segundo Nombre");
		Documento_1_14.setBounds(5, 99, 150, 15);
		panel_3.add(Documento_1_14);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(5, 119, 150, 22);
		panel_3.add(textField_11);
		
		Documento_1_15 = new JLabel("Correo");
		Documento_1_15.setHorizontalAlignment(SwingConstants.CENTER);
		Documento_1_15.setBounds(5, 146, 305, 15);
		panel_3.add(Documento_1_15);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(5, 166, 305, 22);
		panel_3.add(textField_12);
		
		Documento_1_16 = new JLabel("Segundo Apellido");
		Documento_1_16.setBounds(160, 99, 129, 15);
		panel_3.add(Documento_1_16);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(160, 119, 150, 22);
		panel_3.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(160, 72, 150, 22);
		panel_3.add(textField_14);
		
		
		InsertarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persona persona = new Persona();
				persona.setDocumento(documentoInsertarTexto.getText());
				persona.setNombre1(primerNombreInsertarTexto.getText());
				persona.setNombre2(segundoNombreInsertarTexto.getText());
				persona.setApellido1(primerApellidoInsertarTexto.getText());
				persona.setApellido2(segundoApellidoInsertarTexto.getText());
				persona.setEmail(correoInsertarTexto.getText());
				persona.setClave(claveInsertarTexto.getText());
				
				String fecha = fechaAnioInsertTexo.getText() + "-" + fechaMesInsertTexto.getText() + "-" + fechaDiaInsertTexto.getText();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date date;
				try {
					date = sdf.parse(fecha);
					
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					persona.setFechaNac(sqlDate);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Error fecha a sql");
				}
				
				 
				
				DAOPersona.insert(persona);
				DAOEntidad.cargarTabla(table, DAOPersona.findAll());
				ajustesTabla();
			}
		});
		
		ModificarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persona persona = new Persona();
				persona.setDocumento(documentoModificarTexto.getText());
				persona.setNombre1(primerNombreModificarTexto.getText());
				persona.setNombre2(segundoNombreModificarTexto.getText());
				persona.setApellido1(primerApellidoModificarTexto.getText());
				persona.setApellido2(segundoApellidoModificarTexto.getText());
				persona.setEmail(correoModificarTexto.getText());
				persona.setClave(claveModificarTexto.getText());
				
				String fecha = fechaAnioModifTexto.getText() + "-" + fechaMesModifTexto.getText() + "-" + fechaDiaModifTexto.getText();

				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date date;
				try {
					date = sdf.parse(fecha);
					
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					persona.setFechaNac(sqlDate);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Error fecha a sql");
				}		
				
				DAOPersona.edit(persona);
				DAOEntidad.cargarTabla(table, DAOPersona.findAll());
				ajustesTabla();
			}
		});
		
		EliminarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOPersona.delete(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
				DAOEntidad.cargarTabla(table, DAOPersona.findAll());
				ajustesTabla();
			}
		});
	}
}
