import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion{
	
	private String usuario;
	private String password;
	private String ruta;
	private Connection conn;	
	private PreparedStatement consulta;
	private ResultSet rs;
	
	public Conexion() {
		
		usuario = "root";
//		password = "gyf15614";//conexion Gemma
		password = "root";
		ruta =  "jdbc:mysql://localhost:3306/centro_cultural?useSSL=false";		 
		conn = establecerConexion();
		consulta = null;
		rs = null;
	}
		
	public PreparedStatement getConsulta() {
		return consulta;
	}

	public void setConsulta(PreparedStatement consulta) {
		this.consulta = consulta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Connection establecerConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(ruta,usuario,password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error al conectar con la BBDD");
		}
		return conn;
	}
	
	
	public boolean ejecutarSentencia(String sentencia) {
		String tipoSentencia = sentencia.substring(0,1);
		int sentenciaValida = 0;
		boolean valida = false;
		switch(tipoSentencia.toUpperCase()){
		case "I" : 
			try {
				consulta = conn.prepareStatement(sentencia);
				sentenciaValida = consulta.executeUpdate();
			} catch (SQLException e) {
				System.out.println("No se ha podido realizar inserción de datos");
			}
			break;
		case "U" :
			try {
				consulta = conn.prepareStatement(sentencia);
				sentenciaValida = consulta.executeUpdate();
			} catch (SQLException e) {
				System.out.println("No se ha podido realizar la actualización de datos");
			}
			break;
			//CREO Q NUNCA SE DA ESTE CASO
		case "S" : 
			try {
				consulta = conn.prepareStatement(sentencia);
				sentenciaValida = consulta.executeUpdate();
			} catch (SQLException e) {
				System.out.println("No se ha podido realizar la consulta");
			}
			break;
		case "D" : 
			try {
				consulta = conn.prepareStatement(sentencia);
				sentenciaValida = consulta.executeUpdate();
			} catch (SQLException e) {
				System.out.println("No se han podido eliminar los datos");
			}
			break;	
		}
		if(sentenciaValida < 0) {
			valida = true;
		}
		return valida;
	}
	
	public ResultSet getResultSet(String sentencia) {
		try {
			consulta = conn.prepareStatement(sentencia);
			rs = consulta.executeQuery(sentencia);
		} catch (SQLException e) {
			System.out.println("No se han podido obtener los datos");
			rs = null;
		}
		return rs;
	}
	
	public void cerrarConexion() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión");
		}
	}
}