package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		
		JButton btnNewButtonLogin = new JButton("Ingresar >>>");
		btnNewButtonLogin.setBounds(95, 116, 133, 56);
		panel.add(btnNewButtonLogin);
		
		JTextPane textPaneLoginEmail = new JTextPane();
		textPaneLoginEmail.setBounds(95, 57, 133, 20);
		panel.add(textPaneLoginEmail);
		
		JTextPane textPaneLoginClave = new JTextPane();
		textPaneLoginClave.setBounds(95, 86, 133, 20);
		panel.add(textPaneLoginClave);
		
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
		lblNewLabelImagenLogo.setBounds(122, 11, 77, 37);
		panel.add(lblNewLabelImagenLogo);
	}
}
