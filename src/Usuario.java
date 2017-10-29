
public class Usuario {

	private int idUsuario;	
	private String nombre;
	private String password;
	private String permisos;
	
	public Usuario(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
		this.permisos = "ninguno";
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
	
	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}

	public String buscarUsuario() {
		return "SELECT idUsuario, Nombre, password, permisos "
			 + "FROM usuario "
			 + "WHERE Nombre LIKE \"" + nombre + "\" AND password LIKE \"" + password + "\"";
	}
}
