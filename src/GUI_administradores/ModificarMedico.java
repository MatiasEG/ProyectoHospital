package GUI_administradores;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import Users.Horario;
import Users.Medico;
import Users.UsersData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class ModificarMedico extends JFrame {

	private JPanel contentPane;
	private JTextField campo_correo;
	private JTextField campo_usuario;
	private JTextField campo_nombre;
	private JTextField campo_apellido;
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
					Horario horarioLunes = new Horario("09-15", "15");
					Horario horarioMartes = new Horario("09-15", "15");
					Horario horarioMiercoles = new Horario("09-15", "15");
					Horario horarioJueves = new Horario("09-15", "15");
					Horario horarioViernes = new Horario("09-15", "15");
					Horario horarioSabado = new Horario("09-15", "15");
					Horario horarioDomingo = new Horario("09-15", "15");
					Horario[] horario = new Horario[]{horarioLunes, horarioMartes, horarioMiercoles, horarioJueves, horarioViernes, horarioSabado, horarioDomingo};
					Medico m = new Medico("Elton", "Tito", "titon", "titon@mail.com", "123", horario, "15");
					ModificarMedico frame = new ModificarMedico(m);
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campo_nombre = new JTextField();
		campo_nombre.setBounds(23, 39, 187, 20);
		campo_nombre.setText(medico.getNombre());
		campo_nombre.setEditable(false);
		contentPane.add(campo_nombre);
		campo_nombre.setColumns(10);
		
		campo_apellido = new JTextField();
		campo_apellido.setBounds(220, 39, 187, 20);
		campo_apellido.setText(medico.getApellido());
		campo_apellido.setEditable(false);
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
		campo_usuario.setText(medico.getUsuario());
		campo_usuario.setBounds(23, 83, 187, 20);
		contentPane.add(campo_usuario);
		
		campo_correo = new JTextField();
		campo_correo.setColumns(10);
		campo_correo.setBounds(220, 83, 187, 20);
		campo_correo.setText(medico.getCorreo());
		contentPane.add(campo_correo);
		
		JLabel label_correo = new JLabel("Correo");
		label_correo.setBounds(220, 70, 187, 14);
		contentPane.add(label_correo);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(318, 327, 89, 23);
		btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ModificarMedico.this.dispose();
            }
        });
		contentPane.add(btn_cancelar);
		
		JButton btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(220, 327, 89, 23);
		btn_guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(!campo_usuario.getText().equals(medico.getUsuario()) || !campo_correo.getText().equals(medico.getCorreo())
            			|| campo_lunes.getText().equals(medico.getHorarios()[0].getRango())
            			|| campo_martes.getText().equals(medico.getHorarios()[1].getRango())
            			|| campo_miercoles.getText().equals(medico.getHorarios()[2].getRango())
            			|| campo_jueves.getText().equals(medico.getHorarios()[3].getRango())
            			|| campo_viernes.getText().equals(medico.getHorarios()[4].getRango())
            			|| campo_sabado.getText().equals(medico.getHorarios()[5].getRango())
            			|| campo_domingo.getText().equals(medico.getHorarios()[6].getRango())) {
            		
            		if(camposCompletos()) {
            			if(correoValido(campo_correo.getText())) {
            				if(horariosValidos() && minutosValidos()) {
            					Horario horarioLunes = new Horario(campo_lunes.getText(), campo_minutos.getText());
            					Horario horarioMartes = new Horario(campo_martes.getText(), campo_minutos.getText());
            					Horario horarioMiercoles = new Horario(campo_miercoles.getText(), campo_minutos.getText());
            					Horario horarioJueves = new Horario(campo_jueves.getText(), campo_minutos.getText());
            					Horario horarioViernes = new Horario(campo_viernes.getText(), campo_minutos.getText());
            					Horario horarioSabado = new Horario(campo_sabado.getText(), campo_minutos.getText());
            					Horario horarioDomingo = new Horario(campo_domingo.getText(), campo_minutos.getText());
            					
            					Horario[] horarios = {horarioLunes, horarioMartes, horarioMiercoles, horarioJueves, horarioViernes, horarioSabado, horarioDomingo};
                				
                				medico.setUsuario(campo_usuario.getText());
                				medico.setCorreo(campo_correo.getText());
                				medico.setHorarios(horarios);
                				JOptionPane.showMessageDialog(null, "Los datos del medico se actualizaron correctamente.");
                				ModificarMedico.this.dispose();
            				}else {
            					JOptionPane.showMessageDialog(null, "Revise los horarios y minutos de consulta.");
            				}
            			}else{
            				JOptionPane.showMessageDialog(null, "El correo no es valido.");
            			}
            		}else {
            			JOptionPane.showMessageDialog(null, "Complete todos los campos vacios.");
            		}
            	}else{
        			JOptionPane.showMessageDialog(null, "No se realizaron cambios para guardar.");
            	}
            }
        });
		contentPane.add(btn_guardar);
		
		campo_lunes = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoHorarios()));
		campo_lunes.setColumns(10);
		campo_lunes.setBounds(23, 171, 187, 20);
		campo_lunes.setText(medico.getHorarios()[0].getRango());
		contentPane.add(campo_lunes);
		
		JLabel label_lunes = new JLabel("Horario Lunes");
		label_lunes.setBounds(23, 158, 187, 14);
		contentPane.add(label_lunes);
		
		campo_miercoles = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoHorarios()));
		campo_miercoles.setColumns(10);
		campo_miercoles.setBounds(23, 215, 187, 20);
		campo_miercoles.setText(medico.getHorarios()[2].getRango());
		contentPane.add(campo_miercoles);
		
		JLabel label_miercoles = new JLabel("Horario Miercoles");
		label_miercoles.setBounds(23, 202, 187, 14);
		contentPane.add(label_miercoles);
		
		campo_jueves = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoHorarios()));
		campo_jueves.setColumns(10);
		campo_jueves.setBounds(220, 215, 187, 20);
		campo_jueves.setText(medico.getHorarios()[3].getRango());
		contentPane.add(campo_jueves);
		
		JLabel label_jueves = new JLabel("Horario Jueves");
		label_jueves.setBounds(220, 202, 187, 14);
		contentPane.add(label_jueves);
		
		campo_martes = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoHorarios()));
		campo_martes.setColumns(10);
		campo_martes.setBounds(220, 171, 187, 20);
		campo_martes.setText(medico.getHorarios()[1].getRango());
		contentPane.add(campo_martes);
		
		JLabel label_martes = new JLabel("Horario Martes");
		label_martes.setBounds(220, 158, 187, 14);
		contentPane.add(label_martes);
		
		campo_viernes = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoHorarios()));
		campo_viernes.setColumns(10);
		campo_viernes.setBounds(23, 259, 187, 20);
		campo_viernes.setText(medico.getHorarios()[4].getRango());
		contentPane.add(campo_viernes);
		
		JLabel label_viernes = new JLabel("Horario Viernes");
		label_viernes.setBounds(23, 246, 187, 14);
		contentPane.add(label_viernes);
		
		campo_domingo = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoHorarios()));
		campo_domingo.setColumns(10);
		campo_domingo.setBounds(23, 303, 187, 20);
		campo_domingo.setText(medico.getHorarios()[6].getRango());
		contentPane.add(campo_domingo);
		
		JLabel label_domingo = new JLabel("Horario Domingo");
		label_domingo.setBounds(23, 290, 187, 14);
		contentPane.add(label_domingo);
		
		campo_minutos = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoMinutos()));
		campo_minutos.setColumns(10);
		campo_minutos.setBounds(220, 303, 187, 20);
		campo_minutos.setText(medico.getMinutosDeCita());
		contentPane.add(campo_minutos);
		
		JLabel label_minutos = new JLabel("Minutos de cita");
		label_minutos.setBounds(220, 290, 187, 14);
		contentPane.add(label_minutos);
		
		campo_sabado = new JFormattedTextField(new DefaultFormatterFactory(UsersData.getInstance().getFormatoHorarios()));
		campo_sabado.setColumns(10);
		campo_sabado.setBounds(220, 259, 187, 20);
		campo_sabado.setText(medico.getHorarios()[5].getRango());
		contentPane.add(campo_sabado);
		
		JLabel label_sabado = new JLabel("Horario Sabado");
		label_sabado.setBounds(220, 246, 187, 14);
		contentPane.add(label_sabado);
		
		JLabel lbl_info = new JLabel("Ingrese los horarios en formato ##-## con un rango horario entre 00-24");
		lbl_info.setBounds(23, 133, 384, 14);
		contentPane.add(lbl_info);
		
	}
	
	// Función para validar el formato de un correo electrónico utilizando una expresión regular
    private boolean correoValido(String correo) {
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
    	
    	if(parts[0].equals("00") && parts[1].equals("00")) {
        	return true;
        }
    	
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
    	int minutos = 0;
    	try {
    		minutos = Integer.parseInt(campo_minutos.getText());
    	}catch(NumberFormatException e) {
    		return false;
    	}
    	return (minutos>10 && minutos<30);
    }
    
    private boolean camposCompletos() {
    	return (!campo_nombre.getText().equals("") && !campo_apellido.getText().equals("") && !campo_usuario.getText().equals("") && !campo_correo.getText().equals(""));
    }
}
