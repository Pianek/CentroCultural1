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

public class FrontAlquilarLibro extends JFrame{
	Articulo articulo;
	JPanel panelPrincipal;
	JTable tabla;
	JButton alquilar; 
	
	public FrontAlquilarLibro() {
		this.setTitle("Panel Administrador");
		init();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		this.setUn decorated(true);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init() {
		panelPrincipal = new JPanel();
		/*AQUI LAS COORDENADAS PARA SITUARLO EN LAS PESTA�AS*/
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
		
        String tipo = "libro";
		
		try {
			Connection conexion = (Connection) new Conexion().establecerConexion();
			Statement s = (Statement) conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT titulo, autor, capMuestra, numPagina, stock FROM libro");
			// Creamos las columnas.
			modelo.addColumn("T�tulo");
			modelo.addColumn("Autor");
			modelo.addColumn("Cap�tulo de muestra");
			modelo.addColumn("N� p�ginas");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String titulo = rs.getString(1);
				String autor = rs.getString(2);
				String capMuestra = rs.getString(3);
				String numPaginas = String.valueOf(rs.getInt(4));
				String stock = String.valueOf(rs.getInt(5));
				
				modelo.addRow(new Object[] {titulo,autor,capMuestra,numPaginas,stock});
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(5).setCellRenderer(new ClientsTableButtonRendererLibro());
		tabla.getColumnModel().getColumn(5).setCellEditor(new ClientsTableRenderer(new JCheckBox(), tipo));
		
		return tabla;
	}
}

class ClientsTableButtonRendererLibro extends JButton implements TableCellRenderer {
	public ClientsTableButtonRendererLibro() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setBackground(UIManager.getColor("Button.background"));
		setText((value == null) ? "Alquilar" : value.toString());
		return this;
	}
}