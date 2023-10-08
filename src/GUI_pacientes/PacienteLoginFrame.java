package GUI_pacientes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import GUI_medicos.MainMedico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class PacienteLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField campo_usuario;
	private JPasswordField campo_contrasenia;
	private static final String username = "admin";
	private static final String password = "123";
	
	/**
	 * Launch the application.
	 */
	//TODO comment this main
	//TODO agregar pacientes hardcodeados para poder iniciar sesion
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteLoginFrame frame = new PacienteLoginFrame();
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
	public PacienteLoginFrame() {
		setTitle("Admin login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campo_usuario = new JTextField();
		campo_usuario.setBounds(10, 36, 264, 20);
		contentPane.add(campo_usuario);
		campo_usuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 11, 264, 14);
		contentPane.add(lblUsuario);
		
		campo_contrasenia = new JPasswordField();
		campo_contrasenia.setColumns(10);
		campo_contrasenia.setBounds(10, 92, 264, 20);
		contentPane.add(campo_contrasenia);
		
		JLabel label_contrasenia = new JLabel("Contraseña");
		label_contrasenia.setBounds(10, 67, 264, 14);
		contentPane.add(label_contrasenia);
		
		JButton btn_login = new JButton("Iniciar sesion");
		btn_login.setBounds(10, 123, 264, 23);
		btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(MainPaciente.validCredentials(campo_usuario.getText(), campo_contrasenia.getText())) {
            		try {
            			NavegacionPaciente frame = new NavegacionPaciente();
						PacienteLoginFrame.this.dispose();
						frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
            	}else {
            		JOptionPane.showMessageDialog(null, "Las credenciales de inicio de sesion son invalidas.");
            	}
            }
        });
		contentPane.add(btn_login);
	}
}
