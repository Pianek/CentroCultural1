import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ClientsTableRenderer extends DefaultCellEditor {
	
	private JButton button;
	private String label;
	private boolean clicked;
	private int row, col;
	private JTable table;
	private Articulo articulo;

	public ClientsTableRenderer(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public ClientsTableRenderer(JCheckBox checkBox, Articulo art) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		articulo = art;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		this.table = table;
		this.row = row;
		this.col = column;

		button.setBackground(UIManager.getColor("Button.background"));
		label = (value == null) ? "Alquilado" : value.toString();
		button.setText(label);
		clicked = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (clicked) {
			alquilar(articulo);
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
	
	public void alquilar(Articulo a) {
		try {
			Connection conexion = (Connection) new Conexion().establecerConexion();
			Statement s = (Statement) conexion.createStatement();
			
			if(a.getTipo().equalsIgnoreCase("cd")) {
				s.executeQuery("UPDATE cd SET stock = " + (a.getStock()-1) + " WHERE idCD = " + a.getId_articulo());
			}else if(a.getTipo().equalsIgnoreCase("dvd")) {
				s.executeQuery("");
			}else{
				s.executeQuery("");
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR AL INTENTAR ACTUALIZAR STOCK");
			e.printStackTrace();
		}
	}
}
