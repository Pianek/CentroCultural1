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

public class FrontDevolver extends JFrame{
	private JPanel panelPrincipal;	
	private JButton atras;
	private JButton cerrar;
	private JTable tablaCD;
	private JTable tablaDVD;
	private JTable tablaLIB;
	private Usuario usuario;
	private String tipoArticulo;
		
	public FrontDevolver(Usuario usu){
		
		usuario = usu;
		
		this.setTitle("Selecciona tu art�culo");
		this.setSize(1000,500);	
		
		//Posiciono el JPanel
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));			
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		
		//Posiciona el panel de pesta�as
		tablaCD = rellenarTablaCD();
		tablaDVD = rellenarTablaDVD();
		tablaLIB = rellenarTablaLIB();
		
		
		//Dise�o panel principal
		panelPrincipal.add(new JScrollPane(tablaCD));
		panelPrincipal.add(new JScrollPane(tablaDVD));
		panelPrincipal.add(new JScrollPane(tablaLIB));
		
		atras = new JButton ("Atr�s");
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
	
	public JTable rellenarTablaCD() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				return false;
			}
        };

        tipoArticulo = "cd";
        
        int numRows = 0, numDevueltos = 0;
        
		try {
			Conexion conexion = new Conexion();
			ResultSet rs = conexion.getResultSet("SELECT p.idPrestamo, pcd.fechaDevolucion, cd.* " + 
												 "FROM prestamo p " + 
												 "LEFT JOIN cd_has_prestamo as pcd ON (p.Usuario_idUsuario = pcd.Prestamo_Usuario_idUsuario " + 
												 									  "AND p.idPrestamo = pcd.Prestamo_idPrestamo) " + 
												 "LEFT JOIN cd ON (pcd.CD_idCD = cd.idCD) " + 
												 "WHERE p.Usuario_idUsuario = " + usuario.getIdUsuario() + " " +  
												 "AND cd.idCD IS NOT NULL " + 
												 "GROUP BY cd.idCD;");

			// Creamos las columnas.
			modelo.addColumn("C�digo pr�stamo");
			modelo.addColumn("T�tulo");
			modelo.addColumn("Cantante");
			modelo.addColumn("Discograf�a");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");
			
						// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String fechaDevolucion = rs.getString(2);
				String idPrestamo = String.valueOf(rs.getInt(1));
				if(!fechaDevolucion.equalsIgnoreCase("null") || !fechaDevolucion.equalsIgnoreCase("") || !fechaDevolucion.equalsIgnoreCase(" ")) {
					idPrestamo = "1" + String.valueOf(rs.getInt(1));
					numDevueltos++;
				}				
				
//				String idCD = rs.getString(3);
				String titulo = rs.getString(4);
				String cantante = rs.getString(5);
				String discografia = rs.getString(6);
				String stock = String.valueOf(rs.getInt(7));
				
				modelo.addRow(new Object[] {idPrestamo,titulo,cantante,discografia,stock});
				
				numRows++;
			}
			conexion.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tablaCD = new JTable(modelo);
		
		boolean prestamoDevuelto = false;
		if(numDevueltos == numRows) {
			prestamoDevuelto = true;
		}
		
		tablaCD.getColumnModel().getColumn(3).setCellRenderer(new ClientsTableButtonRendererPres());
		tablaCD.getColumnModel().getColumn(3).setCellEditor(new ClientsTableRendererDevolver(new JCheckBox(), usuario, prestamoDevuelto));
        
		return tablaCD;
	}
	
	public JTable rellenarTablaDVD() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				return false;
			}
        };

        tipoArticulo = "dvd";
        
        int numRows = 0, numDevueltos = 0;
        
		try {
			Conexion conexion = new Conexion();
			ResultSet rs = conexion.getResultSet("SELECT p.idPrestamo, pdvd.fechaDevolucion, dvd.* " + 
												 "FROM prestamo p " + 
												 "LEFT JOIN dvd_has_prestamo as pdvd ON (p.Usuario_idUsuario = pdvd.Prestamo_Usuario_idUsuario "
												 										+ "AND p.idPrestamo = pdvd.Prestamo_idPrestamo) " + 
												 "LEFT JOIN dvd ON (pdvd.DVD_idDVD = dvd.idDVD) " + 
												 "WHERE p.Usuario_idUsuario = " + usuario.getIdUsuario() + " " + 
												 "AND dvd.idDVD IS NOT NULL " +   
												 "GROUP BY dvd.idDVD;");

			// Creamos las columnas.
			modelo.addColumn("C�digo pr�stamo");
			modelo.addColumn("T�tulo");
			modelo.addColumn("Productora");
			modelo.addColumn("Director");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");
			
						// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String fechaDevolucion = rs.getString(2);
				String idPrestamo = String.valueOf(rs.getInt(1));
				if(!fechaDevolucion.equalsIgnoreCase("null") || !fechaDevolucion.equalsIgnoreCase("") || !fechaDevolucion.equalsIgnoreCase(" ")) {
					idPrestamo = "1" + String.valueOf(rs.getInt(1));
					numDevueltos++;
				}				
				
//				String idCD = rs.getString(3);
				String titulo = rs.getString(4);
				String productora = rs.getString(5);
				String director = rs.getString(6);
				String stock = String.valueOf(rs.getInt(7));
				
				modelo.addRow(new Object[] {idPrestamo,titulo,productora,director,stock});
				
				numRows++;
			}
			conexion.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tablaDVD = new JTable(modelo);
		
		boolean prestamoDevuelto = false;
		if(numDevueltos == numRows) {
			prestamoDevuelto = true;
		}
		
		tablaDVD.getColumnModel().getColumn(3).setCellRenderer(new ClientsTableButtonRendererPres());
		tablaDVD.getColumnModel().getColumn(3).setCellEditor(new ClientsTableRendererDevolver(new JCheckBox(), usuario, prestamoDevuelto));
        
		return tablaDVD;
	}
	
	public JTable rellenarTablaLIB() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				return false;
			}
        };

        tipoArticulo = "libro";
        
        int numRows = 0, numDevueltos = 0;
        
		try {
			Conexion conexion = new Conexion();
			ResultSet rs = conexion.getResultSet("SELECT p.idPrestamo, plib.fechaDevolucion, libro.* " + 
												 "FROM prestamo p " + 
												 "LEFT JOIN libro_has_prestamo as plib ON (p.Usuario_idUsuario = plib.Prestamo_Usuario_idUsuario "
												 										+ "AND p.idPrestamo = plib.Prestamo_idPrestamo) " + 
												 "LEFT JOIN libro ON (plib.LIBRO_idLIBRO = libro.idLIBRO) " + 
												 "WHERE p.Usuario_idUsuario = " + usuario.getIdUsuario() + " " + 
												 "AND libro.idLIBRO IS NOT NULL " + 
												 "GROUP BY libro.idLIBRO;");

			// Creamos las columnas.
			modelo.addColumn("C�digo pr�stamo");
			modelo.addColumn("T�tulo");
			modelo.addColumn("Autor");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");
			
						// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String fechaDevolucion = rs.getString(2);
				String idPrestamo = String.valueOf(rs.getInt(1));
				if(!fechaDevolucion.equalsIgnoreCase("null") || !fechaDevolucion.equalsIgnoreCase("") || !fechaDevolucion.equalsIgnoreCase(" ")) {
					idPrestamo = "*" + String.valueOf(rs.getInt(1));
					numDevueltos++;
				}				
				
//							String idCD = rs.getString(3);
				String titulo = rs.getString(4);
				String autor = rs.getString(5);
				String stock = String.valueOf(rs.getInt(7));
				
				modelo.addRow(new Object[] {idPrestamo,titulo,autor,stock});
				
				numRows++;
			}
			conexion.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tablaLIB = new JTable(modelo);
		
		boolean prestamoDevuelto = false;
		if(numDevueltos == numRows) {
			prestamoDevuelto = true;
		}
		
		tablaLIB.getColumnModel().getColumn(3).setCellRenderer(new ClientsTableButtonRendererPres());
		tablaLIB.getColumnModel().getColumn(3).setCellEditor(new ClientsTableRendererDevolver(new JCheckBox(), usuario,prestamoDevuelto));
        
		return tablaLIB;
	}
	
	class atras extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			
			//Boton de atr�s
	    	if (event.getSource() == atras){
    			FrontPrestamos frame = new FrontPrestamos(usuario);
		        frame.setVisible(true);
	        }
	    	
	    	//Cerrar sesi�n
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
		
		String devuelto = (table.getValueAt(row, column).toString()).substring(0,1);
		if(devuelto.equals("*")) {
			setBackground(UIManager.getColor("Button.background"));
			setText((value == null) ? "DEVUELTO" : value.toString());
		}else {
			setBackground(UIManager.getColor("Button.background"));
			setText((value == null) ? "Devolver" : value.toString());
		}
		
		return this;
	}
}
