package GUI_administradores;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Users.Horario;
import Users.Medico;
import Users.UsersData;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class RegistroMedico extends JFrame {
	private JPanel contentPane;
	private JTextField campo_nombre;
	private JTextField campo_apellido;
	private JTextField campo_usuario;
	private JTextField campo_correo;
	private JTextField campo_contrasenia;
	private JTextField campo_confirme_contrasenia;
	private JTextField campo_lunes;
	private JTextField campo_miercoles;
	private JTextField campo_jueves;
	private JTextField campo_martes;
	private JTextField campo_viernes;
	private JTextField campo_domingo;
	private JTextField campo_minutos;
	private JTextField campo_sabado;

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
		setBounds(100, 100, 450, 400);
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
		btn_cancelar.setBounds(318, 327, 89, 23);
		btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RegistroMedico.this.dispose();
            }
        });
		contentPane.add(btn_cancelar);
		
		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(220, 327, 89, 23);
		btn_aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(faltaCampoObligatorio()) {
            		JOptionPane.showMessageDialog(null, "Asegurese de completar todos los datos correctamente.");
            	}else {
            		if(correoValido()) {
            			if(campo_contrasenia.getText().equals(campo_confirme_contrasenia.getText())) {
            				if(horariosValidos() && minutosValidos()) {
            					Horario horarioLunes = new Horario(campo_lunes.getText(), campo_minutos.getText());
            					Horario horarioMartes = new Horario(campo_martes.getText(), campo_minutos.getText());
            					Horario horarioMiercoles = new Horario(campo_miercoles.getText(), campo_minutos.getText());
            					Horario horarioJueves = new Horario(campo_jueves.getText(), campo_minutos.getText());
            					Horario horarioViernes = new Horario(campo_viernes.getText(), campo_minutos.getText());
            					Horario horarioSabado = new Horario(campo_sabado.getText(), campo_minutos.getText());
            					Horario horarioDomingo = new Horario(campo_domingo.getText(), campo_minutos.getText());
            					
            					Horario[] horarios = {horarioLunes, horarioMartes, horarioMiercoles, horarioJueves, horarioViernes, horarioSabado, horarioDomingo};
	            				JOptionPane.showMessageDialog(null, "Medico registrado exitosamente!");
	                    		Medico medico = new Medico(campo_nombre.getText(), campo_apellido.getText(), campo_usuario.getText(), campo_correo.getText(), campo_contrasenia.getText(), horarios, campo_minutos.getText());
	                    		UsersData.getInstance().agregarMedico(medico);
	                    		NavegacionAdmin.updateLists();
	        					RegistroMedico.this.dispose();
	        				}else {
	        					JOptionPane.showMessageDialog(null, "Revise los horarios y minutos de consulta.");
	        				}
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
		
		MaskFormatter formatter_horario = null;
		MaskFormatter formatter_minutos = null;
		try {
			formatter_horario = new MaskFormatter("##-##");
			formatter_horario.setValidCharacters("0123456789");
			
			formatter_minutos = new MaskFormatter("##");
			formatter_minutos.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		campo_lunes = new JFormattedTextField(new DefaultFormatterFactory(formatter_horario));
		campo_lunes.setColumns(10);
		campo_lunes.setBounds(23, 171, 187, 20);
		contentPane.add(campo_lunes);
		
		JLabel label_lunes = new JLabel("Horario Lunes");
		label_lunes.setBounds(23, 158, 187, 14);
		contentPane.add(label_lunes);
		
		campo_miercoles = new JFormattedTextField(new DefaultFormatterFactory(formatter_horario));
		campo_miercoles.setColumns(10);
		campo_miercoles.setBounds(23, 215, 187, 20);
		contentPane.add(campo_miercoles);
		
		JLabel label_miercoles = new JLabel("Horario Miercoles");
		label_miercoles.setBounds(23, 202, 187, 14);
		contentPane.add(label_miercoles);
		
		campo_jueves = new JFormattedTextField(new DefaultFormatterFactory(formatter_horario));
		campo_jueves.setColumns(10);
		campo_jueves.setBounds(220, 215, 187, 20);
		contentPane.add(campo_jueves);
		
		JLabel label_jueves = new JLabel("Horario Jueves");
		label_jueves.setBounds(220, 202, 187, 14);
		contentPane.add(label_jueves);
		
		campo_martes = new JFormattedTextField(new DefaultFormatterFactory(formatter_horario));
		campo_martes.setColumns(10);
		campo_martes.setBounds(220, 171, 187, 20);
		contentPane.add(campo_martes);
		
		JLabel label_martes = new JLabel("Horario Martes");
		label_martes.setBounds(220, 158, 187, 14);
		contentPane.add(label_martes);
		
		campo_viernes = new JFormattedTextField(new DefaultFormatterFactory(formatter_horario));
		campo_viernes.setColumns(10);
		campo_viernes.setBounds(23, 259, 187, 20);
		contentPane.add(campo_viernes);
		
		JLabel label_viernes = new JLabel("Horario Viernes");
		label_viernes.setBounds(23, 246, 187, 14);
		contentPane.add(label_viernes);
		
		campo_domingo = new JFormattedTextField(new DefaultFormatterFactory(formatter_horario));
		campo_domingo.setColumns(10);
		campo_domingo.setBounds(23, 303, 187, 20);
		contentPane.add(campo_domingo);
		
		JLabel label_domingo = new JLabel("Horario Domingo");
		label_domingo.setBounds(23, 290, 187, 14);
		contentPane.add(label_domingo);
		
		campo_minutos = new JTextField();
		campo_minutos.setColumns(10);
		campo_minutos.setBounds(220, 303, 187, 20);
		contentPane.add(campo_minutos);
		
		JLabel label_minutos = new JLabel("Minutos de cita");
		label_minutos.setBounds(220, 290, 187, 14);
		contentPane.add(label_minutos);
		
		campo_sabado = new JFormattedTextField(new DefaultFormatterFactory(formatter_horario));
		campo_sabado.setColumns(10);
		campo_sabado.setBounds(220, 259, 187, 20);
		contentPane.add(campo_sabado);
		
		JLabel label_sabado = new JLabel("Horario Sabado");
		label_sabado.setBounds(220, 246, 187, 14);
		contentPane.add(label_sabado);
		
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
    
    private boolean horariosValidos() {
    	if(horarioDia(campo_lunes.getText()) && horarioDia(campo_martes.getText()) && horarioDia(campo_miercoles.getText()) && horarioDia(campo_jueves.getText())
    			&& horarioDia(campo_viernes.getText()) && horarioDia(campo_sabado.getText()) && horarioDia(campo_domingo.getText())) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    private boolean horarioDia(String horario) {
    	String[] parts = horario.split("-");

    	if (parts.length == 2) {
    	    try {
    	        int firstNumber = Integer.parseInt(parts[0]);
    	        int secondNumber = Integer.parseInt(parts[1]);

    	        if (firstNumber >= 0 && firstNumber <= 24 && secondNumber >= 0 && secondNumber <= 24) {
    	            // Los números están en el rango válido (0-24)
    	            // Ahora puedes compararlos con otros valores int
    	        	if(firstNumber<secondNumber) {
    	        		return true;
    	        	}else {
    	        		// Los numeros no son validos como un rango horario
    	        		return false;
    	        	}
    	        } else {
    	            // Al menos uno de los números está fuera del rango
    	        	return false;
    	        }
    	    } catch (NumberFormatException e) {
    	        // No se pudieron convertir los valores a int
    	    	return false;
    	    }
    	} else {
    	    // El formato no es correcto (no se encontró un guion "-")
    		return false;
    	}
    }
    
    private boolean minutosValidos() {
    	int minutos = Integer.parseInt(campo_minutos.getText());
    	return (minutos>10 && minutos<30);
    }
}
