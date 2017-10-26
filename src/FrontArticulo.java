import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontArticulo  extends JFrame{
	private JPanel  panelPrincipal;

	public FrontArticulo(){
		this.setTitle("Selecciona tu artículo");
		this.setSize(1000,500);
		init();
		setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init() {
		
		//posiciono el JPanel
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));
		
		//this.setPanelPrincipal(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		
		
		//aqui se crea y posiciona el panel de pestañas
		JTabbedPane panelDePestanas = new JTabbedPane();
		
		 
		//primera pestaña
		JPanel panelcd = new JPanel();				
		panelcd.setLayout(null);
		
		//Elementos de la pestaña de cd
		JLabel lblcd = new JLabel(" AÑADIR CD");
		lblcd.setBounds(10, 20, 50, 50);
		panelcd.add(lblcd);
		
//		JLabel idCD = new JLabel(" idCD");
//		idCD.setBounds(620, 18, 50, 50);
//		panelcd.add(idCD);
//	
//		
//		JTextField textoId = new JTextField(10);
//		textoId.setBounds(545,53,200,25);
//		panelcd.add(textoId);
//		
		JLabel tituloCD = new JLabel("Título");
		tituloCD.setBounds(620, 68, 100, 50);	;
		panelcd.add(tituloCD);
		
		JTextField  textoTituloCD= new JTextField(10);
		textoTituloCD.setBounds(545, 103, 200, 25);	
		panelcd.add(textoTituloCD);	
		
		JLabel discografia = new JLabel("Discografia");
		discografia.setBounds(610,118,100,50);
		panelcd.add(discografia);
		
		JTextField textoDiscografia = new JTextField(10);
		textoDiscografia.setBounds(545,153,200,25);
		panelcd.add(textoDiscografia);
		
		JLabel stockCD = new JLabel("Stock");
		stockCD.setBounds(620,168,50,50);
		panelcd.add(stockCD);
		
		JTextField textoStock = new JTextField(10);
		textoStock.setBounds(545,203,200,25);
		panelcd.add(textoStock);
		
		JLabel cantante = new JLabel("Cantante");
		cantante.setBounds(620,218,90,50);
		panelcd.add(cantante);
		
		JTextField textoCantante = new JTextField(10);
		textoCantante.setBounds(545,253,200,25);
		panelcd.add(textoCantante);
		
		JButton anadirCD = new JButton("Añadir");
		anadirCD.setBounds(600,283,100,20);
		panelcd.add(anadirCD);
		
		panelDePestanas.addTab("CD", panelcd);

		//segunda pestaña
		
		JPanel paneldvd = new JPanel();		
		paneldvd.setLayout(null);
		  
		//etiqueta para la pestaña de dvd
		JLabel lbldvd = new JLabel("Añadir DVD");
		lbldvd.setBounds(10, 20, 70, 70);
		paneldvd.add(lbldvd);
		
		JLabel tituloDVD = new JLabel("Titulo de la Pelicula");
		tituloDVD.setBounds(600, 5, 200,200);
		paneldvd.add(tituloDVD);
		
		JTextField TextoTitulo = new JTextField(10);
		TextoTitulo.setBounds(545, 113,200,25);
		paneldvd.add(TextoTitulo);
		
		JLabel director = new JLabel("Director");
		director.setBounds(615, 125, 100,50);
		paneldvd.add(director);
		
		JTextField TextoDirector = new JTextField(10);
		TextoDirector.setBounds(545,160,200,25 );
		paneldvd.add(TextoDirector);
		
		JLabel productor = new JLabel("Productora");
		productor.setBounds(615, 147, 100,100);
		paneldvd.add(productor);
		
		JTextField TextoProductor = new JTextField(10);
		TextoProductor.setBounds(545,205,200,25 );
		paneldvd.add(TextoProductor);
		
		JLabel stockDVD = new JLabel("Stock");
		stockDVD.setBounds(625,218,90,50);
		paneldvd.add(stockDVD);
		
		JTextField TextoStock = new JTextField(10);
		TextoStock.setBounds(545,253,200,25);
		paneldvd.add(TextoStock);
	
		JButton anadir = new JButton("Añadir");
		anadir.setBounds(600,283,100,20);
		paneldvd.add(anadir);
		
		panelDePestanas.addTab("DVD",paneldvd);
		 
		//tercera pestaña
		JPanel panelLibro = new JPanel();
		
		panelLibro.setLayout(null);
			  
		//elementos del panel LIBRO
		JLabel lblLibro = new JLabel("Tercera Libro");
		lblcd.setBounds(10, 11, 348, 14);
		panelLibro.add(lblLibro);
		
		JLabel tituloLibro = new JLabel("Título");
		tituloLibro.setBounds(620, 68, 100, 50);	;
		panelLibro.add(tituloLibro);
		
		JTextField  textoTituloLibro= new JTextField(10);
		textoTituloLibro.setBounds(545, 103, 200, 25);	
		panelLibro.add(textoTituloLibro);	

		JLabel autor = new JLabel("Autor");
		autor.setBounds(620,118,100,50);
		panelLibro.add(autor);
		
		JTextField textoAutor = new JTextField(10);
		textoAutor.setBounds(545,153,200,25);
		panelLibro.add(textoAutor);
		
		
		JLabel capMuestra = new JLabel("Capitulo muestra");
		capMuestra.setBounds(590,140,120,100);
		panelLibro.add(capMuestra);
		
		JTextField textoCapMuestra = new JTextField(10);
		textoCapMuestra.setBounds(545,200,200,25);
		panelLibro.add(textoCapMuestra);
		
		JLabel numPag = new JLabel("Número páginas");
		numPag.setBounds(600,190,100,100);
		panelLibro.add(numPag);
		
		JTextField textoNumPag = new JTextField(10);
		textoNumPag.setBounds(545,250,200,25);
		panelLibro.add(textoNumPag);
		
		JLabel stockLibro = new JLabel("Stock");
		stockLibro.setBounds(620,265,50,50);
		panelLibro.add(stockLibro);
		
		JTextField textoStockLibro = new JTextField(10);
		textoStockLibro.setBounds(545,300,200,25);
		panelLibro.add(textoStockLibro);	
		
		JButton anadirLIBRO = new JButton("Añadir");
		anadirLIBRO.setBounds(600,335,100,20);
		panelLibro.add(anadirLIBRO);
		
		panelDePestanas.addTab("LIBRO", panelLibro);
		panelPrincipal.add(panelDePestanas);
		add(panelPrincipal);
	}
}