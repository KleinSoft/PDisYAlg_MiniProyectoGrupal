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
		
		crearCalendario();
	}
	
	private void crearCalendario() {
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		
		datePicker.setBounds(315, 5, 100, 100);
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
		panelABM.setBounds(5, 310, 473, 254);
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
