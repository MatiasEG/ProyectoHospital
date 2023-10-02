package Users;

import java.util.List;

public class Paciente {
	private String nombre;
	private String apellido;
	private String usuario;
	private String correo;
	private String contrasenia;
	private List<String> alergias;
	private List<String> diagnosticos;
	private List<String> tratamientos;
	private List<String> medicamentos;
	
	public Paciente(String nombre, String apellido, String usuario, String correo, String contrasenia, List<String> alergias, List<String> diagnosticos, List<String> tratamientos, List<String> medicamentos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.alergias = alergias;
		this.diagnosticos = diagnosticos;
		this.medicamentos = medicamentos;
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
	public List<String> getAlergias() {
		return alergias;
	}
	public void setAlergias(List<String> alergias) {
		this.alergias = alergias;
	}
	public List<String> getDiagnosticos() {
		return diagnosticos;
	}
	public void setDiagnosticos(List<String> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}
	public List<String> getTratamientos() {
		return tratamientos;
	}
	public void setTratamientos(List<String> tratamientos) {
		this.tratamientos = tratamientos;
	}
	public List<String> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<String> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	
	
}