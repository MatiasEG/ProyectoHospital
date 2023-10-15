package GUI_medicos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Users.Medico;
import Users.UsersData;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MedicoLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField campo_usuario;
	private JPasswordField campo_contrasenia;
	
	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicoLoginFrame frame = new MedicoLoginFrame();
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
	public MedicoLoginFrame() {
		setTitle("Medico login");
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
            	Medico m = UsersData.getInstance().credencialesValidasMedico(campo_usuario.getText(), String.valueOf(campo_contrasenia.getPassword()));
            	if(m!=null) {
            		try {
            			NavegacionMedico frame = new NavegacionMedico(m);
						MedicoLoginFrame.this.dispose();
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
