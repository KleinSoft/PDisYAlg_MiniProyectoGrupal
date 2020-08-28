package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.DAOPersona;
import modelo.Persona;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VistaLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin frame = new VistaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaLogin() {
		setResizable(false);
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 324, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		


		
		JTextField textFieldLoginEmail = new JTextField();
		textFieldLoginEmail.setBounds(95, 57, 133, 20);
		panel.add(textFieldLoginEmail);
		
		JPasswordField textFieldLoginClave = new JPasswordField();
		textFieldLoginClave.setBounds(95, 86, 133, 20);
		panel.add(textFieldLoginClave);
		
		JLabel lblNewLabelEmail = new JLabel("Email");
		lblNewLabelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabelEmail.setBounds(10, 60, 81, 14);
		panel.add(lblNewLabelEmail);
		
		JLabel lblNewLabelClave = new JLabel("Contrase\u00F1a");
		lblNewLabelClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabelClave.setBounds(8, 89, 83, 14);
		panel.add(lblNewLabelClave);
		
		JLabel lblNewLabelImagenLogo = new JLabel("");
		lblNewLabelImagenLogo.setIcon(new ImageIcon(VistaLogin.class.getResource("/imagenes/KleinSoft loguito.png")));
		lblNewLabelImagenLogo.setBounds(123, 11, 77, 37);
		panel.add(lblNewLabelImagenLogo);
		
		JLabel lblNewLabelEstado = new JLabel("");
		lblNewLabelEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelEstado.setBounds(10, 183, 304, 14);
		panel.add(lblNewLabelEstado);
		
		
		JButton btnNewButtonLogin = new JButton("Ingresar >>>");
		btnNewButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		

				String errorVacio = "Al menos uno de los campos está vacio";
				String errorIncorrecto = "Email o contraseña incorrecta";

				DAOPersona logIn = new DAOPersona();
				Persona p = new Persona();

				p.setEmail(textFieldLoginEmail.getText());
				p.setClave(textFieldLoginClave.getText());

				if (!(textFieldLoginEmail.getText().isEmpty() || textFieldLoginClave.getText().isEmpty())) {

					if (logIn.login(p)) {
						VistaPrincipal vp = new VistaPrincipal(); // MOSTRAR LA VENTANA PRINCIPAL
						vp.mostrar();
						VistaLogin.this.dispose();
					}
					lblNewLabelEstado.setText(errorIncorrecto);

				} else {
					lblNewLabelEstado.setText(errorVacio);

				}

			}
		}

		);
		btnNewButtonLogin.setBounds(95, 116, 133, 56);
		panel.add(btnNewButtonLogin);
		

	}
}
