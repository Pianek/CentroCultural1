
public class Usuario {

	private int idUsuario;	
	private String nombre;
	private String password;
	private String permisos;
	
	public Usuario(String nombre, String password, String permisos) {
		this.nombre = nombre;
		this.password = password;
		this.permisos = permisos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	

}
