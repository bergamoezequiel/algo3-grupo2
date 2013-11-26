package fiuba.algo3.vista;

//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.GridLayout;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fiuba.algo3.controlador.*;
import fiuba.algo3.modelo.Juego;
//import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.vehiculos.Conductor;


public class Ventana extends JFrame implements Observer {

	private static final long serialVersionUID = 5555565620572460954L;
	final int RESOLUCIONX = 800;
	final int RESOLUCIONY = 600;
	
	private Juego juego;
			
	public Ventana(Juego unJuego, ControlPorTeclado unControl){	
		this.juego = unJuego;
		this.addKeyListener(unControl.getKeyListener());
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				setTitle("Juego GPS CHALLENGE");
				setSize(RESOLUCIONX, RESOLUCIONY);
				//setSize( (juego.getMapa().getCantidadDeFilas()- 2)*50 -10, (juego.getMapa().getCantidadDeColumnas() -1)*50 -5); // Resolucion de la ventana
				setLocationRelativeTo(null); // Ubica la ventana en el centro de la pantalla
				inicializarConCosas();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				getContentPane(); 
				setResizable(false);
				setVisible(true); 

			}
		});
		

	}

	public void inicializarConCosas(){
		JMenuBar menu  = new JMenuBar();
		JMenu opciones = new JMenu("Opciones");
		JMenu acercaDe = new JMenu("Acerca de..");
		
		JMenuItem opcionNuevaPartida = new JMenuItem("Nueva Partida");
		JMenuItem opcionGuardar = new JMenuItem("Guardar");
		JMenuItem opcionSalir = new JMenuItem("Salir");
		
		acercaDe.addMenuListener(new AcercaDeListener());
		opciones.add(opcionNuevaPartida);
		opciones.add(opcionGuardar);
		opciones.add(opcionSalir);
		
		opcionSalir.addActionListener(new BotonSalirListener());
		
		menu.add(opciones);
		menu.add(acercaDe);
		setJMenuBar(menu);
		
		Conductor unConductor = this.juego.getNivelActual().getConductor();
		if (unConductor != null){
			unConductor.addObserver(this);
		}
		
		//Aca estoy agregando el dibujito del mapa.
		add(new PantallaDelNivel(this.juego.getNivelActual()));
		
		//Harcodeo de avance hacia arriba del conductor para verificar el update del avanzar.
		//unConductor.avanzarEnDireccion(new Arriba());
		//unConductor.avanzarEnDireccion(new Derecha());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//Aca estoy agregando el dibujito del mapa.
		PantallaDelNivel unaPantallaDeNivel = new PantallaDelNivel(this.juego.getNivelActual());
		add(unaPantallaDeNivel);
		System.out.println(arg);
		repaint();
		
	}
}