package vista;

import java.awt.EventQueue;
import java.sql.Connection;

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
		
		JButton InsertarBoton = new JButton("Insertar Nuevo");
		InsertarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persona persona = new Persona();
				persona.setDocumento(documentoTexto.getText());
				persona.setNombre1(nombre1Texto.getText());
				persona.setNombre2(nombre2Texto.getText());
				persona.setApellido1(apellido1.getText());
				persona.setApellido2(apellido2.getText());
				persona.setEmail(correoTexto.getText());
				persona.setClave(claveTexto.getText());
				System.out.println(claveTexto.getText());
				persona.setFechaNac(java.util.Calendar.getInstance().getTime());
				
				DAOPersona.insert(persona);
			}
		});
		InsertarBoton.setBounds(5, 331, 139, 25);
		frame.getContentPane().add(InsertarBoton);
		
		documentoTexto = new JTextField();
		documentoTexto.setBounds(5, 386, 200, 22);
		frame.getContentPane().add(documentoTexto);
		documentoTexto.setColumns(10);
		
		nombre1Texto = new JTextField();
		nombre1Texto.setColumns(10);
		nombre1Texto.setBounds(5, 435, 200, 22);
		frame.getContentPane().add(nombre1Texto);
		
		nombre2Texto = new JTextField();
		nombre2Texto.setColumns(10);
		nombre2Texto.setBounds(5, 484, 200, 22);
		frame.getContentPane().add(nombre2Texto);
		
		apellido1 = new JTextField();
		apellido1.setColumns(10);
		apellido1.setBounds(220, 435, 200, 22);
		frame.getContentPane().add(apellido1);
		
		apellido2 = new JTextField();
		apellido2.setColumns(10);
		apellido2.setBounds(217, 484, 200, 22);
		frame.getContentPane().add(apellido2);
		
		correoTexto = new JTextField();
		correoTexto.setColumns(10);
		correoTexto.setBounds(5, 529, 628, 22);
		frame.getContentPane().add(correoTexto);
		
		claveTexto = new JTextField();
		claveTexto.setColumns(10);
		claveTexto.setBounds(220, 386, 200, 22);
		frame.getContentPane().add(claveTexto);
		
		JLabel Documento = new JLabel("Clave");
		Documento.setBounds(220, 369, 129, 16);
		frame.getContentPane().add(Documento);
		
		JLabel Documento_1 = new JLabel("Documento");
		Documento_1.setBounds(5, 369, 129, 16);
		frame.getContentPane().add(Documento_1);
		
		JLabel Documento_1_1 = new JLabel("Primer Nombre");
		Documento_1_1.setBounds(5, 410, 129, 16);
		frame.getContentPane().add(Documento_1_1);
		
		JLabel Documento_1_1_1 = new JLabel("Primer Apellido");
		Documento_1_1_1.setBounds(220, 410, 129, 16);
		frame.getContentPane().add(Documento_1_1_1);
		
		Documento_1_2 = new JLabel("Segundo Nombre");
		Documento_1_2.setBounds(5, 457, 129, 23);
		frame.getContentPane().add(Documento_1_2);
		
		Documento_1_3 = new JLabel("Segundo Apellido");
		Documento_1_3.setBounds(220, 455, 129, 25);
		frame.getContentPane().add(Documento_1_3);
		
		Documento_1_4 = new JLabel("Correo");
		Documento_1_4.setBounds(5, 506, 129, 23);
		frame.getContentPane().add(Documento_1_4);
	}
	
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField documentoTexto;
	private JTextField nombre1Texto;
	private JTextField nombre2Texto;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField correoTexto;
	private JTextField claveTexto;
	private JLabel Documento_1_2;
	private JLabel Documento_1_3;
	private JLabel Documento_1_4;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 877, 313);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
