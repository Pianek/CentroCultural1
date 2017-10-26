import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrontAnadirLibro extends JFrame{
	
	JPanel panel;
	JLabel id;
	JLabel titulo;
	JLabel numpag;
	JLabel stock;
	JLabel autor;
	JLabel capitulo;
	JTextField fId;
	JTextField fTitulo;
	JTextField fNumpag;
	JTextField fStock;
	JTextField fAutor;
	JTextField fCapitulo;
	JButton anadir;

	public FrontAnadirLibro() {
		//setBounds(1000,500,1000,1000);
		panel = new JPanel();
		//BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		//panel.setLayout(box);
		this.setTitle("Libros");
		this.setSize(500, 100);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//panel.setBorder(new EmptyBorder(new Insets(250, 450, 400, 450)));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		id = new JLabel("idLibro");
		id.setBounds(300,120,25,25);
		
		fId = new JTextField(10);
		fId.setBounds(300, 150, 300, 30);
		
		panel.add(id);
		panel.add(fId);
		
		titulo = new JLabel("Titulo");
		titulo.setBounds(300, 180, 25,25);
		panel.add(titulo);
		fTitulo = new JTextField(10);
		fTitulo.setBounds(300, 200,300,30);
		panel.add(fTitulo);
		
		numpag = new JLabel("Número de páginas");
		numpag.setBounds(300,220,25,25);
		panel.add(numpag);
		fNumpag = new JTextField(10);
		fNumpag.setBounds(300,240,300,30 );
		panel.add(fNumpag);
		
		stock = new JLabel("Stock");
		stock.setBounds(600,120,25,25);
		panel.add(stock);
		fStock = new JTextField(10);
		fStock.setBounds(600,150,300,30);
		panel.add(fStock);
		
		autor = new JLabel("Autor");
		autor.setBounds(600,180,25,25);
		panel.add(autor);
		fAutor = new JTextField(10);
		fAutor.setBounds(600,200,300,30);
		panel.add(fAutor);
		
		capitulo = new JLabel("Capitulo");
		capitulo.setBounds(600,220,25,25);
		panel.add(capitulo);
		fCapitulo = new JTextField(10);
		fCapitulo.setBounds(600,240,300,30);
		panel.add(fCapitulo);
		
		anadir = new JButton("Añadir");
		anadir.setBounds(700,450,25,25);
		panel.add(anadir);

		setVisible(true);
	}
}
