import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ClientsTableRendererPrestamos extends DefaultCellEditor {
	private JButton button;
	private String label;
	private boolean clicked;
	private int row, col;
	private JTable table;
	private String tipoArticulo;
	private Conexion conexion;
	private int stock; 
	private Usuario usuario;

	public ClientsTableRendererPrestamos(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public ClientsTableRendererPrestamos(JCheckBox checkBox, Usuario usu) {
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
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		this.table = table;
		this.row = row;
		this.col = column;

		button.setBackground(UIManager.getColor("Button.background"));
		label = (value == null) ? "Ver detalles" : value.toString();
		button.setText(label);
		
		return button;
	}

	public Object getCellEditorValue() {
		if (clicked) {
			stock = Integer.parseInt( table.getValueAt(row, 4).toString());
			detalles();
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
	
	public void detalles() {
		FrontDevolver devolver = new FrontDevolver(usuario);
		devolver.setVisible(true);
	}
}
