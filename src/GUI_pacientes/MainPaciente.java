package GUI_pacientes;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;

import Users.Medico;
import Users.Paciente;

public class MainPaciente{
    private static DefaultListModel<Medico> medicos;
    private static DefaultListModel<Paciente> pacientes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		medicos = new DefaultListModel<>();
		pacientes = new DefaultListModel<>();

		// medicos -------------------------------------------------------------------------------------------------------
		medicos.addElement(new Medico("ExampleName", "ExampleLastName", "example", "example@example.com", "123"));
		medicos.addElement(new Medico("Ana", "Rodríguez", "anarod", "ana.rodriguez@example.com", "P@ssw0rd1"));
		medicos.addElement(new Medico("Juan", "Pérez", "juanperez", "juan.perez@example.com", "Secure123!"));
		medicos.addElement(new Medico("María", "López", "marialo", "maria.lopez@example.com", "MyP@ssw0rd"));
		
		// pacientes -----------------------------------------------------------------------------------------------------
		DefaultListModel<String> alergias = new DefaultListModel<>();
		alergias.addElement("polen");
		DefaultListModel<String> diagnosticos = new DefaultListModel<>();
		diagnosticos.addElement("menso");
		DefaultListModel<String> tratamientos = new DefaultListModel<>();
		tratamientos.addElement("jugar 8hrsxdia");
		DefaultListModel<String> medicamentos = new DefaultListModel<>();
		medicamentos.addElement("asado");
		medicamentos.addElement("coca");
		
		pacientes.addElement(new Paciente("Esteban", "Kito", "bankito", "bankito@mail.com", "123", alergias, diagnosticos, tratamientos, medicamentos));
		pacientes.addElement(new Paciente("Lola", "Mento", "lm", "lm@mail.com", "123", new DefaultListModel<>(), new DefaultListModel<>(), new DefaultListModel<>(), new DefaultListModel<>()));

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
	
	public static void agregarMedico(Medico medico) {
        medicos.add(0,medico);
    }
	
	public static void eliminarMedico(int index) {
        medicos.remove(index);
    }
	
	public static DefaultListModel<Medico> listaMedicos() {
        return medicos;
    }
	
	public static DefaultListModel<String> listaMedicosNombre() {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<medicos.size(); i++) {
			newList.addElement(medicos.getElementAt(i).getApellido()+", "+medicos.getElementAt(i).getNombre());
		}
		return newList;
    }
	
	public static void agregarPaciente(Paciente paciente) {
        pacientes.add(0,paciente);
    }
	
	public static void eliminarPaciente(int index) {
        pacientes.remove(index);
    }
	
	public static DefaultListModel<Paciente> listaPacientes() {
        return pacientes;
    }
	
	public static DefaultListModel<String> listaPacientesNombre() {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<pacientes.size(); i++) {
			newList.addElement(pacientes.getElementAt(i).getApellido()+", "+pacientes.getElementAt(i).getNombre());
		}
		return newList;
    }
	
	public static DefaultListModel<String> copyList(DefaultListModel<String> originalList) {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<originalList.size(); i++) {
			newList.addElement(originalList.getElementAt(i));
		}
		return newList;
	}
	
	public static boolean validCredentials(String user, String pass) {
		for(int i=0; i<pacientes.size(); i++) {
			if(pacientes.get(i).getUsuario().equals(user) && pacientes.get(i).getContrasenia().equals(pass)) {
				return true;
			}
		}
		return false;
	}
}

