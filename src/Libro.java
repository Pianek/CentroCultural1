
public class Libro extends Articulo {
	
	private String autor;
	private int numPagina;
	private String capMuestra;
	
	public Libro(int id, String ti, int stock, String aut, int nump, String cap) {
		super(id, ti, stock);
		this.autor=aut;
		this.numPagina=nump;
		this.capMuestra=cap;
	}
	
	public String actualizar() {
		return "UPDATE libro SET " + 
					" titulo = \"" + super.getTitulo() + "\"," + 
					" numPagina = " + numPagina + "," + 
					" capMuestra = \"" + capMuestra + "\"," + 
					" stock = " + super.getStock() + " " + 
				"WHERE idLibro = " + super.getId_articulo();
	}
	
	public String borrar() {
		return "DELETE FROM libro" + 
				"WHERE idLibro = " + super.getId_articulo();
	}
	
	public String crear() {
		return "INSERT INTO libro" + 
					"(idLibro, titulo, numPagina, capMuestra, stock)" + 
				"VALUES " +
					"(" + super.getId_articulo()+",\""+ super.getTitulo() +"\","+ numPagina +",\""+ capMuestra +"\","+ super.getStock() +");";
	}
	
	public String buscar() {
		return "SELECT idLibro, titulo, numPagina, capMuestra, stock FROM libro WHERE idLibro = " + this.getId_articulo();
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}

	public String getCapMuestra() {
		return capMuestra;
	}

	public void setCapMuestra(String capMuestra) {
		this.capMuestra = capMuestra;
	}
}
