import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FrontDevolver  extends JFrame{
	private JPanel panelPrincipal;	
	private JLabel  lblcd;
	private JLabel lbldvd;
	private JLabel lbllibro;
		
	public FrontDevolver(){
		
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
		
		lblcd = new JLabel("Devolver CD");						
		lblcd.setBounds(10, 20, 150, 150);
		panelcd.setBackground(new Color (215,246,185));				
		panelcd.add(lblcd);
		
		panelDePestanas.addTab("CD", panelcd);
		
		
		//Degunda pestaña DVD	
		JPanel paneldvd = new JPanel();		
		paneldvd.setLayout(null);
		  
		lbldvd = new JLabel("Devolver DVD");			
		lbldvd.setBounds(10, 20, 150, 150);			
		paneldvd.setBackground(new Color (215,246,185));
		paneldvd.add(lbldvd);

		panelDePestanas.addTab("DVD",paneldvd);
		
		
		//Tercera pestaña LIBRO
		JPanel panelLibro = new JPanel();			
		panelLibro.setLayout(null);
		
		lbllibro = new JLabel("Devolver LIBRO");  
		lbllibro.setBounds(10, 20, 150, 150);
		panelLibro.setBackground(new Color (215,246,185));
		panelLibro.add(lbllibro);

		panelDePestanas.addTab("LIBRO", panelLibro);
		
		
		//Diseño panel principal
		panelPrincipal.add(panelDePestanas);
		add(panelPrincipal);
		panelPrincipal.setBackground(new Color (99,193,111));
		
		setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		BorderLayout fondoEntero= new BorderLayout();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
