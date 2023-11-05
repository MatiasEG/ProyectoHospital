package Users;

import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.text.MaskFormatter;

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
		Medico m = new Medico("Elton", "Tito", "titon", "titon@mail.com", "123", horario, "15");
		medicos.addElement(m);
		
		Horario horarioLunes1 = new Horario("09-15", "15");
		Horario horarioMartes1 = new Horario("09-15", "15");
		Horario horarioMiercoles1 = new Horario("09-15", "15");
		Horario horarioJueves1 = new Horario("09-15", "15");
		Horario horarioViernes1 = new Horario("09-15", "15");
		Horario horarioSabado1 = new Horario("09-15", "15");
		Horario horarioDomingo1 = new Horario("09-15", "15");
		Horario[] horario1 = new Horario[]{horarioLunes1, horarioMartes1, horarioMiercoles1, horarioJueves1, horarioViernes1, horarioSabado1, horarioDomingo1};
		Medico m1 = new Medico("Aitor", "Tilla", "aitor", "aitortilla@mail.com", "asd", horario1, "20");
		medicos.addElement(m1);
		
		Horario horarioLunes2 = new Horario("09-15", "15");
		Horario horarioMartes2 = new Horario("09-15", "15");
		Horario horarioMiercoles2 = new Horario("09-15", "15");
		Horario horarioJueves2 = new Horario("09-15", "15");
		Horario horarioViernes2 = new Horario("09-15", "15");
		Horario horarioSabado2 = new Horario("09-15", "15");
		Horario horarioDomingo2 = new Horario("09-15", "15");
		Horario[] horario2 = new Horario[]{horarioLunes2, horarioMartes2, horarioMiercoles2, horarioJueves2, horarioViernes2, horarioSabado2, horarioDomingo2};
		Medico m2 = new Medico("Armando Esteban", "Kito", "kitoarmando", "esteban.kito@mail.com", "pass", horario2, "25");
		medicos.addElement(m2);
		
		Horario horarioLunes3 = new Horario("09-15", "15");
		Horario horarioMartes3 = new Horario("09-15", "15");
		Horario horarioMiercoles3 = new Horario("09-15", "15");
		Horario horarioJueves3 = new Horario("09-15", "15");
		Horario horarioViernes3 = new Horario("09-15", "15");
		Horario horarioSabado3 = new Horario("09-15", "15");
		Horario horarioDomingo3 = new Horario("09-15", "15");
		Horario[] horario3 = new Horario[]{horarioLunes3, horarioMartes3, horarioMiercoles3, horarioJueves3, horarioViernes3, horarioSabado3, horarioDomingo3};
		Medico m3 = new Medico("Jacky", "Sieras", "sieras", "jackys@mail.com", "doc123", horario3, "10");
		medicos.addElement(m3);
		
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
		
		Paciente p1 = new Paciente("Esteban", "Kito", "bankito", "bankito@mail.com", "123", alergias, diagnosticos, tratamientos, medicamentos);
		Paciente p2 = new Paciente("Lola", "Mento", "lm", "lm@mail.com", "manaos", new DefaultListModel<>(), new DefaultListModel<>(), new DefaultListModel<>(), new DefaultListModel<>());
		pacientes.addElement(p1);
		pacientes.addElement(p2);
		
		// citas -----------------------------------------------------------------------------------------------------
		horarioLunes.agendarTurno(p1);
		p1.addCita(0, m);
		
		horarioLunes.agendarTurno(p2);
		p2.addCita(0, m);
		
		horarioMiercoles.agendarTurno(p1);
		p1.addCita(2, m);
		
		horarioViernes.agendarTurno(p1);
		p1.addCita(4, m);
		
		horarioSabado.agendarTurno(p2);
		p2.addCita(5, m);
		
		horarioSabado.agendarTurno(p2);
		p2.addCita(5, m);
		
		horarioSabado.agendarTurno(p2);
		p2.addCita(5, m);
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
	
	public Medico credencialesValidasMedico(String user, String pass) {
		for(int i=0; i<medicos.size(); i++) {
			if(medicos.get(i).getUsuario().equals(user) && medicos.get(i).getContrasenia().equals(pass)) {
				return medicos.get(i);
			}
		}
		return null;
	}
	
	public Paciente credencialesValidasPaciente(String user, String pass) {
		for(int i=0; i<pacientes.size(); i++) {
			if(pacientes.get(i).getUsuario().equals(user) && pacientes.get(i).getContrasenia().equals(pass)) {
				return pacientes.get(i);
			}
		}
		return null;
	}
	
	public MaskFormatter getFormatoHorarios() {
		MaskFormatter formatter_horario = null;
		try {
			formatter_horario = new MaskFormatter("##-##");
			formatter_horario.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return formatter_horario;
	}
	
	public MaskFormatter getFormatoMinutos() {
		MaskFormatter formatter_minutos = null;
		try {
			formatter_minutos = new MaskFormatter("##");
			formatter_minutos.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return formatter_minutos;
	}
	
	public DefaultListModel<String> getNombresPacientes(DefaultListModel<Paciente> originalList) {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<originalList.size(); i++) {
			newList.addElement(originalList.getElementAt(i).getApellido()+", "+originalList.getElementAt(i).getNombre());
		}
		return newList;
	}
	
	public DefaultListModel<String> getNombresMedicos(DefaultListModel<Medico> originalList) {
		DefaultListModel<String> newList = new DefaultListModel<>();
		for(int i=0; i<originalList.size(); i++) {
			newList.addElement(originalList.getElementAt(i).getApellido()+", "+originalList.getElementAt(i).getNombre());
		}
		return newList;
	}
}
