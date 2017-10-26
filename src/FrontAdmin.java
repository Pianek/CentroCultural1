import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.glass.events.MouseEvent;


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
		
	}
	//Método que se utilizada para colocar botones por coordenadas
//	GridBagConstraints restricciones = new GridBagConstraints();
//    setLayout(new GridBagLayout());
       
	public void init(){	
	   panelPrincipal = new JPanel();
       panelPrincipal.setLayout(new BorderLayout());
       
       panelBotones = new JPanel();
       panelIzquierda = new JPanel();
       panelDerecha= new JPanel();
       panelBotones.setLayout(new GridLayout(3, 2, 3, 3));
       panelPrincipal.add("Center", panelBotones);
       panelPrincipal.add("East", panelIzquierda);
       panelPrincipal.add("West", panelDerecha);
       getContentPane().add(panelPrincipal);
       
       
     		
		bCrear= new  JButton("Crear");
		bCrear.addMouseListener(new Click());
		
//		restricciones para poner botones con coordenadas
//		restricciones.gridx = 0;
//		restricciones.gridy = 2;
//		restricciones.gridwidth = 1;
//		restricciones.gridheight = 1;
//		this.getContentPane().add(bCrear, restricciones);
		
		bBorrar= new  JButton("Borrar");
		bBorrar.addMouseListener(new Click());

		
		bActualizar= new  JButton("Actualizar");
		bActualizar.addMouseListener(new Click());

		bAlquilar= new  JButton("Alquilar");
		bAlquilar.addMouseListener(new Click());

		
		bDevolver= new  JButton("Devolver");
		bDevolver.addMouseListener(new Click());
		
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
	
private class Click extends  MouseAdapter {
	public void mouseClicked(MouseEvent eve) {
		}
	}

}
