package Users;

import javax.swing.DefaultListModel;

public class Horario {
	private String rango;
	private int turnosDisponibles;
	private DefaultListModel<Paciente> turnosAgendados;
	private Medico m;
	private int dia;

	public Horario(String rango, String minutos, int dia) {
		this.rango = rango;
		turnosAgendados = new DefaultListModel<>();
		actualizarTurnosDisponibles(minutos);
		m = null;
		this.dia = dia;
	}

	public void setMedico(Medico m) {
		this.m = m;
	}
	
	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public int getTurnosDisponibles() {
		return turnosDisponibles;
	}

	public void setTurnosDisponibles(int turnosDisponibles) {
		this.turnosDisponibles = turnosDisponibles;
	}
	
	public void actualizarTurnosDisponibles(String minutos) {
		String[] horario = rango.split("-");
		int firstNumber = 0;
		int secondNumber = 0;
		
		try {
	        firstNumber = Integer.parseInt(horario[0]);
	        secondNumber = Integer.parseInt(horario[1]);

	    } catch (NumberFormatException e) {
	        // No se pudieron convertir los valores a int
	    }
        
        turnosDisponibles = (secondNumber - firstNumber) * 60 / Integer.parseInt(minutos);
        
        if(m!= null && turnosAgendados.getSize() > turnosDisponibles) {
        	int eliminar = turnosDisponibles - turnosAgendados.getSize();
        	for(int i = turnosAgendados.getSize()-1; i>=0 && eliminar!=0; i--) {
        		turnosAgendados.get(i).eliminarCitaMedico(dia, m);
        		turnosAgendados.remove(i);
        	}
        }
	}
	
	public void agendarTurno(Paciente p) {
		turnosAgendados.addElement(p);
		turnosDisponibles-=1;
	}
	
	public DefaultListModel<Paciente> getTurnosAgendados(){
		return turnosAgendados;
	}
	
	public void eliminarTurno(int i) {
		turnosAgendados.remove(i);
		turnosDisponibles+=1;
	}
	
	public Paciente getPaciente(int i) {
		return turnosAgendados.get(i);
	}
	
	public void eliminarTurnoPaciente(Paciente p) {
		for(int i=0; i<turnosAgendados.getSize(); i++) {
			if(turnosAgendados.get(i).getApellido().equals(p.getApellido()) && turnosAgendados.get(i).getNombre().equals(p.getNombre())) {
				turnosAgendados.remove(i);
				turnosDisponibles+=1;
				break;
			}
		}
	}
}
