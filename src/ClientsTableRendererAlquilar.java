import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ClientsTableRendererAlquilar extends DefaultCellEditor {
	
	private JButton button;
	private String label;
	private boolean clicked;
	private int row, col;
	private JTable table;
	private String tipoArticulo;
	private Conexion conexion;
	private int stock; 

	public ClientsTableRendererAlquilar(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public ClientsTableRendererAlquilar(JCheckBox checkBox,String tipo) {
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

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		this.table = table;
		this.row = row;
		this.col = column;

		if(tipoArticulo.equals("libro")) {
			stock = Integer.parseInt( table.getValueAt(row, 5).toString());
		}else {
			stock = Integer.parseInt( table.getValueAt(row, 4).toString());
		}
		
		if(stock != 0) {
			button.setBackground(UIManager.getColor("Button.background"));
			label = (value == null) ? "Alquilado" : value.toString();
			button.setText(label);
		}else {
			button.setBackground(UIManager.getColor("Button.background"));
			label = (value == null) ? "No se puede alquilar" : value.toString();
			button.setText(label);
		}
		clicked = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (clicked) {
			if(tipoArticulo.equals("libro")) {
				stock = Integer.parseInt( table.getValueAt(row, 5).toString());
			}else {
				stock = Integer.parseInt( table.getValueAt(row, 4).toString());
			}
			
			if(stock == 0) {
				JOptionPane.showMessageDialog(button,"No puede alquilar el "+ tipoArticulo.toUpperCase() + " " + table.getValueAt(row, 1) + ", están todos alquilados.");
			}else {
				stock--;
				if(tipoArticulo.equals("libro")) {
					table.setValueAt((Object) stock,row, 5);
				}else {
					table.setValueAt((Object) stock,row, 4);
				}
				alquilar();
				JOptionPane.showMessageDialog(button,
						"Ha alquilado el "+ tipoArticulo + ": " + table.getValueAt(row, 1));
			}
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
	
	public void alquilar() {
		if(tipoArticulo.equals("libro")) {
			stock = Integer.parseInt( table.getValueAt(row, 5).toString());
		}else {
			stock = Integer.parseInt( table.getValueAt(row, 4).toString());
		}
		conexion.ejecutarSentencia("UPDATE " + tipoArticulo +" SET stock = " + (stock-1) + " WHERE id" + tipoArticulo.toUpperCase() + " = " + table.getValueAt(row, 0));
		
		//FALTA AÑADIR A tipoArticulo_has_prestamo!!
	}
}
