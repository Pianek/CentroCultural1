import java.awt.Color;
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

public class FrontAlquilarCD extends JFrame{

	Articulo articulo;
	JPanel panelPrincipal;
	JTable tabla;
	JButton alquilar;
	Color colorFondo;
	
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
		panelPrincipal.setBackground(colorFondo=new Color (99,193,111));
		tabla.setBackground(colorFondo=new Color (215,246,185));
		alquilar.setBackground(colorFondo=new Color (215,246,185));
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
			modelo.addColumn("Opciones");
			
			
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
		
		tabla.getColumnModel().getColumn(5).setCellRenderer(new ClientsTableButtonRendererCD());
		tabla.getColumnModel().getColumn(5).setCellEditor(new ClientsTableRendererAlquilar(new JCheckBox(), tipo));
        
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
		int stock = Integer.parseInt( table.getValueAt(row, 4).toString());
		if(stock != 0) {
			setText((value == null) ? "Alquilar" : value.toString());
		}else {
			setText((value == null) ? "No se puede alquilar" : value.toString());
		}
		return this;
	}
}
