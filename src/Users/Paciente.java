package Users;

import javax.swing.DefaultListModel;

public class Paciente {
	private String nombre;
	private String apellido;
	private String usuario;
	private String correo;
	private String contrasenia;
    private DefaultListModel<String> alergias;
    private DefaultListModel<String> diagnosticos;
    private DefaultListModel<String> tratamientos;
    private DefaultListModel<String> medicamentos;

	
	public Paciente(String nombre, String apellido, String usuario, String correo, String contrasenia, DefaultListModel<String> alergias, DefaultListModel<String> diagnosticos, DefaultListModel<String> tratamientos, DefaultListModel<String> medicamentos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.alergias = alergias;
		this.diagnosticos = diagnosticos;
		this.tratamientos = tratamientos;
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
	public DefaultListModel<String> getAlergias() {
		return alergias;
	}
	public void setAlergias(DefaultListModel<String> alergias) {
		this.alergias = alergias;
	}
	public DefaultListModel<String> getDiagnosticos() {
		return diagnosticos;
	}
	public void setDiagnosticos(DefaultListModel<String> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}
	public DefaultListModel<String> getTratamientos() {
		return tratamientos;
	}
	public void setTratamientos(DefaultListModel<String> tratamientos) {
		this.tratamientos = tratamientos;
	}
	public DefaultListModel<String> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(DefaultListModel<String> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	
	
}