import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontActores extends JFrame {
	private Conexion conexion;
	private JPanel panelPrincipal;
	private JPanel panelCentral;
	// private JPanel panelIzquierda;
	// private JPanel panelDerecha;
	private JLabel NombreActor;
	private JLabel NombrePelicula;
	private JTextField fNombreActor;
	private JTextField fNombrePelicula;
	private ImageIcon iconoActor;
	private JButton anadirActor;
	private JButton atrasActor;
//	private JButton cerrarSesionActor;

	public FrontActores() {
		conexion = new Conexion();
		iconoActor = new ImageIcon("iconos\\chaplin.png");
		this.setTitle("Añade un actor");
		this.setSize(1000,500);	
		
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));			
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		
		setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		BorderLayout fondoEntero= new BorderLayout();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	

	// setBounds(100,500,1000,1000);public void init() {
//		panelPrincipal = new JPanel();
//		panelPrincipal.setLayout(new BorderLayout());
//		panelPrincipal.setBorder(new EmptyBorder(new Insets(300, 450, 300, 450)));

		// panelIzquierda = new JPanel();
		// panelDerecha= new JPanel();
		// panelCentral= new JPanel();
		// panelCentral.setLayout(new GridLayout(4, 1, 3, 3));
		// panelPrincipal.add("Center", panelCentral);
		// panelPrincipal.add("West", panelIzquierda);
		// panelPrincipal.add("East", panelDerecha);
		getContentPane().add(panelPrincipal);

		JLabel icono_actor = new JLabel();
		icono_actor.setBounds(150, 100, 500, 500);
		icono_actor.setIcon(iconoActor);
		panelPrincipal.add(icono_actor);

		JLabel NombreActor = new JLabel("Nombre actor");
		NombreActor.setBounds(600, 50, 100, 25);
		;
		panelPrincipal.add(NombreActor);

		fNombreActor = new JTextField(10);
		fNombreActor.setBounds(600, 10, 200, 20);
		panelPrincipal.add(fNombreActor);

		JLabel NombrePelicula = new JLabel("Nombre Pelicula");
		NombrePelicula.setBounds(620, 68, 100, 50);
		;
		panelPrincipal.add(NombreActor);

		fNombrePelicula = new JTextField(10);
		fNombrePelicula.setBounds(545, 103, 200, 25);
		panelPrincipal.add(fNombrePelicula);

		anadirActor = new JButton("Añadir");
		anadirActor.setBounds(600, 283, 100, 20);
		anadirActor.addMouseListener(new crear());
		panelPrincipal.add(anadirActor);

		atrasActor = new JButton("Atrás");
		atrasActor.setBounds(900, 50, 100, 25);
		atrasActor.addMouseListener(new crear());
		panelPrincipal.add(atrasActor);

//		cerrarSesionActor = new JButton("Cerrar Sesion");
//		cerrarSesionActor.setBounds(600, 50, 10, 25);
//		cerrarSesionActor.addMouseListener(new crear());
//		panelPrincipal.add(cerrarSesionActor);

		panelPrincipal.setBackground(new Color(99, 193, 111));
		// panelIzquierda.setBackground(new Color (99,193,111));
		// panelDerecha.setBackground(new Color (99,193,111));
		// panelCentral.setBackground(new Color (99,193,111));

		

	}

	class crear extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == atrasActor) {
				FrontCrearArticulo cr = new FrontCrearArticulo();
				cr.setVisible(true);
			}
//			if (event.getSource() == cerrarSesionActor) {
//				FrontLogin lg = new FrontLogin();
//				lg.setVisible(true);

			}

		}
	}


