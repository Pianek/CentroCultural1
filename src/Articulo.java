public class Articulo {
	
	private int id_articulo;
	private String titulo;
	private int stock;
	private String tipo;
	
	public Articulo(int id, String ti, int stock) {
		this.id_articulo=id;
		this.titulo=ti;
		this.stock=stock;
		this.tipo = "";
	}
	public Articulo(String titulo, int stock) {
		this.titulo=titulo;
		this.stock=stock;
	}
	
	public String getTipo() {
		String aux = "";
		char id = String.valueOf(id_articulo).charAt(0);
		switch(id) {
		case '1':
			aux = "cd";
		break;	
		case '2':
			aux = "dvd";
		break;
		case '3':
			aux = "libro";
		break;
		}
		return aux;
	}
	
	public int getId_articulo() {
		return id_articulo;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
