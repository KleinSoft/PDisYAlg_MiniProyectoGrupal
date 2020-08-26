package vista;

import java.awt.EventQueue;
import java.sql.Connection;
import java.util.Properties;

import gestorBD.*;
import modelo.Persona;
import oracle.sql.DATE;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import controlador.DAOEntidad;
import controlador.DAOPersona;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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

	/**
	 * Create the application.
	 */
	public VistaPersona() {
		initialize();
		DAOEntidad.cargarTabla(table, DAOPersona.findAll());
		
		JDatePickerImpl datePickerInsert = null;
		crearCalendario(panel, datePickerInsert);
		JDatePickerImpl datePickerModif = null;
		crearCalendario(panel_1, datePickerModif);
	}
	
	private void crearCalendario(JPanel panel, JDatePickerImpl datePicker) {
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		
		datePicker.setBounds(319, 5, 200, 26);
		panel.add(datePicker);
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
	private JPanel panel_1;
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
	private JTextField textField_6;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel Documento_2;
	private JTextField documentoEliminarTexto;
	private JLabel Documento_1_1_3;
	private JLabel Documento_4;
	private JTextField claveEliminarTexto;
	private JButton InsertarBoton_1;
	private JLabel Documento_1_9;
	private JTextField primerNombreEliminarTexto;
	private JLabel Documento_1_10;
	private JTextField segundoNombreEliminarTexto;
	private JLabel Documento_1_11;
	private JTextField textField_4;
	private JLabel Documento_1_12;
	private JTextField textField_5;
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 928, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 900, 300);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JTabbedPane panelABM = new JTabbedPane(JTabbedPane.TOP);
		panelABM.setToolTipText("");
		panelABM.setBounds(5, 310, 530, 254);
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
		Documento_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		Documento_1_4.setBounds(5, 146, 305, 15);
		panel.add(Documento_1_4);
		
		correoInsertarTexto = new JTextField();
		correoInsertarTexto.setBounds(5, 166, 305, 22);
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
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panelABM.addTab("Modificar", null, panel_1, null);
		
		documentoModificarLabel = new JLabel("Documento");
		documentoModificarLabel.setBounds(5, 5, 150, 15);
		panel_1.add(documentoModificarLabel);
		
		documentoModificarTexto = new JTextField();
		documentoModificarTexto.setColumns(10);
		documentoModificarTexto.setBounds(5, 25, 150, 22);
		panel_1.add(documentoModificarTexto);
		
		Documento_1_1_2 = new JLabel("Primer Apellido");
		Documento_1_1_2.setBounds(160, 52, 150, 15);
		panel_1.add(Documento_1_1_2);
		
		Documento_3 = new JLabel("Clave");
		Documento_3.setBounds(160, 5, 129, 16);
		panel_1.add(Documento_3);
		
		claveModificarTexto = new JTextField();
		claveModificarTexto.setColumns(10);
		claveModificarTexto.setBounds(160, 25, 150, 22);
		panel_1.add(claveModificarTexto);
		
		ModificarBoton = new JButton("Modificar Persona");
		ModificarBoton.setBounds(5, 193, 305, 25);
		panel_1.add(ModificarBoton);
		
		Documento_1_5 = new JLabel("Primer Nombre");
		Documento_1_5.setBounds(5, 52, 129, 15);
		panel_1.add(Documento_1_5);
		
		primerNombreModificarTexto = new JTextField();
		primerNombreModificarTexto.setColumns(10);
		primerNombreModificarTexto.setBounds(5, 72, 150, 22);
		panel_1.add(primerNombreModificarTexto);
		
		Documento_1_6 = new JLabel("Segundo Nombre");
		Documento_1_6.setBounds(5, 99, 150, 15);
		panel_1.add(Documento_1_6);
		
		segundoNombreModificarTexto = new JTextField();
		segundoNombreModificarTexto.setColumns(10);
		segundoNombreModificarTexto.setBounds(5, 119, 150, 22);
		panel_1.add(segundoNombreModificarTexto);
		
		Documento_1_7 = new JLabel("Correo");
		Documento_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		Documento_1_7.setBounds(5, 146, 305, 15);
		panel_1.add(Documento_1_7);
		
		correoModificarTexto = new JTextField();
		correoModificarTexto.setColumns(10);
		correoModificarTexto.setBounds(5, 166, 305, 22);
		panel_1.add(correoModificarTexto);
		
		Documento_1_8 = new JLabel("Segundo Apellido");
		Documento_1_8.setBounds(160, 99, 129, 15);
		panel_1.add(Documento_1_8);
		
		segundoApellidoModificarTexto = new JTextField();
		segundoApellidoModificarTexto.setColumns(10);
		segundoApellidoModificarTexto.setBounds(160, 119, 150, 22);
		panel_1.add(segundoApellidoModificarTexto);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(160, 72, 150, 22);
		panel_1.add(textField_6);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panelABM.addTab("Eliminar", null, panel_2, null);
		
		Documento_2 = new JLabel("Documento");
		Documento_2.setBounds(5, 5, 150, 15);
		panel_2.add(Documento_2);
		
		documentoEliminarTexto = new JTextField();
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
		claveEliminarTexto.setColumns(10);
		claveEliminarTexto.setBounds(160, 25, 150, 22);
		panel_2.add(claveEliminarTexto);
		
		InsertarBoton_1 = new JButton("Insertar Nuevo");
		InsertarBoton_1.setBounds(5, 193, 305, 25);
		panel_2.add(InsertarBoton_1);
		
		Documento_1_9 = new JLabel("Primer Nombre");
		Documento_1_9.setBounds(5, 52, 129, 15);
		panel_2.add(Documento_1_9);
		
		primerNombreEliminarTexto = new JTextField();
		primerNombreEliminarTexto.setColumns(10);
		primerNombreEliminarTexto.setBounds(5, 72, 150, 22);
		panel_2.add(primerNombreEliminarTexto);
		
		Documento_1_10 = new JLabel("Segundo Nombre");
		Documento_1_10.setBounds(5, 99, 150, 15);
		panel_2.add(Documento_1_10);
		
		segundoNombreEliminarTexto = new JTextField();
		segundoNombreEliminarTexto.setColumns(10);
		segundoNombreEliminarTexto.setBounds(5, 119, 150, 22);
		panel_2.add(segundoNombreEliminarTexto);
		
		Documento_1_11 = new JLabel("Correo");
		Documento_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		Documento_1_11.setBounds(5, 146, 305, 15);
		panel_2.add(Documento_1_11);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(5, 166, 305, 22);
		panel_2.add(textField_4);
		
		Documento_1_12 = new JLabel("Segundo Apellido");
		Documento_1_12.setBounds(160, 99, 129, 15);
		panel_2.add(Documento_1_12);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 119, 150, 22);
		panel_2.add(textField_5);
		
		primerApellidoEliminarTexto = new JTextField();
		primerApellidoEliminarTexto.setColumns(10);
		primerApellidoEliminarTexto.setBounds(160, 72, 150, 22);
		panel_2.add(primerApellidoEliminarTexto);
		
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
				System.out.println(claveInsertarTexto.getText());
				persona.setFechaNac(java.util.Calendar.getInstance().getTime());
				
				DAOPersona.insert(persona);
			}
		});
	}
}
