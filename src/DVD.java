
public class DVD extends Articulo{

	private String productora;
	private String director;
	
	public DVD (int id, String titulo, int stock, String prod, String dire) {
		super(id,titulo,stock);
		productora = prod;
		director = dire;
	}
	
	
	public String crear() {
		return "INSERT INTO dvd (idDVD,titulo, productora, director, stock) " + 
		"VALUES (" + super.getId_articulo() + ",\"" + super.getTitulo() + "\", \""
				+ this.productora + "\",\"" + this.director + "\"," + super.getStock() + ")";

	}
	
	public String borrar() {
		return "DELETE FROM dvd "+
		"WHERE idDVD ="+super.getId_articulo()+";";
	}

	public String buscar() {
		return "SELECT idDVD, titulo, productora, director, stock FROM dvd WHERE idDVD = " + this.getId_articulo();
	}
	
	public String actualizar() {
		return  "UPDATE dvd " +
				"SET " + 
					" titulo = " + super.getTitulo() + "," +
					" productora = " + this.productora + "," +
					" director = " + this.productora + "," + 
					" stock = " + super.getStock() + " " + 
				"WHERE idDVD = " + super.getId_articulo();
	}
	
	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}