package Users;

public class Medico{
	private String nombre;
	private String apellido;
	private String usuario;
	private String correo;
	private String contrasenia;
	
	public Medico(String nombre, String apellido, String usuario, String correo, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
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
	
}
