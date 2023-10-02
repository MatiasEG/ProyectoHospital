package GUI_administradores;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;

import Users.Medico;
import Users.Paciente;

public class Main{
    private static DefaultListModel<Medico> medicos;
    private static DefaultListModel<Paciente> pacientes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		medicos = new DefaultListModel<>();
		pacientes = new DefaultListModel<>();

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
	
	public static void agregarMedico(Medico medico) {
        medicos.add(0,medico);
    }
	
	public static DefaultListModel<Medico> listaMedicos() {
        return medicos;
    }
	
	public static void agregarPaciente(Paciente paciente) {
        pacientes.add(0,paciente);
    }
	
	public static DefaultListModel<Paciente> listaPacientes() {
        return pacientes;
    }
}
