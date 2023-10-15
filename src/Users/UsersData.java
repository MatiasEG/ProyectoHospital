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
		Horario horarioLunes = new Horario("09-15", "15");
		Horario horarioMartes = new Horario("09-15", "15");
		Horario horarioMiercoles = new Horario("09-15", "15");
		Horario horarioJueves = new Horario("09-15", "15");
		Horario horarioViernes = new Horario("09-15", "15");
		Horario horarioSabado = new Horario("09-15", "15");
		Horario horarioDomingo = new Horario("09-15", "15");
		Horario[] horario = new Horario[]{horarioLunes, horarioMartes, horarioMiercoles, horarioJueves, horarioViernes, horarioSabado, horarioDomingo};
		medicos.addElement(new Medico("Elton", "Tito", "titon", "titon@mail.com", "123", horario, "15"));
		
		Horario horarioLunes1 = new Horario("09-15", "15");
		Horario horarioMartes1 = new Horario("09-15", "15");
		Horario horarioMiercoles1 = new Horario("09-15", "15");
		Horario horarioJueves1 = new Horario("09-15", "15");
		Horario horarioViernes1 = new Horario("09-15", "15");
		Horario horarioSabado1 = new Horario("09-15", "15");
		Horario horarioDomingo1 = new Horario("09-15", "15");
		Horario[] horario1 = new Horario[]{horarioLunes1, horarioMartes1, horarioMiercoles1, horarioJueves1, horarioViernes1, horarioSabado1, horarioDomingo1};
		medicos.addElement(new Medico("Aitor", "Tilla", "aitor", "aitortilla@mail.com", "asd", horario1, "20"));
		
		Horario horarioLunes2 = new Horario("09-15", "15");
		Horario horarioMartes2 = new Horario("09-15", "15");
		Horario horarioMiercoles2 = new Horario("09-15", "15");
		Horario horarioJueves2 = new Horario("09-15", "15");
		Horario horarioViernes2 = new Horario("09-15", "15");
		Horario horarioSabado2 = new Horario("09-15", "15");
		Horario horarioDomingo2 = new Horario("09-15", "15");
		Horario[] horario2 = new Horario[]{horarioLunes2, horarioMartes2, horarioMiercoles2, horarioJueves2, horarioViernes2, horarioSabado2, horarioDomingo2};
		medicos.addElement(new Medico("Armando Esteban", "Kito", "kitoarmando", "esteban.kito@mail.com", "pass", horario2, "25"));
		
		Horario horarioLunes3 = new Horario("09-15", "15");
		Horario horarioMartes3 = new Horario("09-15", "15");
		Horario horarioMiercoles3 = new Horario("09-15", "15");
		Horario horarioJueves3 = new Horario("09-15", "15");
		Horario horarioViernes3 = new Horario("09-15", "15");
		Horario horarioSabado3 = new Horario("09-15", "15");
		Horario horarioDomingo3 = new Horario("09-15", "15");
		Horario[] horario3 = new Horario[]{horarioLunes3, horarioMartes3, horarioMiercoles3, horarioJueves3, horarioViernes3, horarioSabado3, horarioDomingo3};
		medicos.addElement(new Medico("Jacky", "Sieras", "sieras", "jackys@mail.com", "doc123", horario3, "10"));
		
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
