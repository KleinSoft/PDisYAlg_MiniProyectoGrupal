package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class VistaPrincipal {

	private JFrame frmSistemaDeVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal();
					window.frmSistemaDeVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeVentas = new JFrame();
		frmSistemaDeVentas.setBounds(100, 100, 398, 453);
		frmSistemaDeVentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeVentas.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("PERSONAS");
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaPersona vp = new VistaPersona();
				vp.mostrar();
			}
		});
		btnNewButton.setBounds(66, 82, 242, 85);
		frmSistemaDeVentas.getContentPane().add(btnNewButton);
		
		JButton btnRoles = new JButton("ROLES");
		btnRoles.setForeground(SystemColor.textHighlight);
		btnRoles.setFont(new Font("Dubai", Font.BOLD, 16));
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRol vr = new VistaRol();
				vr.mostrar();
			}
		});
		btnRoles.setBounds(66, 180, 242, 85);
		frmSistemaDeVentas.getContentPane().add(btnRoles);
		
		JButton btnNewButton_1_1 = new JButton("FUNCIONALIDADES");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaFuncionalidad vf = new VistaFuncionalidad();
				vf.mostrar();
			}
		});
		btnNewButton_1_1.setFont(new Font("Dubai", Font.BOLD, 16));
		btnNewButton_1_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1_1.setBounds(66, 278, 242, 85);
		frmSistemaDeVentas.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE VENTAS");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(86, 13, 294, 45);
		frmSistemaDeVentas.getContentPane().add(lblNewLabel);
	}
}
