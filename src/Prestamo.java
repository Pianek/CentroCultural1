import java.sql.ResultSet;
import java.sql.SQLException;

public class Prestamo {

	private int id_prestamo;
	private Usuario usuario;
	private Articulo articulo;
	private String fecha_reserva;
	private String fecha_devolucion; 
	
	
	public Prestamo(Usuario usu, Articulo art) {
		usuario = usu;
		articulo = art;
		id_prestamo = 0;
		fecha_reserva = "CURDATE()";
		fecha_devolucion = "NULL";
	}
	
	public int getIdPrestamo() {
		return id_prestamo;
	}

	public void setIdPrestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaReserva() {
		return fecha_reserva;
	}

	public void setFechaReserva(String fecha_reserva) {
		this.fecha_reserva = "\"" + fecha_reserva + "\"";
	}

	public String getFechaDevolucion() {
		return fecha_devolucion;
	}

	public void setFechaDevolucion(String fecha_devolucion) {
		this.fecha_devolucion = "\"" + fecha_devolucion + "\"";
	}
	
	public int crearId() {
		int id = 0;
		Conexion c = new Conexion();
		ResultSet rs = c.getResultSet("SELECT idPrestamo " + 
								 	  "FROM prestamo " + 
								 	  "WHERE fechaPrestamo = " + fecha_reserva + 
								 	  " AND Usuario_idUsuario = " + usuario.getIdUsuario());
		
			try {
				if(rs.next()) {
					id = rs.getInt(1);
				}else {
					rs = c.getResultSet("SELECT max(idPrestamo) FROM prestamo");
					rs.next();
					id = rs.getInt(1)+1;
					c.ejecutarSentencia("INSERT INTO prestamo (idPrestamo, fechaPrestamo, fechaDevolucionTotal, Usuario_idUsuario) "  
											+ "VALUES (" + id + ", CURDATE(), NULL, " + usuario.getIdUsuario() + ")");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		c.cerrarConexion();
		return id;
	}

	public String crear() {
		this.setIdPrestamo(crearId());	
		return "INSERT INTO	prestamo (idPrestamo, fechaPrestamo, fechaDevolucionTotal, Usuario_idUsuario) "+				  
				"VALUES (" + id_prestamo +","+ fecha_reserva+ ","+ fecha_devolucion+ ",\""+ usuario.getIdUsuario()+ ")\";";
		
	}
	
	public String buscar() {
		return "SELECT idPrestamo, fechaPrestamo,fechaDevolucionTotal, Usuario_idUsuario FROM prestamo";
	}

	public String actualizarStock() {
		return "UPDATE " + articulo.getTipo() + "SET stock = " + articulo.getStock() + "WHERE id" + articulo.getTipo().toUpperCase() + " = " + articulo.getId_articulo();
	}
	
	public String anadirArticuloPres() {
		this.setIdPrestamo(crearId());	
		return "INSERT INTO " + articulo.getTipo() + "_has_prestamo "
				+ "(" + articulo.getTipo().toUpperCase() + "_id" + articulo.getTipo().toUpperCase() + ", Prestamo_idPrestamo, Prestamo_Usuario_idUsuario, fechaDevolucion) "
				+ " VALUES (" + articulo.getId_articulo() + "," + this.id_prestamo + "," + this.usuario.getIdUsuario() + "," + this.fecha_devolucion + ");";
	}
	
	public String devolverArticuloPres() {
		this.setIdPrestamo(crearId());	
		articulo.setStock(articulo.getStock()+1);
		return "UPDATE " + articulo.getTipo() + "_has_prestamo "
				+ "SET fechaDevolucion = CURDATE() "  
				+ " WHERE "		
				+ articulo.getTipo().toUpperCase() + "_id" + articulo.getTipo().toUpperCase() + " = " + articulo.getId_articulo() 
				+ " Prestamo_idPrestamo = " + this.id_prestamo 
				+ " Prestamo_Usuario_idUsuario = " + this.usuario.getIdUsuario();
	}
}
