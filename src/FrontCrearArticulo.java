import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;

public class FrontCrearArticulo  extends JFrame{
	private JPanel  panelPrincipal;	
	private Conexion conexion;		
	private ImageIcon iconoCD;
	private ImageIcon iconoDVD;
	private ImageIcon iconoLibro;
	private JButton anadirCD;
	private JButton anadirDVD;
	private JButton anadirLIBRO;
	private JButton atrasCD;
	private JButton atrasDVD;
	private JButton atrasLIBRO;
	private JTextField textoTituloCD;
	private JTextField textoDiscografia;
	private JTextField textoStock;
	private JTextField textoCantante;
	private JTextField TextoTitulo;
	private JTextField TextoDirector;
	private JTextField TextoProductor;
	private JTextField TextoStockDVD;
	private JTextField textoTituloLibro;
	private JTextField textoAutor;	
	private JTextArea textoCapMuestra;
	private JTextField textoNumPag;
	private JTextField textoStockLibro;
	
	

	public FrontCrearArticulo(){			
		
		conexion= new Conexion();
		iconoCD = new ImageIcon("iconos\\iconoCD.png");
		iconoDVD = new ImageIcon("iconos\\iconoDVD.png");
		iconoLibro = new ImageIcon("iconos\\iconoLibro.png");
					
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
		
		JLabel lblcd = new JLabel();						
		lblcd.setBounds(10, 20, 10, 10);
		panelcd.setBackground(new Color (215,246,185));			
		
		JLabel iconocd = new JLabel();
		iconocd.setBounds(100, 30, 250, 250);
		iconocd.setIcon(iconoCD);			
		panelcd.add(lblcd);
		panelcd.add(iconocd);
				
		JLabel tituloCD = new JLabel("Título");
		tituloCD.setBounds(620, 68, 100, 50);	;
		panelcd.add(tituloCD);
		
		textoTituloCD= new JTextField(10);
		
		textoTituloCD.setBounds(545, 103, 200, 25);	
		panelcd.add(textoTituloCD);	
	
		JLabel discografia = new JLabel("Discografia");
		discografia.setBounds(610,118,100,50);
		panelcd.add(discografia);
		
		textoDiscografia = new JTextField(10);
		textoDiscografia.setBounds(545,153,200,25);
		panelcd.add(textoDiscografia);
		
		JLabel stockCD = new JLabel("Stock");
		stockCD.setBounds(620,168,50,50);
		panelcd.add(stockCD);
		
		textoStock = new JTextField(10);
		textoStock.setBounds(545,203,200,25);
		panelcd.add(textoStock);
		
		JLabel cantante = new JLabel("Cantante");
		cantante.setBounds(620,218,90,50);
		panelcd.add(cantante);
		
		textoCantante = new JTextField(10);
		textoCantante.setBounds(545,253,200,25);
		panelcd.add(textoCantante);
		
		anadirCD = new JButton("Añadir");
		anadirCD.setBounds(600,283,100,20);
		anadirCD.addMouseListener(new crear());
		panelcd.add(anadirCD);
		
		atrasCD  = new JButton ("Atrás");
		atrasCD.setBounds(900, 50, 100, 25);
		atrasCD.addMouseListener(new crear());
		panelcd.add(atrasCD);
					
		panelDePestanas.addTab("CD", panelcd);			
			
		
		//Segunda pestaña DVD
		JPanel paneldvd = new JPanel();		
		paneldvd.setLayout(null);
		  
		JLabel lbldvd = new JLabel();			
		lbldvd.setBounds(10, 20, 70, 70);			
		paneldvd.setBackground(new Color (215,246,185));
		
		JLabel iconodvd = new JLabel();
		iconodvd.setBounds(100, 30, 250, 250);
		iconodvd.setIcon(iconoDVD);
		
		paneldvd.add(lbldvd);
		paneldvd.add(iconodvd);
	
		JLabel tituloDVD = new JLabel("Titulo de la Pelicula");
		tituloDVD.setBounds(600, 5, 200,200);
		paneldvd.add(tituloDVD);
		
		TextoTitulo = new JTextField(10);
		TextoTitulo.setBounds(545, 113,200,25);
		paneldvd.add(TextoTitulo);
		
		JLabel director = new JLabel("Director");
		director.setBounds(615, 125, 100,50);
		paneldvd.add(director);
		
		TextoDirector = new JTextField(10);
		TextoDirector.setBounds(545,160,200,25 );
		paneldvd.add(TextoDirector);
		
		JLabel productor = new JLabel("Productora");
		productor.setBounds(615, 147, 100,100);
		paneldvd.add(productor);
		
		TextoProductor = new JTextField(10);
		TextoProductor.setBounds(545,205,200,25 );
		paneldvd.add(TextoProductor);
		
		JLabel stockDVD = new JLabel("Stock");
		stockDVD.setBounds(625,218,90,50);
		paneldvd.add(stockDVD);
		
		TextoStockDVD = new JTextField(10);
		TextoStockDVD.setBounds(545,253,200,25);
		paneldvd.add(TextoStockDVD);
	
		anadirDVD = new JButton("Añadir");
		anadirDVD.setBounds(600,283,100,20);
		anadirDVD.addMouseListener(new crear());
		paneldvd.add(anadirDVD);
		
		atrasDVD  = new JButton ("Atrás");
		atrasDVD.setBounds(900, 50, 100, 25);
		atrasDVD.addMouseListener(new crear());
		paneldvd.add(atrasDVD);
		
		panelDePestanas.addTab("DVD",paneldvd);
		 
		
		//Tercera pestaña LIBRO
		JPanel panelLibro = new JPanel();
		
		panelLibro.setLayout(null);
			  
		JLabel lblLibro = new JLabel();
		lblcd.setBounds(10, 20, 70, 70);
		paneldvd.setBackground(new Color (215,246,185));
		
		JLabel iconolibro = new JLabel();
		iconolibro.setBounds(100, 30, 350, 250);
		iconolibro.setIcon(iconoLibro);
		
		panelLibro.add(lblLibro);
		panelLibro.add(iconolibro);
	
		JLabel tituloLibro = new JLabel("Título");
		tituloLibro.setBounds(620, 45, 50, 50);	;
		panelLibro.add(tituloLibro);
		
		textoTituloLibro= new JTextField(10);
		textoTituloLibro.setBounds(545, 80, 200, 25);	
		panelLibro.add(textoTituloLibro);	
		panelLibro.setBackground(new Color (215,246,185));
	
		JLabel autor = new JLabel("Autor");
		autor.setBounds(620,100,100,50);
		panelLibro.add(autor);
		
		textoAutor = new JTextField(10);
		textoAutor.setBounds(545,133,200,25);
		panelLibro.add(textoAutor);
		
		JLabel capMuestra = new JLabel("Capitulo muestra");
		capMuestra.setBounds(850,45,120,100);
		panelLibro.add(capMuestra);
		
		textoCapMuestra = new JTextArea();
		textoCapMuestra.setLineWrap(true);
		textoCapMuestra.setBounds(830,120,250,150);
		panelLibro.add(textoCapMuestra);
		
		JLabel numPag = new JLabel("Número páginas");
		numPag.setBounds(600,125,100,100);
		panelLibro.add(numPag);
		
		textoNumPag = new JTextField(10);
		textoNumPag.setBounds(545,185,200,25);
		panelLibro.add(textoNumPag);
		
		JLabel stockLibro = new JLabel("Stock");
		stockLibro.setBounds(620,195,50,50);
		panelLibro.add(stockLibro);
		
		textoStockLibro = new JTextField(10);
		textoStockLibro.setBounds(545,235,200,25);
		panelLibro.add(textoStockLibro);	
		
		anadirLIBRO = new JButton("Añadir");
		anadirLIBRO.setBounds(600,270,100,20);
		anadirLIBRO.addMouseListener(new crear());
		panelLibro.add(anadirLIBRO);
		
		atrasLIBRO  = new JButton ("Atrás");
		atrasLIBRO.setBounds(1200, 50, 100, 25);
		atrasLIBRO.addMouseListener(new crear());
		panelLibro.add(atrasLIBRO);
		
		panelDePestanas.addTab("LIBRO", panelLibro);
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


	class crear extends MouseAdapter{//se crea una clase privada
		public void mouseClicked(MouseEvent event){
			//Boton de atrás
	    	if (event.getSource()==atrasCD){
	    		FrontAdmin frame = new  FrontAdmin();
		        frame.setVisible(true);
	        }
	        if (event.getSource()==atrasDVD){
	        	FrontAdmin frame = new  FrontAdmin();
	        	frame.setVisible(true);
	        }
	        if (event.getSource()==atrasLIBRO){
	        	FrontAdmin frame = new  FrontAdmin();
	        	frame.setVisible(true);
	        }
	
	        //Añadir elementos a la BBDD
	        boolean valido= (true);
	        if(event.getSource()==anadirCD){	
	        	CD cd = new CD(textoTituloCD.getText(), Integer.parseInt(textoStock.getText()), textoCantante.getText(), textoDiscografia.getText());
	        	valido=conexion.ejecutarSentencia(cd.crear());
	        	if (valido) {
	        		JOptionPane.showMessageDialog(anadirCD, "Se ha creado con exito");
	        	}else {
	        		JOptionPane.showMessageDialog(anadirCD, "No se ha podido crear");
	        	}
	        }
	        if(event.getSource()==anadirDVD){
	        	DVD dvd= new DVD(TextoTitulo.getText(),TextoDirector.getText(),TextoProductor.getText(),Integer.parseInt(TextoStockDVD.getText())); 
	        	valido=conexion.ejecutarSentencia(dvd.crear());
	        	if (valido) {
	        		JOptionPane.showMessageDialog(anadirDVD, "Se ha creado con exito");
				}else {
					JOptionPane.showMessageDialog(anadirDVD, "No se ha podido crear");
				}	
	        }
	        if(event.getSource()==anadirLIBRO){
	        	Libro libro= new Libro(textoTituloLibro.getText(),textoAutor.getText(),textoCapMuestra.getText(),Integer.parseInt(textoNumPag.getText()),Integer.parseInt(textoStockLibro.getText())); 
	        	System.out.println(libro.crear());   
	        	valido=conexion.ejecutarSentencia(libro.crear());
	        	if (valido) {
	        		JOptionPane.showMessageDialog(anadirLIBRO, "Se ha creado con exito");
	        	}else {
	        		JOptionPane.showMessageDialog(anadirLIBRO, "No se ha podido crear");
	        	}
	        }
	    }
	}
}