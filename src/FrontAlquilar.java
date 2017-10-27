import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FrontAlquilar extends JFrame{
	private JPanel panelPrincipal;	
	private JLabel background;
	private BorderLayout fondoEntero;
	private Color colorFondo;
	private String tipoArticulo;
	private JLabel  lblcd;
	private JLabel lbldvd;
	private JLabel lbllibro;
	//private Conexion conexion;
	

public FrontAlquilar(){
	//conexion= new Conexion();
	
	this.setTitle("Selecciona tu artículo");
	this.setSize(1000,500);	
	
	//posiciono el JPanel
	setBounds(1000, 500, 1000, 1000);
	panelPrincipal=new JPanel();
	panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));			
	panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
	
	//aqui se crea y posiciona el panel de pestañas
	JTabbedPane panelDePestanas = new JTabbedPane();
	
	//primera pestaña CD
	JPanel panelcd = new JPanel();				
	panelcd.setLayout(null);
	
	//Elementos de la pestaña de CD	
	lblcd = new JLabel("alquilar CD");						
	lblcd.setBounds(10, 20, 10, 10);
	panelcd.setBackground(colorFondo=new Color (215,246,185));				
	panelcd.add(lblcd);
	
	FrontAlquilarCD  cd=  new FrontAlquilarCD();
	cd.setBounds(0, 0, 500, 500);
	panelcd.add(cd);	
	cd.setVisible(true);
	

	
	
	panelDePestanas.addTab("CD", panelcd);
	
	//segunda pestaña	
	JPanel paneldvd = new JPanel();		
	paneldvd.setLayout(null);
	  
	//etiqueta para la pestaña de dvd
	lbldvd = new JLabel("Alquilar DVD");			
	lbldvd.setBounds(10, 20, 70, 70);			
	paneldvd.setBackground(colorFondo=new Color (215,246,185));
	paneldvd.add(lbldvd);
	
	FrontAlquilarDVD  dvd=  new FrontAlquilarDVD();
	dvd.setBounds(0, 0, 500, 500);
	paneldvd.add(dvd);	
	dvd.setVisible(true);

	
	panelDePestanas.addTab("DVD",paneldvd);
	
	//tercera pestaña
	JPanel panelLibro = new JPanel();			
	panelLibro.setLayout(null);
		  
	//elementos del panel LIBRO
	JLabel lblLibro = new JLabel("Alquilar Libro");
	lblcd.setBounds(10, 20, 70, 70);
	panelLibro.setBackground(colorFondo=new Color (215,246,185));
	panelLibro.add(lblLibro);
	
	
	FrontAlquilarLibro  libro=  new FrontAlquilarLibro();
	libro.setBounds(0, 0, 500, 500);
	panelLibro.add(libro);	
	libro.setVisible(true);
	
	panelDePestanas.addTab("LIBRO", panelLibro);
	panelPrincipal.add(panelDePestanas);
	add(panelPrincipal);
	panelPrincipal.setBackground(colorFondo=new Color (99,193,111));
	
	setVisible(true);
	this.setLocationRelativeTo(null);   
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	BorderLayout fondoEntero= new BorderLayout();
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
}
	

}

























