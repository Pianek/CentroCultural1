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


public class FrontAdmin extends JFrame{
	
	private JPanel panelPrincipal;
	private JPanel panelAbajo;
	private JPanel panelBotones;
	private JPanel panelIzquierda;
	private JPanel panelDerecha;
	private JButton bCrear;
	private JButton bGestionar;
	private JButton bAlquilar;
	private JButton bDevolver;
	private JButton cerrarSesion;
	private Usuario usuario;

	public FrontAdmin(Usuario usu){
		usuario = usu;
		this.setTitle("Panel Administrador");
		this.setSize(300,300);
		init();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
		//Método que se utilizada para colocar botones por coordenadas
//		GridBagConstraints restricciones = new GridBagConstraints();
//    	setLayout(new GridBagLayout());
       
	public void init(){	
	   panelPrincipal = new JPanel();
	   panelPrincipal.setLayout(new BorderLayout());
       panelPrincipal.setBorder(new EmptyBorder(new Insets(340, 550, 340, 550)));
       
       panelBotones = new JPanel();
       panelIzquierda = new JPanel();
       panelDerecha= new JPanel();
       panelAbajo= new JPanel();
      
       panelBotones.setLayout(new GridLayout(3, 2, 3, 3));
       panelPrincipal.add("Center", panelBotones);
       panelPrincipal.add("East", panelIzquierda);
       panelPrincipal.add("West", panelDerecha);
       panelPrincipal.add("South", panelAbajo);
       getContentPane().add(panelPrincipal);
       
     		
       bCrear= new  JButton("Crear");
       bCrear.setFont(new Font("Arial", Font.PLAIN, 40));
       bCrear.addMouseListener(new MiClick());
		
       bGestionar = new  JButton("Gestionar");
       bGestionar.setFont(new Font("Arial", Font.PLAIN, 40));
       bGestionar.addMouseListener(new MiClick());

       bAlquilar= new  JButton("Alquilar");
       bAlquilar.setFont(new Font("Arial", Font.PLAIN, 40));
       bAlquilar.addMouseListener(new MiClick());

		
       bDevolver= new  JButton("Devolver");
       bDevolver.setFont(new Font("Arial", Font.PLAIN, 40));
       bDevolver.addMouseListener(new MiClick());
       
       cerrarSesion = new JButton ("Cerrar Sesion");
		cerrarSesion.setBounds(10, 10, 135, 25);
		cerrarSesion.addMouseListener(new MiClick());
		panelAbajo.add(cerrarSesion);
		
       //Se añaden los botones al panel
       panelBotones.add(bCrear);
       panelBotones.add(bGestionar);
	   panelBotones.add(bAlquilar);
	   panelBotones.add(bDevolver);
	    
	   panelPrincipal.setBackground(new Color (99,193,111));
	   panelIzquierda.setBackground(new Color (99,193,111));
	   panelDerecha.setBackground(new Color (99,193,111));
	   panelBotones.setBackground(new Color (99,193,111));
	   panelAbajo.setBackground(new Color (99,193,111));
	   bCrear.setBackground(new Color (215,246,185));
	   bGestionar.setBackground(new Color (215,246,185));
	   bAlquilar.setBackground(new Color (215,246,185));
	   bDevolver.setBackground(new Color (215,246,185));
	}
		
	class MiClick extends  MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == bCrear) {
				FrontCrearArticulo frame = new FrontCrearArticulo(usuario);
				frame.setVisible(true);
			}
			
			if (event.getSource() == bGestionar){
				FrontGestionar frame = new FrontGestionar(usuario);
				frame.setVisible(true);
			}
			
			if (event.getSource() == bAlquilar){
				FrontAlquilar frame = new FrontAlquilar(usuario);
				frame.setVisible(true);
			}
			
			if (event.getSource() == bDevolver){
				FrontPrestamos frame = new FrontPrestamos(usuario);
				frame.setVisible(true);
			}

			if (event.getSource()==cerrarSesion){
				usuario = null;
	    		FrontLogin lg= new FrontLogin();
	    		lg.setVisible(true);
			}
		}
	}
}
