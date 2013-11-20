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


public class Ventana extends JFrame implements KeyListener, Observer {
	
	public Ventana(){	
		setTitle("Juego GPS CHALLENGE");
		setSize(640, 480); // Resolucion de la ventana
		setLocationRelativeTo(null); // Ubica la ventana en el centro de la pantalla
		inicializarConCosas();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Ventana unaVentana = new Ventana(); 
				unaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				unaVentana.getContentPane(); 
				unaVentana.setResizable(false);
				unaVentana.setVisible(true);               
			}
		});
	}

	public void inicializarConCosas(){
		JMenuBar menu = new JMenuBar();
		JMenu opciones= new JMenu("Opciones");
		JMenu about= new JMenu("About");
				
		JMenuItem opcionGuardar = new JMenuItem("Guardar");
		JMenuItem opcionVerPuntaje= new JMenuItem("Ver Puntaje");
		JMenuItem opcionSalir = new JMenuItem("Salir");
		
		about.addMenuListener(new AboutListener());
		//this.salir=opcionSalir;
		opciones.add(opcionGuardar);
		opciones.add(opcionVerPuntaje);
		opciones.add(opcionSalir);
		
		
		
		menu.add(opciones);
		menu.add(about);
		setJMenuBar(menu);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}
}