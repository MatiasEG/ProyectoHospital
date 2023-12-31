package GUI_administradores;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AdminLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField campo_usuario;
	private JPasswordField campo_contrasenia;
	private static final String username = "admin";
	private static final String password = "123";
	
	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
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
            	if(campo_usuario.getText().equals(username) && String.valueOf(campo_contrasenia.getPassword()).equals(password)) {
            		try {
            			NavegacionAdmin frame = new NavegacionAdmin();
						AdminLoginFrame.this.dispose();
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
