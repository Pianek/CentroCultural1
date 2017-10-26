import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrontAnadirCD extends JFrame{
	JPanel panel;
	JLabel id;
	JLabel titulo;
	JLabel discografia;
	JLabel stock;
	JLabel cantante;
	JTextField fId;
	JTextField fTitulo;
	JTextField fDiscografia;
	JTextField fStock;
	JTextField fCantante;
	JButton anadir;
	
	
	public FrontAnadirCD() {
		this.setTitle("CD");
		this.setSize(1000,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		id = new JLabel("idCD");
		fId = new JTextField(10);
		
		
		
		titulo = new JLabel("Titulo");
		fTitulo = new JTextField(10);
		
		discografia = new JLabel("Discografía");
		fDiscografia = new JTextField(10);
		
		stock = new JLabel("Stock");
		fStock = new JTextField(10);
		
		cantante = new JLabel("Cantante");
		fCantante = new JTextField(10);
		
		anadir = new JButton("Añadir");
		
		panel = new JPanel();
		add(panel);
		panel.add(id);
		panel.add(fId);
		panel.add(titulo);
		panel.add(fTitulo);
		panel.add(discografia);
		panel.add(fDiscografia);
		panel.add(stock);
		panel.add(fStock);
		panel.add(cantante);
		panel.add(fCantante);
		panel.add(anadir);
		
		setVisible(true);
	}
}
