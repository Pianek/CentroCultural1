import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontLogin extends JFrame {
	private JPanel panel;
	private JLabel usuario;
	private JLabel password;
	private JTextField fUsuario;
	private JTextField fPassword;
	private JButton aceptar;
	private Color colorFondo;
	private Conexion conexion;
	
	public FrontLogin() {
		
		conexion = new Conexion();
		
		panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		this.setTitle("Login");
		this.setSize(500, 100);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		panel.setBorder(new EmptyBorder(new Insets(300, 450, 300, 450)));
		
		usuario = new JLabel("Usuario");
		fUsuario = new JTextField(10);
		
		password = new JLabel("Contraseña");
		fPassword = new JTextField(10);
		
		aceptar = new JButton("Aceptar");
		aceptar.addMouseListener(new acceder());
		
		panel.setBackground(colorFondo=new Color (99,193,111));
		aceptar.setBackground(colorFondo=new Color (215,246,185));
		
		add(panel);
		panel.add(usuario);
		panel.add(fUsuario);
		panel.add(password);
		panel.add(fPassword);
		panel.add(aceptar);
		
		setVisible(true);
	}
	
	class acceder extends MouseAdapter{
	    public void mouseClicked(MouseEvent event){
	    	String permiso = "";
	    	ResultSet rs = null;
	    	if(event.getSource() == aceptar) {
	    		Usuario usuario = new Usuario(fUsuario.getText(), fPassword.getText());
	    		rs = conexion.getResultSet(usuario.buscarUsuario());
	    		try {
	    			rs.next();
					permiso = rs.getString(4);
				} catch (SQLException e) {
					System.out.println("Error al buscar el permiso");
					e.printStackTrace();
				}finally {
					conexion.cerrarConexion();
				}
	    	}
	    	
	    	System.out.println(permiso);
	    	if(permiso.equalsIgnoreCase("usuario")) {

//	    		panel.setVisible(true);
//	    		FrontPrestamo prestamo = new FrontPrestamo();
//	    		prestamo.setVisible(true);
	    		
	    	}else if(permiso.equalsIgnoreCase("administrador")) {
	    		
//	    		panel.disable();
//	    		FrontAdmin admin = new FrontAdmin();
//	    		admin.setVisible(true);
	    		
	    	}
	    }
	}
	
}

