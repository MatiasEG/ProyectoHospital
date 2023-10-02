package GUI_administradores;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Users.Medico;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificarMedico extends JFrame {

	private JPanel contentPane;
	private JTextField campo_correo;
	private JTextField campo_usuario;

	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarMedico frame = new ModificarMedico(new Medico("Pepe", "Segundo", "user_ps", "mail@mail.com", "pass"));
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
	public ModificarMedico(Medico medico) {
		setTitle("Modificar medico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_correo = new JLabel("Correo");
		label_correo.setBounds(207, 11, 187, 14);
		contentPane.add(label_correo);
		
		campo_correo = new JTextField();
		campo_correo.setColumns(10);
		campo_correo.setBounds(207, 24, 187, 20);
		campo_correo.setText(medico.getCorreo());
		contentPane.add(campo_correo);
		
		JLabel label_usuario = new JLabel("Usuario");
		label_usuario.setBounds(10, 11, 187, 14);
		contentPane.add(label_usuario);
		
		campo_usuario = new JTextField();
		campo_usuario.setColumns(10);
		campo_usuario.setBounds(10, 24, 187, 20);
		campo_usuario.setText(medico.getUsuario());
		contentPane.add(campo_usuario);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(305, 87, 89, 23);
		btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ModificarMedico.this.dispose();
            }
        });
		contentPane.add(btn_cancelar);
		
		JButton btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(207, 87, 89, 23);
		btn_guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(!campo_usuario.getText().equals(medico.getUsuario())) {
            		if(!campo_correo.getText().equals(medico.getCorreo())) {
            			if(correoValido(campo_correo.getText())) {
            				medico.setUsuario(campo_usuario.getText());
            				medico.setCorreo(campo_correo.getText());
            				JOptionPane.showMessageDialog(null, "El nombre de usuario y correo se actualizo correctamente.");
            				ModificarMedico.this.dispose();
            			}else{
            				JOptionPane.showMessageDialog(null, "El correo no es valido.");
            			}
            		}else{
            			medico.setUsuario(campo_usuario.getText());
        				JOptionPane.showMessageDialog(null, "El nombre de usuario se actualizo correctamente.");
            			ModificarMedico.this.dispose();
            		}
            	}else{
            		if(!campo_correo.getText().equals(medico.getCorreo())) {
            			if(correoValido(campo_correo.getText())) {
            				medico.setCorreo(campo_correo.getText());
            				JOptionPane.showMessageDialog(null, "El correo se actualizo correctamente.");
            				ModificarMedico.this.dispose();
            			}else{
            				JOptionPane.showMessageDialog(null, "El correo no es valido.");
            			}
            		}else{
        				JOptionPane.showMessageDialog(null, "No se realizaron cambios.");
            		}
            	}
            }
        });
		contentPane.add(btn_guardar);
	}
	
	// Función para validar el formato de un correo electrónico utilizando una expresión regular
    private boolean correoValido(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
