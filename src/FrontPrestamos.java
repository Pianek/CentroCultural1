import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FrontPrestamos extends JFrame{
	private JPanel panelPrincipal;	
	private JButton atras;
	private JButton cerrar;
	private JTable tabla;
	private Usuario usuario;
	private String devolucionTotal;
		
	public FrontPrestamos(Usuario usu){
		
		usuario = usu;
		devolucionTotal = "";
		
		this.setTitle("Selecciona tu artículo");
		this.setSize(1000,500);	
		
		//Posiciono el JPanel
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));			
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		
		//Posiciona el panel de pestañas
		tabla = rellenarTabla();
		
		
		//Diseño panel principal
		panelPrincipal.add(new JScrollPane(tabla));
		
		atras = new JButton ("Atrás");
		atras.setBounds(1200, 502, 100, 25);
		atras.addMouseListener(new atras());
		panelPrincipal.add(atras);
		
		cerrar  = new JButton ("Cerrar Sesion");
		cerrar.setBounds(1350, 50, 135, 25);
		cerrar.addMouseListener(new atras());
		panelPrincipal.add(cerrar);
		
		add(panelPrincipal);
		panelPrincipal.setBackground(new Color (99,193,111));
		
		setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JTable rellenarTabla() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				boolean aux = false;
				if(column == 3) {
					aux = true;
				}
				return aux;
			}
        };

		try {
			Conexion conexion = new Conexion();
			ResultSet rs = conexion.getResultSet("SELECT p.idPrestamo, p.fechaPrestamo, p.fechaDevolucionTotal, count(pcd.CD_idCD) as cd, count(pdvd.DVD_idDVD) as dvd, count(plib.LIBRO_idLIBRO) as libro " + 
												 "FROM prestamo p " + 
												 "LEFT JOIN cd_has_prestamo as pcd ON (p.Usuario_idUsuario = pcd.Prestamo_Usuario_idUsuario AND p.idPrestamo = pcd.Prestamo_idPrestamo) " + 
												 "LEFT JOIN dvd_has_prestamo as pdvd ON (p.Usuario_idUsuario = pdvd.Prestamo_Usuario_idUsuario AND p.idPrestamo = pdvd.Prestamo_idPrestamo) " + 
												 "LEFT JOIN libro_has_prestamo as plib ON (p.Usuario_idUsuario = plib.Prestamo_Usuario_idUsuario AND p.idPrestamo = plib.Prestamo_idPrestamo) " + 
												 "WHERE p.Usuario_idUsuario = " + usuario.getIdUsuario() + 
												 " GROUP BY p.idPrestamo");

			// Creamos las columnas.
			modelo.addColumn("Código préstamo");
			modelo.addColumn("Fecha entrada");
			modelo.addColumn("Nº articulos");
			modelo.addColumn("Detalles");
			
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String idPrestamo = String.valueOf(rs.getInt(1));
				String fecha = rs.getString(2);
				String numeroArt = String.valueOf(rs.getInt(4) + rs.getInt(5) + rs.getInt(6));
				
				modelo.addRow(new Object[] {idPrestamo,fecha,numeroArt});
			}
			conexion.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(3).setCellRenderer(new ClientsTableButtonRendererPres());
		tabla.getColumnModel().getColumn(3).setCellEditor(new ClientsTableRendererPrestamos(new JCheckBox(), usuario));
        
		
		
		return tabla;
	}
	
	class atras extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			
			//Boton de atrás
	    	if (event.getSource() == atras){
	    		if(usuario.getPermisos().equalsIgnoreCase("ADMINISTRADOR")) {
	    			FrontAdmin frame = new FrontAdmin(usuario);
			        frame.setVisible(true);
	    		}else if(usuario.getPermisos().equalsIgnoreCase("USUARIO")){
	    			FrontUsuario frame = new FrontUsuario(usuario);
	    			frame.setVisible(true);
	    		}
	        }
	    	
	    	//Cerrar sesión
	    	if (event.getSource() == cerrar){
	    		usuario = null;
	    		FrontLogin lg = new FrontLogin();
	    		lg.setVisible(true);
	    	}
		}
	}
}

class ClientsTableButtonRendererPres extends JButton implements TableCellRenderer {
	
	public ClientsTableButtonRendererPres() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		String id = (table.getValueAt(row, 0).toString()).substring(0,1);
		if(id.equals("*")) {
			id = (table.getValueAt(row, 0).toString()).substring(1);
		}else {
			id = (table.getValueAt(row, 0).toString());
		}
		
		Conexion conexion = new Conexion();
		ResultSet devuelto = conexion.getResultSet("SELECT fechaDevolucionTotal FROM prestamo WHERE idPrestamo = " + id);
		try {
			devuelto.next();
			if(devuelto.wasNull()) {
				setBackground(UIManager.getColor("Button.background"));
				setText((value == null) ? "DEVUELTO" : value.toString());
			}else {
				setBackground(UIManager.getColor("Button.background"));
				setText((value == null) ? "Ver detalles" : value.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rsCD = conexion.getResultSet("SELECT * FROM cd_has_prestamo WHERE Prestamo_idPrestamo = " + id + " AND fechaDevolucion IS NULL;");
		ResultSet rsDVD = conexion.getResultSet("SELECT * FROM dvd_has_prestamo WHERE Prestamo_idPrestamo = " + id + " AND fechaDevolucion IS NULL;");
		ResultSet rsLIB = conexion.getResultSet("SELECT * FROM libro_has_prestamo WHERE Prestamo_idPrestamo = " + id + " AND fechaDevolucion IS NULL;");
		
		int devueltos = 0;
		try {
			while(rsCD.next()) {
				devueltos++;
			}
			while(rsDVD.next()) {
				devueltos++;
			}
			while(rsLIB.next()) {
				devueltos++;
			}
			
			if(devueltos == 0) {
				conexion.ejecutarSentencia("UPDATE prestamo SET fechaDevolucionTotal = CURDATE() WHERE idPrestamo = " + id);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return this;
	}
}
