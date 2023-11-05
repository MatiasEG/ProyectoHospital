package Users;

import javax.swing.DefaultListModel;

public class Horario {
	private String rango;
	private int turnosDisponibles;
	private DefaultListModel<Paciente> turnosAgendados;

	public Horario(String rango, String minutos) {
		this.rango = rango;
		turnosAgendados = new DefaultListModel<>();
		actualizarTurnosDisponibles(minutos);
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
	
	public void eliminarTurnoPaciente(Paciente p) {
		for(int i=0; i<turnosAgendados.getSize(); i++) {
			if(turnosAgendados.get(i).getApellido().equals(p.getApellido()) && turnosAgendados.get(i).getNombre().equals(p.getNombre())) {
				turnosAgendados.remove(i);
				turnosDisponibles+=1;
			}
		}
	}
}
