import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrontAnadirDVD extends JFrame{
	
	JPanel panel;
	JLabel id;
	JLabel titulo;
	JLabel director;
	JLabel stock;
	JLabel productora;
	JTextField fId;
	JTextField fTitulo;
	JTextField fDirector;
	JTextField fStock;
	JTextField fProductora;
	JButton anadir;
	
	public FrontAnadirDVD() {
		panel = new JPanel();
		this.setTitle("DVD");
		this.setSize(500,100);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		add(panel);
		id = new JLabel("idLibro");
		id.setBounds(300,120,25,25);
		panel.add(id);
		fId = new JTextField(10);
		fId.setBounds(300, 150, 300, 30);
		panel.add(fId);
		
		titulo = new JLabel("Titulo");
		titulo.setBounds(300, 180, 25,25);
		panel.add(titulo);
		fTitulo = new JTextField(10);
		fTitulo.setBounds(300, 200,300,30);
		panel.add(fTitulo);
		
		director = new JLabel("Número de páginas");
		director.setBounds(300,220,25,25);
		panel.add(director);
		fDirector = new JTextField(10);
		fDirector.setBounds(300,240,300,30 );
		panel.add(fDirector);
		
		stock = new JLabel("Stock");
		stock.setBounds(600,120,25,25);
		panel.add(stock);
		fStock = new JTextField(10);
		fStock.setBounds(600,150,300,30);
		panel.add(fStock);
		
		productora = new JLabel("Autor");
		productora.setBounds(600,180,25,25);
		panel.add(productora);
		fProductora = new JTextField(10);
		fProductora.setBounds(600,200,300,30);
		panel.add(fProductora);
				
		anadir = new JButton("Añadir");
		anadir.setBounds(700,450,25,25);
		panel.add(anadir);

		setVisible(true);
	}
}

