import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ClientsTableRendererActualizar extends DefaultCellEditor {
	
	private JButton button;
	private String label;
	private boolean clicked;
	private int row, col;
	private JTable table;
	private String tipoArticulo;
	private Conexion conexion;

	public ClientsTableRendererActualizar(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public ClientsTableRendererActualizar(JCheckBox checkBox,String tipo) {
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
		
		button.setBackground(UIManager.getColor("Button.background"));
		label = (value == null) ? "Actualizado" : value.toString();
		button.setText(label);
		clicked = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (clicked) {
			actualizar();
			JOptionPane.showMessageDialog(button,"Actualizado con éxito el " +
					tipoArticulo.toUpperCase() + " con código " + table.getValueAt(row, 0));
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
	
	public void actualizar() {
		if(tipoArticulo.equals("cd")) {
//			int id, String ti, int stock,   String cantante, String discografia
			CD cd = new CD(Integer.parseInt(table.getValueAt(row, 0).toString()), table.getValueAt(row, 1).toString(),Integer.parseInt(table.getValueAt(row, 4).toString()),
					table.getValueAt(row, 2).toString(), table.getValueAt(row, 3).toString());
			System.out.println(cd.actualizar());
			conexion.ejecutarSentencia(cd.actualizar());
		}else if(tipoArticulo.equals("dvd")){
//			int id, String titulo, int stock, String prod, String dire
			DVD dvd = new DVD(Integer.parseInt(table.getValueAt(row, 0).toString()),table.getValueAt(row, 1).toString(),Integer.parseInt(table.getValueAt(row, 4).toString()),
					table.getValueAt(row, 3).toString(),table.getValueAt(row, 2).toString());
			conexion.ejecutarSentencia(dvd.actualizar());
		}else {
//			int id, String ti, int stock, String aut, int nump, String cap
			Libro libro = new Libro(Integer.parseInt(table.getValueAt(row, 0).toString()),table.getValueAt(row, 1).toString(),Integer.parseInt(table.getValueAt(row, 5).toString()),
					table.getValueAt(row, 2).toString(),Integer.parseInt(table.getValueAt(row, 4).toString()),table.getValueAt(row, 3).toString());
			conexion.ejecutarSentencia(libro.actualizar());
		}
	}
}