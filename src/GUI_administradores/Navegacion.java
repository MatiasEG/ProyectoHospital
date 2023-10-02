package GUI_administradores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;

public class Navegacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navegacion frame = new Navegacion();
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
	public Navegacion() {
		setTitle("Navegacion (admin)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 260);
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
		panel.setBounds(10, 70, 150, 144);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JList list_medicos = new JList(Main.listaMedicos());
		panel.add(list_medicos, BorderLayout.CENTER);
		
		JButton btn_editarMedico = new JButton("Editar datos");
		panel.add(btn_editarMedico, BorderLayout.SOUTH);
		
		JLabel label_medicosRegistrados = new JLabel("Medicos registrados");
		label_medicosRegistrados.setBounds(10, 45, 150, 14);
		contentPane.add(label_medicosRegistrados);
		
		JLabel label_pacientesRegistrados = new JLabel("Pacientes registrados");
		label_pacientesRegistrados.setBounds(174, 45, 150, 14);
		contentPane.add(label_pacientesRegistrados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(174, 70, 150, 144);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JList list_pacientes = new JList<>(Main.listaPacientes());
		panel_1.add(list_pacientes, BorderLayout.CENTER);
		
		JButton btn_editarPaciente = new JButton("Editar datos");
		panel_1.add(btn_editarPaciente, BorderLayout.SOUTH);
	}
}
