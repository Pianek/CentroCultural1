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

public class FrontGestionar  extends JFrame{
	private JPanel panelPrincipal;	
	private JLabel lblcd;
	private JLabel lbldvd;
	private JLabel lbllibro;
	private JButton atrasCD;
	private JButton atrasDVD;
	private JButton atrasLIBRO;
	
	public FrontGestionar(){
		
		this.setTitle("Selecciona tu artículo");
		this.setSize(1000,100);	
		
		//Posiciono el JPanel
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));			
		panelPrincipal.setLayout(new GridLayout(2, 20, 100, 30));
		
		//Posiciona el panel de pestañas
		JTabbedPane panelDePestanas = new JTabbedPane();

		
		//Primera pestaña CD
		JPanel panelcd = new JPanel();				
		panelcd.setLayout(null);
		
		lblcd = new JLabel();						
		lblcd.setBounds(10, 20, 150, 150);
		panelcd.setBackground(new Color (215,246,185));
		panelcd.setBounds(10, 10, 500, 500);
		panelcd.setBorder(new EmptyBorder(100,100,50,100));
		panelcd.add(lblcd);
		
		FrontGestionarCD  cd=  new FrontGestionarCD();
		cd.setBounds(100, 50, 900, 900);
		cd.setLayout(new GridLayout(2,2,100,300));
		cd.setBackground(new Color (215,246,185));
		panelcd.add(cd);	
		cd.setVisible(true);
		
		atrasCD  = new JButton ("Atrás");
		atrasCD.setBounds(1200, 50, 100, 25);
		atrasCD.addMouseListener(new atras());
		panelcd.add(atrasCD);
		
		
		panelDePestanas.addTab("CD", panelcd);
		
		
		//Segunda pestaña DVD	
		JPanel paneldvd = new JPanel();		
		paneldvd.setLayout(null);
		  
		lbldvd = new JLabel();	
		lbldvd.setBounds(10, 20, 150, 150);			
		paneldvd.setBackground(new Color (215,246,185));
		paneldvd.add(lbldvd);
		
		FrontGestionarDVD  dvd=  new FrontGestionarDVD();
		dvd.setBounds(100, 50, 900, 900);
		dvd.setLayout(new GridLayout(2,2,100,300));
		dvd.setBackground(new Color (215,246,185));
		paneldvd.add(dvd);	
		dvd.setVisible(true);
		
		atrasDVD  = new JButton ("Atrás");
		atrasDVD.setBounds(1200, 50, 100, 25);
		atrasDVD.addMouseListener(new atras());
		paneldvd.add(atrasDVD);
		
		panelDePestanas.addTab("DVD",paneldvd);
		
		//Tercera pestaña LIBRO
		JPanel panelLibro = new JPanel();			
		panelLibro.setLayout(null);
			  
		lbllibro = new JLabel();	
		lbllibro.setBounds(10, 20, 150, 150);
		panelLibro.setBackground(new Color (215,246,185));
		panelLibro.add(lbllibro);
		
		FrontGestionarLibro  libro=  new FrontGestionarLibro();
		libro.setBounds(100, 50, 900, 900);
		libro.setLayout(new GridLayout(2,2,100,300));
		libro.setBackground(new Color (215,246,185));
		panelLibro.add(libro);	
		libro.setVisible(true);

		atrasLIBRO  = new JButton ("Atrás");
		atrasLIBRO.setBounds(1200, 50, 100, 25);
		atrasLIBRO.addMouseListener(new atras());
		panelLibro.add(atrasLIBRO);
		
		panelDePestanas.addTab("LIBRO", panelLibro);
		
		//Diseño panel general
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
	    }
	}
}
