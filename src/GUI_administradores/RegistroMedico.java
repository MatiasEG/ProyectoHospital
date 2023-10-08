package GUI_administradores;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class RegistroMedico extends JFrame {
	private JPanel contentPane;
	private JTextField campo_nombre;
	private JTextField campo_apellido;
	private JTextField campo_usuario;
	private JTextField campo_correo;
	private JTextField campo_contrasenia;
	private JTextField campo_confirme_contrasenia;

	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroMedico frame = new RegistroMedico();
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
	public RegistroMedico() {
		setTitle("Registro Medico");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campo_nombre = new JTextField();
		campo_nombre.setBounds(23, 39, 187, 20);
		contentPane.add(campo_nombre);
		campo_nombre.setColumns(10);
		
		campo_apellido = new JTextField();
		campo_apellido.setBounds(220, 39, 187, 20);
		contentPane.add(campo_apellido);
		campo_apellido.setColumns(10);
		
		JLabel label_nombre = new JLabel("Nombre/s");
		label_nombre.setBounds(23, 26, 187, 14);
		contentPane.add(label_nombre);
		
		JLabel label_apellido = new JLabel("Apellido/s");
		label_apellido.setBounds(220, 26, 187, 14);
		contentPane.add(label_apellido);
		
		JLabel label_usuario = new JLabel("Usuario");
		label_usuario.setBounds(23, 70, 187, 14);
		contentPane.add(label_usuario);
		
		campo_usuario = new JTextField();
		campo_usuario.setColumns(10);
		campo_usuario.setBounds(23, 83, 187, 20);
		contentPane.add(campo_usuario);
		
		campo_correo = new JTextField();
		campo_correo.setColumns(10);
		campo_correo.setBounds(220, 83, 187, 20);
		contentPane.add(campo_correo);
		
		JLabel label_correo = new JLabel("Correo");
		label_correo.setBounds(220, 70, 187, 14);
		contentPane.add(label_correo);
		
		JLabel label_contrasenia = new JLabel("Constraseña");
		label_contrasenia.setBounds(23, 114, 187, 14);
		contentPane.add(label_contrasenia);
		
		campo_contrasenia = new JPasswordField();
		campo_contrasenia.setColumns(10);
		campo_contrasenia.setBounds(23, 127, 187, 20);
		contentPane.add(campo_contrasenia);
		
		JLabel label_confirme_contrasenia = new JLabel("Confirme constraseña");
		label_confirme_contrasenia.setBounds(220, 114, 187, 14);
		contentPane.add(label_confirme_contrasenia);
		
		campo_confirme_contrasenia = new JPasswordField();
		campo_confirme_contrasenia.setColumns(10);
		campo_confirme_contrasenia.setBounds(220, 127, 187, 20);
		contentPane.add(campo_confirme_contrasenia);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(318, 227, 89, 23);
		btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RegistroMedico.this.dispose();
            }
        });
		contentPane.add(btn_cancelar);
		
		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(220, 227, 89, 23);
		btn_aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(faltaCampoObligatorio()) {
            		JOptionPane.showMessageDialog(null, "Asegurese de completar todos los datos correctamente.");
            	}else {
            		if(correoValido()) {
            			if(campo_contrasenia.getText().equals(campo_confirme_contrasenia.getText())) {
            				JOptionPane.showMessageDialog(null, "Medico registrado exitosamente!");
                    		Medico medico = new Medico(campo_nombre.getText(), campo_apellido.getText(), campo_usuario.getText(), campo_correo.getText(), campo_contrasenia.getText());
                    		UsersData.getInstance().agregarMedico(medico);
                    		NavegacionAdmin.updateLists();
        					RegistroMedico.this.dispose();
            			}else {
                    		JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            			}
            		}else {
                		JOptionPane.showMessageDialog(null, "El correo electronico no es valido.");
            		}
            	}
            }
        });
		contentPane.add(btn_aceptar);
		
	}
	
	// Funcion para ver si algun campo de texto obigatorio esta vacio
	private boolean faltaCampoObligatorio() {
		return campo_nombre.getText().equals("") || campo_apellido.getText().equals("") || campo_usuario.getText().equals("")
    			|| campo_correo.getText().equals("") || campo_contrasenia.getText().equals("") || campo_confirme_contrasenia.getText().equals("");
	}
	
	// Función para validar el formato de un correo electrónico utilizando una expresión regular
    private boolean correoValido() {
    	String correo = campo_correo.getText();
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
