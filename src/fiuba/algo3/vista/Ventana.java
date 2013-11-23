package fiuba.algo3.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;


public class Ventana extends JFrame implements Observer {
	
	//private Juego juego;
	
	public Ventana(/*Juego unJuego*/){	
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				setTitle("Juego GPS CHALLENGE");
				setSize(640, 480); // Resolucion de la ventana
				setLocationRelativeTo(null); // Ubica la ventana en el centro de la pantalla
				inicializarConCosas();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				getContentPane(); 
				setResizable(false);
				setVisible(true); 

			}
		});
		
		//juego = unJuego;
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
		
		menu.add(opciones);
		menu.add(acercaDe);
		setJMenuBar(menu);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//System.out.println("prueba5");
	}
}