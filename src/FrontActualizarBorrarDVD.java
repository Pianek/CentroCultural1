import java.awt.Component;
import java.awt.GridLayout;
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

public class FrontActualizarBorrarDVD  extends JFrame{

	Articulo articulo;
	JPanel panelPrincipal;
	JTable tabla;
	JButton alquilar; 
	
	public FrontActualizarBorrarDVD() {
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
				return true;
			}
        };
		
        String tipo = "dvd";
		
		try {
			Conexion conexion = new Conexion();
			ResultSet rs = conexion.getResultSet("SELECT idDVD, titulo, director, productora, stock FROM dvd");
			// Creamos las columnas.
			modelo.addColumn("Código de DVD");
			modelo.addColumn("Título");
			modelo.addColumn("Director");
			modelo.addColumn("Productora");
			modelo.addColumn("Stock");
			modelo.addColumn("");
			modelo.addColumn("");
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String iddvd = rs.getString(1);
				String titulo = rs.getString(2);
				String director = rs.getString(3);
				String productora = rs.getString(4);
				String stock = String.valueOf(rs.getInt(5));
				
				modelo.addRow(new Object[] {iddvd,titulo,director,productora,stock});
			}
			conexion.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(5).setCellRenderer(new ClientsTableButtonRendererActualizarDVD());
		tabla.getColumnModel().getColumn(5).setCellEditor(new ClientsTableRendererActualizar(new JCheckBox(), tipo));
		
		tabla.getColumnModel().getColumn(6).setCellRenderer(new ClientsTableButtonRendererBorrarDVD());
		tabla.getColumnModel().getColumn(6).setCellEditor(new ClientsTableRendererBorrar(new JCheckBox(), tipo));
        
		return tabla;
	}
}
class ClientsTableButtonRendererActualizarDVD extends JButton implements TableCellRenderer {
	
	public ClientsTableButtonRendererActualizarDVD() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		setBackground(UIManager.getColor("Button.background"));
		setText((value == null) ? "Actualizar" : value.toString());
		return this;
	}
}
class ClientsTableButtonRendererBorrarDVD extends JButton implements TableCellRenderer {
	
	public ClientsTableButtonRendererBorrarDVD() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		setBackground(UIManager.getColor("Button.background"));
		setText((value == null) ? "Borrar" : value.toString());
		return this;
	}
}