import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FrontAlquilar extends JFrame{
	private JPanel panelPrincipal;	
	private JLabel lblcd;
	private JLabel lbldvd;
	private JLabel lbllibro;
	private JButton atrasCD;
	private JButton atrasDVD;
	private JButton atrasLIBRO;
	private JButton cerrarSesionCD;
	private JButton cerrarSesionDVD;
	private JButton cerrarSesionLIBRO;
	
	public FrontAlquilar(){
		
		this.setTitle("Alquilar");
		this.setSize(1000,500);	
		
		//Posiciono el JPanel
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));			
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		
		//Posiciona el panel de pestañas
		JTabbedPane panelDePestanas = new JTabbedPane();
		
		
		//Prrimera pestaña CD
		JPanel panelcd = new JPanel();				
		panelcd.setLayout(null);
		
		lblcd = new JLabel();						
		lblcd.setBounds(10, 20, 10, 10);
		panelcd.setBackground(new Color (215,246,185));				
		panelcd.add(lblcd);
		
		FrontAlquilarCD  cd=  new FrontAlquilarCD();
		cd.setBounds(100, 50, 900, 900);
		cd.setLayout(new GridLayout(2,2,100,300));
		cd.setBackground(new Color (215,246,185));
		panelcd.add(cd);	
		cd.setVisible(true);
		
		atrasCD  = new JButton ("Atrás");
		atrasCD.setBounds(1200, 50, 100, 25);
		atrasCD.addMouseListener(new atras());
		panelcd.add(atrasCD);
		
		cerrarSesionCD  = new JButton ("Cerrar Sesion");
		cerrarSesionCD.setBounds(1350, 50, 135, 25);
		cerrarSesionCD.addMouseListener(new atras());
		panelcd.add(cerrarSesionCD);
		
		panelDePestanas.addTab("CD", panelcd);
		
		
		//Segunda pestaña DVD	
		JPanel paneldvd = new JPanel();		
		paneldvd.setLayout(null);
		  
		lbldvd = new JLabel();			
		lbldvd.setBounds(10, 20, 70, 70);			
		paneldvd.setBackground(new Color (215,246,185));
		paneldvd.add(lbldvd);
		
		FrontAlquilarDVD  dvd=  new FrontAlquilarDVD();
		dvd.setBounds(100, 50, 900, 900);
		dvd.setLayout(new GridLayout(2,2,100,300));
		dvd.setBackground(new Color (215,246,185));
		paneldvd.add(dvd);	
		dvd.setVisible(true);
	
		atrasDVD  = new JButton ("Atrás");
		atrasDVD.setBounds(1200, 50, 100, 25);
		atrasDVD.addMouseListener(new atras());
		paneldvd.add(atrasDVD);
		
		cerrarSesionDVD  = new JButton ("Cerrar Sesion");
		cerrarSesionDVD.setBounds(1350, 50, 135, 25);
		cerrarSesionDVD.addMouseListener(new atras());
		paneldvd.add(cerrarSesionDVD);
		
		panelDePestanas.addTab("DVD",paneldvd);
		
		
		//Tercera pestaña LIBRO
		JPanel panelLibro = new JPanel();			
		panelLibro.setLayout(null);
			  
		lbllibro = new JLabel();
		lbllibro.setBounds(10, 20, 70, 70);
		panelLibro.setBackground(new Color (215,246,185));
		panelLibro.add(lbllibro);
		
		FrontAlquilarLibro  libro=  new FrontAlquilarLibro();
		libro.setBounds(100, 50, 900, 900);
		libro.setLayout(new GridLayout(2,2,100,300));
		libro.setBackground(new Color (215,246,185));
		panelLibro.add(libro);	
		libro.setVisible(true);
		
		atrasLIBRO  = new JButton ("Atrás");
		atrasLIBRO.setBounds(1200, 50, 100, 25);
		atrasLIBRO.addMouseListener(new atras());
		panelLibro.add(atrasLIBRO);
		
		cerrarSesionLIBRO  = new JButton ("Cerrar Sesion");
		cerrarSesionLIBRO.setBounds(1350, 50, 135, 25);
		cerrarSesionLIBRO.addMouseListener(new atras());
		panelLibro.add(cerrarSesionLIBRO);
		
		panelDePestanas.addTab("LIBRO", panelLibro);
		
		
		//Diseño general
		panelPrincipal.add(panelDePestanas);
		add(panelPrincipal);
		panelPrincipal.setBackground(new Color (99,193,111));
		
		setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class atras extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			//Boton de atrás
	    	if (event.getSource()==atrasCD || event.getSource()==atrasDVD || event.getSource()==atrasLIBRO){
	    		FrontAdmin frame = new  FrontAdmin();
		        frame.setVisible(true);
	        }
	    	if (event.getSource()==cerrarSesionCD||event.getSource()==cerrarSesionDVD||event.getSource()==cerrarSesionLIBRO){
	    		FrontLogin lg= new FrontLogin();
	    		lg.setVisible(true);
	    	}
		}
	}
}

























