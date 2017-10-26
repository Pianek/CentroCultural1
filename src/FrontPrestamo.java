import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.MouseEvent;

public class FrontPrestamo extends JFrame {
	private JPanel panel;
	private JButton alquilar;
	private JButton devolver;
	private Color colorFondo;
	
	public FrontPrestamo() {
		this.setTitle("Panel usuario");
		this.setSize(1000,1000);
		init();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void init() {	
		panel = new JPanel();
		GridLayout grid = new GridLayout();
		panel.setBackground(colorFondo=new Color (99,193,111));
		panel.setLayout(grid);
		grid.setHgap(50);
		panel.setBorder(new EmptyBorder(350,400,350,400));
		add(panel);
		
		alquilar = new JButton("Alquilar");
		alquilar.setFont(new Font("Arial", Font.PLAIN, 40));
		alquilar.setBackground(colorFondo=new Color (215,246,185));
		panel.add(alquilar);
		
		devolver = new JButton("Devolver");
		devolver.setFont(new Font("Arial", Font.PLAIN, 40));
		devolver.setBackground(colorFondo=new Color (215,246,185));
		panel.add(devolver);
	}
	
	public class Click extends MouseAdapter{
		public void mouseClicked(MouseEvent evento) {
				
		}
	}
}
