import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FrontActualizarBorrar  extends JFrame{
	private JPanel panelPrincipal;	
	private JLabel  lblcd;
	private JLabel lbldvd;
	private JLabel lbllibro;
	
	public FrontActualizarBorrar(){
		
		this.setTitle("Selecciona tu artículo");
		this.setSize(1000,500);	
		
		//Posiciono el JPanel
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));			
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		
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
		
		FrontActualizarBorrarCD  cd=  new FrontActualizarBorrarCD();
		cd.setBounds(10, 10, 500, 500);
		cd.setLayout(new GridLayout(2,2,100,300));
		panelcd.add(cd);	
		cd.setVisible(true);
		
		panelDePestanas.addTab("CD", panelcd);
		
		//Segunda pestaña DVD	
		JPanel paneldvd = new JPanel();		
		paneldvd.setLayout(null);
		  
		lbldvd = new JLabel();	
		lbldvd.setBounds(10, 20, 150, 150);			
		paneldvd.setBackground(new Color (215,246,185));
		paneldvd.add(lbldvd);
		
		FrontActualizarBorrarDVD  dvd=  new FrontActualizarBorrarDVD();
		dvd.setBounds(0, 0, 500, 500);
		paneldvd.add(dvd);	
		dvd.setVisible(true);

		
		panelDePestanas.addTab("DVD",paneldvd);
		
		//Tercera pestaña LIBRO
		JPanel panelLibro = new JPanel();			
		panelLibro.setLayout(null);
			  
		lbllibro = new JLabel();	
		lbllibro.setBounds(10, 20, 150, 150);
		panelLibro.setBackground(new Color (215,246,185));
		panelLibro.add(lbllibro);
		
		FrontActualizarBorrarLibro  libro=  new FrontActualizarBorrarLibro();
		libro.setBounds(0, 0, 500, 500);
		panelLibro.add(libro);	
		libro.setVisible(true);

		
		panelDePestanas.addTab("LIBRO", panelLibro);
		panelPrincipal.add(panelDePestanas);
		add(panelPrincipal);
		panelPrincipal.setBackground(new Color (99,193,111));
		
		setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		

}
