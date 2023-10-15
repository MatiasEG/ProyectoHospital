package Users;

public class Medico{
	private String nombre;
	private String apellido;
	private String usuario;
	private String correo;
	private String contrasenia;
	private Horario[] horarios;
	private String minutosDeCita;
	
	public Medico(String nombre, String apellido, String usuario, String correo, String contrasenia, Horario[] horarios, String minutosDeCita) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.horarios = horarios;
		this.minutosDeCita = minutosDeCita;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public Horario[] getHorarios() {
		return horarios;
	}
	
	public void setHorarios(Horario[] horarios) {
		this.horarios = horarios;
	}
	
	public String getMinutosDeCita() {
		return minutosDeCita;
	}
	
	public void setMinutosDeCita(String minutosDeCita) {
		this.minutosDeCita = minutosDeCita;
		
		horarios[0].actualizarTurnosDisponibles(minutosDeCita);
		horarios[1].actualizarTurnosDisponibles(minutosDeCita);
		horarios[2].actualizarTurnosDisponibles(minutosDeCita);
		horarios[3].actualizarTurnosDisponibles(minutosDeCita);
		horarios[4].actualizarTurnosDisponibles(minutosDeCita);
		horarios[5].actualizarTurnosDisponibles(minutosDeCita);
		horarios[6].actualizarTurnosDisponibles(minutosDeCita);
		
	}
}
