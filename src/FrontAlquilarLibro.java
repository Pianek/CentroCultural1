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

public class FrontAlquilarLibro extends JPanel{
	
	private Articulo articulo;
	private JTable tabla;
	private JButton alquilar;
	private Usuario usuario;
	
	public FrontAlquilarLibro(Usuario usu) {
		
		usuario = usu;
		
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
				if(column == 6) {
					editable = true;
				}
				return editable;
			}
        };
		
        String tipo = "libro";
		
		try {
			Conexion conexion = new Conexion();			
			ResultSet rs = conexion.getResultSet("SELECT idLIBRO, titulo, autor, capMuestra, numPagina, stock FROM libro");
			// Creamos las columnas.
			modelo.addColumn("Código Libro");
			modelo.addColumn("Título");
			modelo.addColumn("Autor");
			modelo.addColumn("Capítulo de muestra");
			modelo.addColumn("Nº páginas");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String idlibro = String.valueOf(rs.getInt(1));
				String titulo = rs.getString(2);
				String autor = rs.getString(3);
				String capMuestra = rs.getString(4);
				String numPaginas = String.valueOf(rs.getInt(5));
				String stock = String.valueOf(rs.getInt(6));
				
				modelo.addRow(new Object[] {idlibro,titulo,autor,capMuestra,numPaginas,stock});
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(6).setCellRenderer(new ClientsTableButtonRendererLibro());
		tabla.getColumnModel().getColumn(6).setCellEditor(new ClientsTableRendererAlquilar(new JCheckBox(), tipo, usuario));
		
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
		int stock = Integer.parseInt( table.getValueAt(row, 5).toString());
		if(stock != 0) {
			setText((value == null) ? "Alquilar" : value.toString());
		}else {
			setText((value == null) ? "No se puede alquilar" : value.toString());
		}
		return this;
	}
}