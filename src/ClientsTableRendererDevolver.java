import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ClientsTableRendererDevolver extends DefaultCellEditor {
	private JButton button;
	private String label;
	private boolean clicked;
	private int row, col;
	private JTable table;
	private Conexion conexion;
	private String tipo;

	public ClientsTableRendererDevolver(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public ClientsTableRendererDevolver(JCheckBox checkBox, String tipoArticulo) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		conexion = new Conexion();
		tipo = tipoArticulo;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.table = table;
		this.row = row;
		this.col = column;

		button.setBackground(UIManager.getColor("Button.background"));
		label = (value == null) ? "DEVUELTO" : value.toString();
		button.setText(label);
		
		return button;
	}

	public Object getCellEditorValue() {
		if (clicked) {
			devolver();
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
	
	public void devolver() {
		int stock = 0;

		String id = (table.getValueAt(row, 0).toString()).substring(0,1);
		if(id.equals("*")) {
			id = (table.getValueAt(row, 0).toString()).substring(1);
		}else {
			id = (table.getValueAt(row, 0).toString());
		}
		
		table.setValueAt(table.getValueAt(row, col), row, col);
		
		conexion.ejecutarSentencia("INSERT INTO " + tipo.toLowerCase() + "_has_prestamo (fechaDevolucion) VALUES (CURDATE());");
		
		if(tipo.equals("libro")) {
			stock = Integer.parseInt( table.getValueAt(row, 3).toString());
		}else {
			stock = Integer.parseInt( table.getValueAt(row, 4).toString());
		}
		
		conexion.ejecutarSentencia("UPDATE tipo SET stock = " + stock+1 +" WHERE id" + tipo.toUpperCase() + " = " + id);
	}
}



















