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

public class FrontActualizarBorrarCD extends JPanel{

	Articulo articulo;
	JTable tabla;
	JButton alquilar;
	
	public FrontActualizarBorrarCD() {
		alquilar = new JButton();
		tabla = rellenarTabla();
		this.add(new JScrollPane(tabla));
		tabla.setBackground(new Color (215,246,185));
		alquilar.setBackground(new Color (215,246,185));
	}
	
	public JTable rellenarTabla() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				return true;
			}
        };

        String tipo = "cd";
        
		try {
			Conexion conexion = new Conexion();
			ResultSet rs = conexion.getResultSet("SELECT idCD, titulo, cantante, discografia, stock FROM cd");

			// Creamos las columnas.
			modelo.addColumn("Código CD");
			modelo.addColumn("Título");
			modelo.addColumn("Cantante");
			modelo.addColumn("Discografia");
			modelo.addColumn("Stock");
			modelo.addColumn("");
			modelo.addColumn("");
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String idcd = rs.getString(1);
				String titulo = rs.getString(2);
				String cantante = rs.getString(3);
				String discografia = rs.getString(4);
				String stock = String.valueOf(rs.getInt(5));
				
				modelo.addRow(new Object[] {idcd,titulo,cantante,discografia, stock});
			}
			conexion.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(5).setCellRenderer(new ClientsTableButtonRendererActualizarCD());
		tabla.getColumnModel().getColumn(5).setCellEditor(new ClientsTableRendererActualizar(new JCheckBox(), tipo));
		
		tabla.getColumnModel().getColumn(6).setCellRenderer(new ClientsTableButtonRendererBorrarCD());
		tabla.getColumnModel().getColumn(6).setCellEditor(new ClientsTableRendererBorrar(new JCheckBox(), tipo));
        
		return tabla;
	}
}

class ClientsTableButtonRendererActualizarCD extends JButton implements TableCellRenderer {
	
	public ClientsTableButtonRendererActualizarCD() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		setBackground(UIManager.getColor("Button.background"));
		setText((value == null) ? "Actualizar" : value.toString());
		return this;
	}
}
class ClientsTableButtonRendererBorrarCD extends JButton implements TableCellRenderer {
	
	public ClientsTableButtonRendererBorrarCD() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		setBackground(UIManager.getColor("Button.background"));
		setText((value == null) ? "Borrar" : value.toString());
		return this;
	}
}