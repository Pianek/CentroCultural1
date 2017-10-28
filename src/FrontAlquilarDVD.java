import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FrontAlquilarDVD  extends JPanel{

	Articulo articulo;
	JTable tabla;
	JButton alquilar; 
	
	public FrontAlquilarDVD() {
		alquilar = new JButton();
		tabla = rellenarTabla();
		this.add(new JScrollPane(tabla));
		tabla.setBackground(new Color (215, 232, 218));
		alquilar.setBackground(new Color (215,246,185));
	}

	public JTable rellenarTabla() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				boolean editable = false;
				if(column == 5) {
					editable = true;
				}
				return editable;
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
			modelo.addColumn("Opciones");
			
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
		
		tabla.getColumnModel().getColumn(5).setCellRenderer(new ClientsTableButtonRendererDVD());
		tabla.getColumnModel().getColumn(5).setCellEditor(new ClientsTableRendererAlquilar(new JCheckBox(), tipo));
		
		return tabla;
	}
}
 class ClientsTableButtonRendererDVD extends JButton implements TableCellRenderer {
	public ClientsTableButtonRendererDVD() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setBackground(UIManager.getColor("Button.background"));
		int stock = Integer.parseInt( table.getValueAt(row, 4).toString());
		if(stock != 0) {
			setText((value == null) ? "Alquilar" : value.toString());
		}else {
			setText((value == null) ? "No se puede alquilar" : value.toString());
		}
		return this;
	}
}
