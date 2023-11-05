package GUI_administradores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI_medicos.VisualizadorDeCitasMedico;
import GUI_pacientes.CitasPendientes;
import Users.Medico;
import Users.Paciente;
import Users.UsersData;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class NavegacionAdmin extends JFrame {

	private JPanel contentPane;
	private static JList<String> list_medicos;
	private static JList<String> list_pacientes;
	private static JScrollPane scrollPane_pacientes;
	private static JScrollPane scrollPane_medicos;

	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavegacionAdmin frame = new NavegacionAdmin();
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
	public NavegacionAdmin() {
		setTitle("Navegacion (admin)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_registroMedico = new JButton("Registrar medico");
		btn_registroMedico.setBounds(10, 11, 150, 23);
		btn_registroMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					RegistroMedico frame = new RegistroMedico();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
		contentPane.add(btn_registroMedico);
		
		JButton btn_registroPaciente = new JButton("Registrar paciente");
		btn_registroPaciente.setBounds(174, 11, 150, 23);
		btn_registroPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					RegistroPaciente frame = new RegistroPaciente();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
		contentPane.add(btn_registroPaciente);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 70, 150, 207);
		contentPane.add(panel);
		
		JButton btn_editarMedico = new JButton("Editar datos");
		btn_editarMedico.setBounds(0, 132, 150, 23);
		btn_editarMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_medicos.getSelectedIndex();
                if (selectedIndex != -1) {
                	try {
    					ModificarMedico frame = new ModificarMedico(UsersData.getInstance().listaMedicos().get(selectedIndex));
    					frame.setVisible(true);
    				} catch (Exception e1) {
    					e1.printStackTrace();
    				}
                }
            }
        });
		panel.setLayout(null);
		panel.add(btn_editarMedico);
		
		scrollPane_medicos = new JScrollPane();
		scrollPane_medicos.setBounds(0, 0, 150, 130);
		panel.add(scrollPane_medicos);
		
		list_medicos = new JList<>(UsersData.getInstance().listaMedicosNombre());
		scrollPane_medicos.setViewportView(list_medicos);
		
		JButton btn_verCitasMedico = new JButton("Ver citas");
		btn_verCitasMedico.setBounds(0, 157, 150, 23);
		btn_verCitasMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_medicos.getSelectedIndex();
                if (selectedIndex != -1) {
                	Medico m = UsersData.getInstance().listaMedicos().get(selectedIndex);
                	VisualizadorDeCitasMedico frame = new VisualizadorDeCitasMedico(m);
    				frame.setVisible(true);
                }
            }
        });
		panel.add(btn_verCitasMedico);
		
		JButton btn_eliminarMedico = new JButton("Eliminar");
		btn_eliminarMedico.setBounds(0, 183, 150, 23);
		panel.add(btn_eliminarMedico);
		btn_eliminarMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_medicos.getSelectedIndex();
                if (selectedIndex != -1) {
                	Medico m = UsersData.getInstance().listaMedicos().get(selectedIndex);
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar al medico "+m.getNombre()+" "+m.getApellido()+"?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
	                	UsersData.getInstance().eliminarMedico(selectedIndex);
	                	list_medicos = new JList<>(UsersData.getInstance().listaMedicosNombre());
	                	scrollPane_medicos.setViewportView(list_medicos);
	                }
                }
            }
        });
		
		JLabel label_medicosRegistrados = new JLabel("Medicos registrados");
		label_medicosRegistrados.setBounds(10, 45, 150, 14);
		contentPane.add(label_medicosRegistrados);
		
		JLabel label_pacientesRegistrados = new JLabel("Pacientes registrados");
		label_pacientesRegistrados.setBounds(174, 45, 150, 14);
		contentPane.add(label_pacientesRegistrados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(174, 70, 150, 207);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_editarPaciente = new JButton("Editar datos");
		btn_editarPaciente.setBounds(0, 132, 150, 23);
		btn_editarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_pacientes.getSelectedIndex();
                if (selectedIndex != -1) {
                	try {
    					ModificarPaciente frame = new ModificarPaciente(UsersData.getInstance().listaPacientes().get(selectedIndex));
    					frame.setVisible(true);
    				} catch (Exception e1) {
    					e1.printStackTrace();
    				}
                }
            }
        });
		panel_1.add(btn_editarPaciente);
		
		scrollPane_pacientes = new JScrollPane();
		scrollPane_pacientes.setBounds(0, 0, 150, 130);
		panel_1.add(scrollPane_pacientes);
		
		list_pacientes = new JList<>(UsersData.getInstance().listaPacientesNombre());
		scrollPane_pacientes.setViewportView(list_pacientes);
		
		JButton btn_eliminarPaciente = new JButton("Eliminar");
		btn_eliminarPaciente.setBounds(0, 183, 150, 23);
		btn_eliminarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_pacientes.getSelectedIndex();
                if (selectedIndex != -1) {
                	Paciente p = UsersData.getInstance().listaPacientes().get(selectedIndex);
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar al paciente "+p.getNombre()+" "+p.getApellido()+"?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
	                	UsersData.getInstance().eliminarPaciente(selectedIndex);
	                	list_pacientes = new JList<>(UsersData.getInstance().listaPacientesNombre());
	            		scrollPane_pacientes.setViewportView(list_pacientes);
	            	}
                }
            }
        });
		panel_1.add(btn_eliminarPaciente);
		
		JButton btn_verCitasPaciente = new JButton("Ver citas");
		btn_verCitasPaciente.setBounds(0, 157, 150, 23);
		btn_verCitasPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_pacientes.getSelectedIndex();
                if (selectedIndex != -1) {
                	Paciente p = UsersData.getInstance().listaPacientes().get(selectedIndex);
                	CitasPendientes frame = new CitasPendientes(p);
    				frame.setVisible(true);
                }
            }
        });
		panel_1.add(btn_verCitasPaciente);
	}

	public static void updateLists() {
		list_pacientes = new JList<>(UsersData.getInstance().listaPacientesNombre());
		scrollPane_pacientes.setViewportView(list_pacientes);
	
		list_medicos = new JList<>(UsersData.getInstance().listaMedicosNombre());
		scrollPane_medicos.setViewportView(list_medicos);

	}
}
