import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrontUsuario extends JFrame {
	private JPanel panel;
	private JPanel panelBotones;
	private JPanel panelAbajo;
	private JButton alquilar;
	private JButton devolver;
	private JButton cerrarSesion;
	private Usuario	usuario;
	
	public FrontUsuario(Usuario usu) {
		usuario = usu;
		this.setTitle("Panel usuario");
		this.setSize(1000,1000);
		init();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void init() {	
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
	    panel.setBorder(new EmptyBorder(new Insets(150, 270, 150, 270)));
		
	    panelBotones = new JPanel();
	    panelAbajo= new JPanel();		
		panel.setLayout(new BorderLayout());
		panel.setBackground(new Color (99,193,111));
		panelBotones.setBackground(new Color (99,193,111));
		panelAbajo.setBackground(new Color (99,193,111));
		
		add(panel);
	    panel.setLayout(new GridLayout(2, 2, 3, 3));
	    panel.setLayout(new GridLayout(3, 2, 3, 3));
	    panel.add("Center", panelBotones);
	    panel.add("South", panelAbajo);
	    getContentPane().add(panel);
		
		alquilar = new JButton("Alquilar");		
		alquilar.setFont(new Font("Arial", Font.PLAIN, 80));
		alquilar.setBackground(new Color (215,246,185));
		alquilar.addMouseListener(new Click());
		panelBotones.add(alquilar);
		
		
		devolver = new JButton("Devolver");
		devolver.setFont(new Font("Arial", Font.PLAIN, 80));
		devolver.setBackground(new Color (215,246,185));
		devolver.addMouseListener(new Click());
		panelBotones.add(devolver);
		
		cerrarSesion = new JButton ("Cerrar Sesion");
		cerrarSesion.setFont(new Font("Arial", Font.PLAIN, 15));		
		cerrarSesion.addMouseListener(new Click());
		panelAbajo.add(cerrarSesion);
	}
	
	class Click extends MouseAdapter{
		
		public void mouseClicked (MouseEvent evento) {
			
			if (evento.getSource() == alquilar) {
				FrontAlquilar frame = new FrontAlquilar(usuario);
				frame.setVisible(true);
			}
			
			if (evento.getSource() == devolver) {
				FrontPrestamos frame = new FrontPrestamos(usuario);
				frame.setVisible(true);
			}
			
			//Cerrar sesión
			if (evento.getSource() == cerrarSesion) {
				usuario = null;
				FrontLogin lg= new FrontLogin();
	    		lg.setVisible(true);
			}
		}
	}
}
