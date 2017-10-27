import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FrontActualizarBorrar  extends JFrame{
	private JPanel panelPrincipal;	
	private JLabel background;
	private BorderLayout fondoEntero;
	private Color colorFondo;
	private String tipoArticulo;
	private JLabel  lblcd;
	private JLabel lbldvd;
	private JLabel lbllibro;
	//private Conexion conexion;
	
	public FrontActualizarBorrar(){
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
		lblcd = new JLabel();						
		lblcd.setBounds(10, 20, 150, 150);
		panelcd.setBackground(colorFondo=new Color (215,246,185));
		panelcd.setBounds(10, 10, 500, 500);
		panelcd.setBorder(new EmptyBorder(100,100,50,100));
		panelcd.add(lblcd);
		
		FrontActualizarBorrarCD  cd=  new FrontActualizarBorrarCD();
		cd.setBounds(10, 10, 500, 500);
		cd.setLayout(new GridLayout(2,2,100,300));
		panelcd.add(cd);	
		cd.setVisible(true);
		
		panelDePestanas.addTab("CD", panelcd);
		
		//segunda pestaña	
		JPanel paneldvd = new JPanel();		
		paneldvd.setLayout(null);
		  
		//etiqueta para la pestaña de dvd
		lbldvd = new JLabel("Actualizar DVD");			
		lbldvd.setBounds(10, 20, 150, 150);			
		paneldvd.setBackground(colorFondo=new Color (215,246,185));
		paneldvd.add(lbldvd);
		
		FrontActualizarBorrarDVD  dvd=  new FrontActualizarBorrarDVD();
		dvd.setBounds(0, 0, 500, 500);
		paneldvd.add(dvd);	
		dvd.setVisible(true);

		
		panelDePestanas.addTab("DVD",paneldvd);
		
		//tercera pestaña
		JPanel panelLibro = new JPanel();			
		panelLibro.setLayout(null);
			  
		//elementos del panel LIBRO
		JLabel lblLibro = new JLabel("Actualizar Libro");
		lblLibro.setBounds(10, 20, 150, 150);
		panelLibro.setBackground(colorFondo=new Color (215,246,185));
		panelLibro.add(lblLibro);
		
		FrontActualizarBorrarLibro  libro=  new FrontActualizarBorrarLibro();
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
		//BorderLayout fondoEntero= new BorderLayout();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		

}
