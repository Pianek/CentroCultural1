import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




// Falta diseño  del panel
public class FrontAdmin extends JFrame{
	JPanel panelPrincipal;	
	JPanel panelBotones;
	JPanel panelIzquierda;
	JPanel panelDerecha;
	JButton bCrear;
	JButton bBorrar;
	JButton bActualizar;
	JButton bAlquilar;
	JButton bDevolver;
	Color colorFondo;

	public FrontAdmin(){
		this.setTitle("Panel Administrador");
		this.setSize(300,300);
		init();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
	//Método que se utilizada para colocar botones por coordenadas
//	GridBagConstraints restricciones = new GridBagConstraints();
//    setLayout(new GridBagLayout());
       
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
		
//		restricciones para poner botones con coordenadas
//		restricciones.gridx = 0;
//		restricciones.gridy = 2;
//		restricciones.gridwidth = 1;
//		restricciones.gridheight = 1;
//		this.getContentPane().add(bCrear, restricciones);
		
		bBorrar= new  JButton("Borrar");
		bBorrar.setFont(new Font("Arial", Font.PLAIN, 40));
		bBorrar.addMouseListener(new MiClick());

		
		bActualizar= new  JButton("Actualizar");
		bActualizar.setFont(new Font("Arial", Font.PLAIN, 40));
		bActualizar.addMouseListener(new MiClick());

		bAlquilar= new  JButton("Alquilar");
		bAlquilar.setFont(new Font("Arial", Font.PLAIN, 40));
		bAlquilar.addMouseListener(new MiClick());

		
		bDevolver= new  JButton("Devolver");
		bDevolver.setFont(new Font("Arial", Font.PLAIN, 40));
		bDevolver.addMouseListener(new MiClick());
		
		//Se añaden los botones al panel
		panelBotones.add(bCrear);
	    panelBotones.add(bBorrar);
	    panelBotones.add(bActualizar);
	    panelBotones.add(bAlquilar);
	    panelBotones.add(bDevolver);
	    
	    panelPrincipal.setBackground(colorFondo=new Color (99,193,111));
	    panelIzquierda.setBackground(colorFondo=new Color (99,193,111));
	    panelDerecha.setBackground(colorFondo=new Color (99,193,111));
	    panelBotones.setBackground(colorFondo=new Color (99,193,111));
		bCrear.setBackground(colorFondo=new Color (215,246,185));
		bBorrar.setBackground(colorFondo=new Color (215,246,185));
		bActualizar.setBackground(colorFondo=new Color (215,246,185));
		bAlquilar.setBackground(colorFondo=new Color (215,246,185));
		bDevolver.setBackground(colorFondo=new Color (215,246,185));
		
	
			

	}
		
	class MiClick extends  MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == bCrear) {
				FrontArticulo frame = new FrontArticulo();
				frame.setVisible(true);
			}
			//Se necesita modificar
			if (event.getSource() == bBorrar){
				FrontActualizarBorrarCD frame = new FrontActualizarBorrarCD();
				frame.setVisible(true);
			}
			//Se necesita modificar
			if (event.getSource() == bBorrar){
				FrontActualizarBorrarDVD frame = new FrontActualizarBorrarDVD();
				frame.setVisible(true);
			}
			if (event.getSource() == bAlquilar){
				FrontAlquilarCD frame = new FrontAlquilarCD();
				frame.setVisible(true);
			}
//			if (event.getSource() == bDevolver){
//				FrontDevolverCD frame = new FrontDevolverCD();
//				frame.setVisible(true);
//			}
			
		}
	
	}

	      


}
