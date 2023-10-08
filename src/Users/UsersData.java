package Users;

import javax.swing.DefaultListModel;

public class UsersData {
	private static UsersData instance;
	private static DefaultListModel<Medico> medicos;
    private static DefaultListModel<Paciente> pacientes;
    
    private UsersData() {
    	medicos = new DefaultListModel<>();
		pacientes = new DefaultListModel<>();

		// medicos -------------------------------------------------------------------------------------------------------
		medicos.addElement(new Medico("Elton", "Tito", "titon", "titon@mail.com", "123"));
		medicos.addElement(new Medico("Aitor", "Tilla", "aitor", "aitortilla@mail.com", "asd"));
		medicos.addElement(new Medico("Armando Esteban", "Kito", "kitoarmando", "esteban.kito@mail.com", "pass"));
		medicos.addElement(new Medico("Jacky", "Sieras", "sieras", "jackys@mail.com", "doc123"));
		
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
		pacientes.addElement(new Paciente("Lola", "Mento", "lm", "lm@mail.com", "manaos", new DefaultListModel<>(), new DefaultListModel<>(), new DefaultListModel<>(), new DefaultListModel<>()));
    }
    
    public static UsersData getInstance() {
        if (instance == null) {
            instance = new UsersData();
        }
        return instance;
    }
    
    public void agregarMedico(Medico medico) {
        medicos.add(0,medico);
    }
	
	public void eliminarMedico(int index) {
        medicos.remove(index);
    }
	
	public DefaultListModel<Medico> listaMedicos() {
        return medicos;
    }
	
	public DefaultListModel<String> listaMedicosNombre() {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<medicos.size(); i++) {
			newList.addElement(medicos.getElementAt(i).getApellido()+", "+medicos.getElementAt(i).getNombre());
		}
		return newList;
    }
	
	public void agregarPaciente(Paciente paciente) {
        pacientes.add(0,paciente);
    }
	
	public void eliminarPaciente(int index) {
        pacientes.remove(index);
    }
	
	public DefaultListModel<Paciente> listaPacientes() {
        return pacientes;
    }
	
	public DefaultListModel<String> listaPacientesNombre() {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<pacientes.size(); i++) {
			newList.addElement(pacientes.getElementAt(i).getApellido()+", "+pacientes.getElementAt(i).getNombre());
		}
		return newList;
    }
	
	public DefaultListModel<String> copyList(DefaultListModel<String> originalList) {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<originalList.size(); i++) {
			newList.addElement(originalList.getElementAt(i));
		}
		return newList;
	}
	
	public boolean validCredentials(String user, String pass) {
		for(int i=0; i<medicos.size(); i++) {
			if(medicos.get(i).getUsuario().equals(user) && medicos.get(i).getContrasenia().equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
