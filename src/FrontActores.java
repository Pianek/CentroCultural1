import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontActores extends JFrame {
	private Conexion conexion;
	private JPanel panelPrincipal;
	private JLabel nombreActor;
	private JLabel nombrePelicula;
	private JTextField fNombreActor;
	private JTextField fNombrePelicula;
	private ImageIcon iconoActor;
	private JButton anadirActor;
	private JButton atrasActor;
	private Usuario usuario;
	private JButton cerrarSesionActor;

	public FrontActores(Usuario usu) {
		usuario = usu;
		conexion = new Conexion();
		iconoActor = new ImageIcon("iconos\\chaplin.png");
		this.setTitle("Añade un actor");
		this.setSize(1000,500);	
		
		//setBounds(1000, 500, 1000, 1000);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(355, 500, 365, 500));			
		panelPrincipal.setLayout(new GridLayout(4, 2, 1, 5));
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		BorderLayout fondoEntero= new BorderLayout();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		getContentPane().add(panelPrincipal);

		JLabel icono_actor = new JLabel();
		icono_actor.setBounds(50, 100, 500, 500);
		icono_actor.setIcon(iconoActor);

		nombreActor = new JLabel("Nombre actor");
		panelPrincipal.add(nombreActor);

		fNombreActor = new JTextField(10);
		panelPrincipal.add(fNombreActor);

		nombrePelicula = new JLabel("Nombre Pelicula");
		panelPrincipal.add(nombrePelicula);

		fNombrePelicula = new JTextField(10);
		panelPrincipal.add(fNombrePelicula);

		anadirActor = new JButton("Añadir al reparto");
		anadirActor.addMouseListener(new crear());
		anadirActor.setBounds(750, 500, 100, 50);
		panelPrincipal.add(anadirActor);

		atrasActor = new JButton("Atrás");
		atrasActor.addMouseListener(new crear());
		atrasActor.setBounds(550, 500, 100, 50);
		panelPrincipal.add(atrasActor);

		panelPrincipal.add(icono_actor);
		cerrarSesionActor = new JButton("Cerrar Sesion");
		cerrarSesionActor.setBounds(600, 50, 10, 25);
		cerrarSesionActor.addMouseListener(new crear());
		panelPrincipal.add(cerrarSesionActor);

		panelPrincipal.setBackground(new Color(99, 193, 111));

		

	}

	class crear extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == atrasActor) {
				FrontCrearArticulo cr = new FrontCrearArticulo(usuario);
				cr.setVisible(true);
			}
			if (event.getSource() == cerrarSesionActor) {
				FrontLogin lg = new FrontLogin();
				lg.setVisible(true);

			}
			boolean valido=true;
			if(event.getSource()==anadirActor){
				int idActor = 0, idPeli = 0;
				
				//Buscar id del actor
				ResultSet rs = conexion.getResultSet("SELECT idActores FROM actores WHERE UPPER(Nombre) LIKE UPPER(" + nombreActor.getText() + ")");
				try {
					rs.next();
					idActor = rs.getInt(1);
				} catch (SQLException e) {
					System.out.println("No se ha encontrado id para el actor " + nombreActor.getText());
					e.printStackTrace();
				}
				
				//Buscar id del DVD
				rs = conexion.getResultSet("SELECT idDVD FROM dvd WHERE UPPER(titulo) LIKE UPPER(" + nombrePelicula.getText() + ")");
				try {
					rs.next();
					idPeli = rs.getInt(1);
				} catch (SQLException e) {
					System.out.println("No se ha encontrado id para la pelicula " + nombrePelicula.getText());
					e.printStackTrace();
				}
				
				relacionar(idActor,idPeli);
				
			}
		}
		
		public String  relacionar(int idActor, int idPeli){
			return ("");
			
		}
		
	}
}



