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
	private Usuario usuario;
	private boolean devolucionPrestamo;

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

	public ClientsTableRendererDevolver(JCheckBox checkBox, Usuario usu, boolean devolucionPrestamo) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		usuario = usu;
		conexion = new Conexion();
		this.devolucionPrestamo = devolucionPrestamo;
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
		
	}
}
