import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ClientsTableRendererBorrar extends DefaultCellEditor {
	
	private JButton button;
	private String label;
	private boolean clicked;
	private int row, col;
	private JTable table;
	private String tipoArticulo;
	private Conexion conexion;

	public ClientsTableRendererBorrar(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public ClientsTableRendererBorrar(JCheckBox checkBox,String tipo) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		tipoArticulo = tipo;
		conexion = new Conexion();
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.table = table;
		this.row = row;
		this.col = column;

		button.setBackground(UIManager.getColor("Button.background"));
		label = (value == null) ? ("Este " + tipoArticulo + " ya no existe.") : value.toString();
		button.setText(label);
		button.setBackground(Color.RED);
		clicked = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (clicked) {
			borrar();
			JOptionPane.showMessageDialog(button,"Borrado con �xito el " +
					tipoArticulo.toUpperCase() + " con c�digo " + table.getValueAt(row, 0));
		}
		clicked = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		clicked = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
	
	public void borrar() {
		if(tipoArticulo.equals("cd")) {
//			int id, String ti, int stock,   String cantante, String discografia
			CD cd = new CD(Integer.parseInt(table.getValueAt(row, 0).toString()), table.getValueAt(row, 1).toString(),Integer.parseInt(table.getValueAt(row, 4).toString()),
					table.getValueAt(row, 2).toString(), table.getValueAt(row, 3).toString());
//			System.out.println(cd.borrar());
			conexion.ejecutarSentencia(cd.borrar());
			
		}else if(tipoArticulo.equals("dvd")){
//			int id, String titulo, int stock, String prod, String dire
			DVD dvd = new DVD(Integer.parseInt(table.getValueAt(row, 0).toString()),table.getValueAt(row, 1).toString(),Integer.parseInt(table.getValueAt(row, 4).toString()),
					table.getValueAt(row, 3).toString(),table.getValueAt(row, 2).toString());
			conexion.ejecutarSentencia(dvd.borrar());
		}else {
//			int id, String ti, int stock, String aut, int nump, String cap
			Libro libro = new Libro(Integer.parseInt(table.getValueAt(row, 0).toString()),table.getValueAt(row, 1).toString(),Integer.parseInt(table.getValueAt(row, 5).toString()),
					table.getValueAt(row, 2).toString(),Integer.parseInt(table.getValueAt(row, 4).toString()),table.getValueAt(row, 3).toString());
			conexion.ejecutarSentencia(libro.borrar());
		}
	}
}