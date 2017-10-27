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
		panel.setBorder(new EmptyBorder(300,500,300,500));
		panel.setLayout(new GridLayout(5, 1, 70, 70));
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
		fUsuario.setBounds(100, 10, 100, 100);
		
		password = new JLabel("Contraseña");
		fPassword = new JPasswordField(10);
		fPassword.setEchoChar('*');
		fPassword.setBounds(100, 10, 100, 100);
		
		aceptar = new JButton("Aceptar");
		aceptar.setBounds(100, 10, 100, 150);
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
	    	if(permiso.equalsIgnoreCase("usuario")) {
	    		FrontUsuario prestamo = new FrontUsuario();
	    		prestamo.setVisible(true);
	    	}else if(permiso.equalsIgnoreCase("administrador")) {
	    		FrontAdmin admin = new FrontAdmin();
	    		admin.setVisible(true);
	    	}
	    }
	}
}

