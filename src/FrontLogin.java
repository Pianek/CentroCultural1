import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontLogin extends JFrame {
	private JPanel panel;
	private JLabel usuario;
	private JLabel password;
	private JTextField fUsuario;
	private JPasswordField fPassword;
	private JButton aceptar;
	private Conexion conexion;
	
	public FrontLogin() {
		
		conexion = new Conexion();
		
//		panel = new JPanel();
//		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
//		panel.setLayout(box);
		
		panel=new JPanel();
		panel.setBorder(new EmptyBorder(420,820,420,820));
		panel.setLayout(new GridLayout(5, 1, 70, 10));
		this.setLocationRelativeTo(null);
		
		this.setTitle("Login");
//		this.setSize(500, 100);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		
//		setBounds(1000, 500, 1000, 1000);
//		panel=new JPanel();
//		panel.setBorder(new EmptyBorder(5, 100, 5, 100));			
//		panel.setLayout(new GridLayout(2, 2, 100, 30));
//		this.setLocationRelativeTo(null);   
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		usuario = new JLabel("Usuario");
		fUsuario = new JTextField(10);
		
		password = new JLabel("Contraseña");
		fPassword = new JPasswordField(10);
		fPassword.setEchoChar('*');
		
		aceptar = new JButton("Aceptar");
		aceptar.addMouseListener(new acceder());
		
		panel.setBackground(new Color (99,193,111));
		aceptar.setBackground(new Color (215,246,185));
		
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
	    	Usuario usuario = new Usuario(fUsuario.getText(), fPassword.getText());
	    	if(event.getSource() == aceptar) {
	    		rs = conexion.getResultSet(usuario.buscarUsuario());
	    		try {
	    			rs.next();
	    			usuario.setIdUsuario(rs.getInt(1));
	    			usuario.setNombre(rs.getString(2));
	    			usuario.setPassword(rs.getString(3));
					permiso = rs.getString(4);
					usuario.setPermisos(permiso);
					
				} catch (SQLException e) {
					System.out.println("Error al buscar el permiso");
					e.printStackTrace();
				}finally {
					conexion.cerrarConexion();
				}
	    	}
	    	if(permiso.equalsIgnoreCase("usuario")) {
	    		FrontUsuario prestamo = new FrontUsuario(usuario);
	    		prestamo.setVisible(true);
	    	}else if(permiso.equalsIgnoreCase("administrador")) {
	    		FrontAdmin admin = new FrontAdmin(usuario);
	    		admin.setVisible(true);
	    	}
	    }
	}
}

