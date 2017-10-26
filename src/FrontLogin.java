import java.awt.Color;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	
	public FrontLogin() {
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
}