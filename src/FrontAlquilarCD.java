import java.awt.Component;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class FrontAlquilarCD extends JFrame{

	Articulo articulo;
	JPanel panelPrincipal;
	JTable tabla;
	JButton alquilar;
	
	public FrontAlquilarCD() {
		this.setTitle("Panel Administrador");
		init();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init() {
		panelPrincipal = new JPanel();
		/*AQUI LAS COORDENADAS PARA SITUARLO EN LAS PESTAÑAS*/
		panelPrincipal.setBorder(new EmptyBorder(100,100,50,100));
		panelPrincipal.setLayout(new GridLayout(2,2,10,30));
		
		alquilar = new JButton();
		
		tabla = rellenarTabla();
		
		panelPrincipal.add(new JScrollPane(tabla));

		getContentPane().add(panelPrincipal);
	}
	
	public JTable rellenarTabla() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				boolean editable = false;
				if(column == 4) {
					editable = true;
				}
				return editable;
			}
        };
        modelo.fireTableDataChanged();

		try {
			Connection conexion = (Connection) new Conexion().establecerConexion();
			Statement s = (Statement) conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT titulo, cantante, discografia, stock FROM cd");
			// Creamos las columnas.
			modelo.addColumn("Título");
			modelo.addColumn("Cantante");
			modelo.addColumn("Discografia");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String titulo = rs.getString(1);
				String cantante = rs.getString(2);
				String discogradia = rs.getString(3);
				String stock = String.valueOf(rs.getInt(4));
				
				modelo.addRow(new Object[] {titulo,cantante,discogradia,stock});
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(4).setCellRenderer(new ClientsTableButtonRendererCD());
		tabla.getColumnModel().getColumn(4).setCellEditor(new ClientsTableRenderer(new JCheckBox(), articulo));
        
		return tabla;
	}
}

class ClientsTableButtonRendererCD extends JButton implements TableCellRenderer {
	
	public ClientsTableButtonRendererCD() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setBackground(UIManager.getColor("Button.background"));
		setText((value == null) ? "Alquilar" : value.toString());
		return this;
	}
}


//public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//Component c = (Component) tabla.prepareRenderer(renderer, row, column);
//if (isRowSelected(row) && isColumnSelected(column)) {
//	((JComponent) c).setBorder(new LineBorder(Color.red));
//}
//return c;
//}

//public String buscarArticulos() {
//String select = "";
//if(tipo.equalsIgnoreCase("cd")) {
//	select = "SELECT idCD, titulo, cantante, discografia, stock FROM cd";
//}else if(tipo.equalsIgnoreCase("dvd")) {
//	select = "SELECT idDVD, titulo, director, productora, stock FROM dvd";
//}else{
//	select = "SELECT idLibro, titulo, numPagina, capMuestra, stock FROM libro";
//}
//return select;
//}
//
//public int numeroAriticulos() {
//int cont = 0;
//Conexion conexion = new Conexion();
//Connection conn = (Connection) conexion.establecerConexion();
//
//try {
//	conexion.setConsulta(conn.prepareStatement(this.buscarArticulos()));
//	ResultSet rs = conexion.getConsulta().executeQuery(buscarArticulos());
//	while(rs.next()) {
//		cont++;
//	}
//} catch (SQLException e) {
//	System.out.println("Error al calcular el número de articulos");
//	e.printStackTrace();
//}
//
//return cont;
//}