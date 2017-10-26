
public class CD extends Articulo {
	
	
	private String cantante;
	private String discografia;
	
	
	public CD(int id, String ti, int stock,   String cantante, String discografia) {
		super(id, ti, stock);			
		this.cantante = cantante;
		this.discografia = discografia;
	}
	
	public String getCantante() {
		return cantante;
	}
	
	public void setCantante(String cantante) {
		this.cantante = cantante;
	}
	
	public String getDiscografia() {
		return discografia;
	}
	
	public void setDiscografia(String discografia) {
		this.discografia = discografia;
	}
	
	public String borrar() {
		return "DELETE FROM cd" + 	
				"WHERE idCD="+super.getId_articulo()+";";
	}
	
	public String buscar() {
		return "SELECT (idCD, titulo, discografia, stock, cantante) FROM cd WEHERE idCD = " + this.getId_articulo();
	}
	
	public String actualizar() {
		return  "UPDATE cd" + 
			    "SET" + 
					"idCD = " + super.getId_articulo() + "" + 
					"titulo = \"" + super.getTitulo() + "\"," +  
					"discografia = \"" + discografia + "\"," + 
					"stock = " + super.getStock() + "," + 
					"cantante = \"" + cantante + "\"," + 
				"WEHERE idCD = " + this.getId_articulo();
	}
	
	public String crear() {
		return "INSERT INTO cd (idCD, titulo, discografia, stock, cantante)" +
				"VALUES (" + super.getId_articulo() + ",\""+super.getTitulo()+",\""+ discografia+ ",\""+super.getStock()+",\""+ cantante+",\")";
	}

}
