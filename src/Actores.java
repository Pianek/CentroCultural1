
public class Actores {
	
	public int id_actor;
	public String nombre;
	
	public Actores(int id, String nom) {
		this.id_actor = id;
		this.nombre   = nom;
	}
	
	public Actores(String nombre) {
		this.nombre=nombre;
	}

	public String crear() {
		return "INSERT INTO actores (idActores,Nombre) " + 
				"VALUES (" + this.id_actor + ", \"" + this.nombre + "\")";
	}
	
	public int getId_actor() {
		return id_actor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
