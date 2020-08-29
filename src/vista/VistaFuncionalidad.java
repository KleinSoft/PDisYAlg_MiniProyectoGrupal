package vista;

import java.awt.EventQueue;

import modelo.Funcionalidad;
import modelo.Persona;
import modelo.Rol;

import javax.swing.JFrame;

import controlador.DAOEntidad;
import controlador.DAOFuncionalidad;
import controlador.DAOPersona;
import controlador.DAORol;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;

public class VistaFuncionalidad {

	private JFrame frmFuncionalidades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaFuncionalidad window = new VistaFuncionalidad();
					window.frmFuncionalidades.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaFuncionalidad() {
		initialize();
		frmFuncionalidades.setLocationRelativeTo(null);
		cargarDatos();
	}
	

	
	private void cargarDatos() {
		try {
			DAOEntidad.cargarTabla(table, DAOFuncionalidad.findAll());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	
	private ArrayList<Rol> roles;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField documentoInsertarTexto;
	private JTextField primerNombreInsertarTexto;
	private JPanel panelModificacion;
	private JLabel documentoModificarLabel;
	private JTextField documentoModificarTexto;
	private JButton ModificarBoton;
	private JLabel Documento_1_5;
	private JTextField primerNombreModificarTexto;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel Documento_2;
	private JTextField documentoEliminarTexto;
	private JButton EliminarBoton;
	private JLabel Documento_1_9;
	private JTextField primerNombreEliminarTexto;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFuncionalidades = new JFrame();
		frmFuncionalidades.setTitle("Funcionalidades");
		frmFuncionalidades.setBounds(100, 100, 1323, 373);
		frmFuncionalidades.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFuncionalidades.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 961, 315);
		frmFuncionalidades.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
	        	try {
			    	if (!lse.getValueIsAdjusting()) {
			        	// Carga a valores de modificacion
			            documentoModificarTexto.setText(""+table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			            primerNombreModificarTexto.setText(""+table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
			            
			            //Carga a valores de baja
			            documentoEliminarTexto.setText(""+table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			            primerNombreEliminarTexto.setText(""+table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
			            
			        }
				} catch (Exception e) {
					// TODO: handle exception
				}
		    }
		});
		scrollPane.setViewportView(table);
		JTabbedPane panelABM = new JTabbedPane(JTabbedPane.TOP);
		panelABM.setToolTipText("");
		panelABM.setBounds(978, 5, 322, 281);
		frmFuncionalidades.getContentPane().add(panelABM);
		
		panel = new JPanel();
		panelABM.addTab("Insertar", null, panel, null);
		panel.setLayout(null);
		
		JLabel Documento_1 = new JLabel("Nombre");
		Documento_1.setBounds(5, 5, 150, 15);
		panel.add(Documento_1);
		
		documentoInsertarTexto = new JTextField();
		documentoInsertarTexto.setBounds(5, 25, 305, 22);
		panel.add(documentoInsertarTexto);
		documentoInsertarTexto.setColumns(10);
		
		JButton InsertarBoton = new JButton("Insertar");
		InsertarBoton.setBounds(5, 220, 305, 25);
		panel.add(InsertarBoton);
		
		JLabel Documento_1_1 = new JLabel("Descripci\u00F3n");
		Documento_1_1.setBounds(5, 52, 129, 15);
		panel.add(Documento_1_1);
		
		primerNombreInsertarTexto = new JTextField();
		primerNombreInsertarTexto.setBounds(5, 72, 300, 22);
		panel.add(primerNombreInsertarTexto);
		primerNombreInsertarTexto.setColumns(10);
		
		panelModificacion = new JPanel();
		panelModificacion.setLayout(null);
		panelABM.addTab("Modificar", null, panelModificacion, null);
		
		documentoModificarLabel = new JLabel("Nombre");
		documentoModificarLabel.setBounds(5, 5, 150, 15);
		panelModificacion.add(documentoModificarLabel);
		
		documentoModificarTexto = new JTextField();
		documentoModificarTexto.setColumns(10);
		documentoModificarTexto.setBounds(5, 25, 305, 22);
		panelModificacion.add(documentoModificarTexto);
		
		ModificarBoton = new JButton("Modificar Funcionalidad");
		ModificarBoton.setBounds(5, 220, 305, 25);
		panelModificacion.add(ModificarBoton);
		
		Documento_1_5 = new JLabel("Descripci\u00F3n");
		Documento_1_5.setBounds(5, 52, 129, 15);
		panelModificacion.add(Documento_1_5);
		
		primerNombreModificarTexto = new JTextField();
		primerNombreModificarTexto.setColumns(10);
		primerNombreModificarTexto.setBounds(5, 72, 305, 22);
		panelModificacion.add(primerNombreModificarTexto);
		
		ModificarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionalidad funcionalidad = new Funcionalidad();
				funcionalidad.setId(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
				funcionalidad.setNombre(documentoModificarTexto.getText());
				funcionalidad.setDescripcion(primerNombreModificarTexto.getText());
								
				DAOFuncionalidad.edit(funcionalidad);
				cargarDatos();
			}
		});
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panelABM.addTab("Eliminar", null, panel_2, null);
		
		Documento_2 = new JLabel("Nombre");
		Documento_2.setBounds(5, 5, 150, 15);
		panel_2.add(Documento_2);
		
		documentoEliminarTexto = new JTextField();
		documentoEliminarTexto.setEditable(false);
		documentoEliminarTexto.setColumns(10);
		documentoEliminarTexto.setBounds(5, 25, 305, 22);
		panel_2.add(documentoEliminarTexto);
		
		EliminarBoton = new JButton("Eliminar Registro");
		EliminarBoton.setBounds(5, 220, 305, 25);
		panel_2.add(EliminarBoton);
		
		Documento_1_9 = new JLabel("Descripci\u00F3n");
		Documento_1_9.setBounds(5, 52, 129, 15);
		panel_2.add(Documento_1_9);
		
		primerNombreEliminarTexto = new JTextField();
		primerNombreEliminarTexto.setEditable(false);
		primerNombreEliminarTexto.setColumns(10);
		primerNombreEliminarTexto.setBounds(5, 72, 305, 22);
		panel_2.add(primerNombreEliminarTexto);
		
		EliminarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOFuncionalidad.delete(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
				cargarDatos();
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrincipal vp = new VistaPrincipal();
				vp.mostrar();
				frmFuncionalidades.setVisible(false);
			}
		});
		btnAtras.setBounds(978, 295, 322, 25);
		frmFuncionalidades.getContentPane().add(btnAtras);
		
		
		InsertarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionalidad funcionalidad = new Funcionalidad();
				funcionalidad.setNombre(documentoInsertarTexto.getText());
				funcionalidad.setDescripcion(primerNombreInsertarTexto.getText());
				
				DAOFuncionalidad.insert(funcionalidad);
				cargarDatos();
			}
		});
	}

	public void mostrar() {
		frmFuncionalidades.setVisible(true);
	}
}
