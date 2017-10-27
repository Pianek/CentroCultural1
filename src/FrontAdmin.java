import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrontAdmin extends JFrame{
	JPanel panelPrincipal;	
	JPanel panelBotones;
	JPanel panelIzquierda;
	JPanel panelDerecha;
	JButton bCrear;
	JButton bGestionar;
	JButton bAlquilar;
	JButton bDevolver;

	public FrontAdmin(){
		this.setTitle("Panel Administrador");
		this.setSize(300,300);
		init();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
		//Método que se utilizada para colocar botones por coordenadas
//		GridBagConstraints restricciones = new GridBagConstraints();
//    	setLayout(new GridBagLayout());
       
	public void init(){	
	   panelPrincipal = new JPanel();
	   panelPrincipal.setLayout(new BorderLayout());
       panelPrincipal.setBorder(new EmptyBorder(new Insets(300, 450, 300, 450)));
       
       panelBotones = new JPanel();
       panelIzquierda = new JPanel();
       panelDerecha= new JPanel();
       panelBotones.setLayout(new GridLayout(3, 2, 3, 3));
       panelPrincipal.add("Center", panelBotones);
       panelPrincipal.add("East", panelIzquierda);
       panelPrincipal.add("West", panelDerecha);
       getContentPane().add(panelPrincipal);
       
     		
       bCrear= new  JButton("Crear");
       bCrear.setFont(new Font("Arial", Font.PLAIN, 40));
       bCrear.addMouseListener(new MiClick());
		
       bGestionar = new  JButton("Gestionar");
       bGestionar.setFont(new Font("Arial", Font.PLAIN, 40));
       bGestionar.addMouseListener(new MiClick());

       bAlquilar= new  JButton("Alquilar");
       bAlquilar.setFont(new Font("Arial", Font.PLAIN, 40));
       bAlquilar.addMouseListener(new MiClick());

		
       bDevolver= new  JButton("Devolver");
       bDevolver.setFont(new Font("Arial", Font.PLAIN, 40));
       bDevolver.addMouseListener(new MiClick());
		
       //Se añaden los botones al panel
       panelBotones.add(bCrear);
       panelBotones.add(bGestionar);
	   panelBotones.add(bAlquilar);
	   panelBotones.add(bDevolver);
	    
	   panelPrincipal.setBackground(new Color (99,193,111));
	   panelIzquierda.setBackground(new Color (99,193,111));
	   panelDerecha.setBackground(new Color (99,193,111));
	   panelBotones.setBackground(new Color (99,193,111));
	   bCrear.setBackground(new Color (215,246,185));
	   bGestionar.setBackground(new Color (215,246,185));
	   bAlquilar.setBackground(new Color (215,246,185));
	   bDevolver.setBackground(new Color (215,246,185));
	}
		
	class MiClick extends  MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == bCrear) {
				FrontCrearArticulo frame = new FrontCrearArticulo();
				frame.setVisible(true);
			}
			
			if (event.getSource() == bGestionar){
				FrontActualizarBorrar frame = new FrontActualizarBorrar();
				frame.setVisible(true);
			}
			
			if (event.getSource() == bAlquilar){
				FrontAlquilar frame = new FrontAlquilar();
				frame.setVisible(true);
			}
			
//			if (event.getSource() == bDevolver){
//				FrontDevolverCD frame = new FrontDevolverCD();
//				frame.setVisible(true);
//			}
		}
	}
}
