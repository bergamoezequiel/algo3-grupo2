package fiuba.algo3.vista;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;


public class MainClass extends Canvas {
	
	private int MARGEN_IZQUIERDO= 0;
	private int MARGEN_SUPERIOR = 0;
	private int DIMENSION_CUADRADO = 40;
	private Juego juego;

	
	
	public MainClass(Juego unJuego){
		/*
		 * Esto es lo que se ejecuta cuando se llama al constructor de la clase.
		 * Luego dellamarse al constructor, automaticamente se llama al metodo
		 * PAINT.
		 */
		setBackground(Color.gray);
		this.juego = unJuego;
		
	}
	
	public void paint(Graphics g) {
  
		Graphics2D g2 = (Graphics2D) g;		
		Conductor unConductor = new Conductor (new Auto());
		
		//Agrega al conductor en el (0,0)
		Celda unaCelda = this.juego.getMapa().getCeldaEn(new Coordenada(0, 0));
		unaCelda.agregarContenido(unConductor);		
		
		int filaActual = 0;
		int columnaActual = 0;
		
		//Pintando todo de Gris Oscuro.
		for (int i = 0; i < this.juego.getMapa().getCantidadDeFilas(); i++) {
			for (int j = 0; j < this.juego.getMapa().getCantidadDeColumnas(); j++) {
				g.setColor(Color.darkGray);
				g.fillRect(MARGEN_IZQUIERDO + columnaActual, MARGEN_SUPERIOR + filaActual, DIMENSION_CUADRADO, DIMENSION_CUADRADO);
				columnaActual +=DIMENSION_CUADRADO;    
			}
			filaActual += DIMENSION_CUADRADO;
			columnaActual = 0;
		}  
    
		
		//Pintando las MANZANAS de naranja.
		filaActual = DIMENSION_CUADRADO;
		columnaActual = DIMENSION_CUADRADO;
		for ( int i = 1; i < this.juego.getMapa().getCantidadDeFilas(); i+=2 ) {
			for (int j = 1; j < this.juego.getMapa().getCantidadDeColumnas(); j+=2) {
				g.setColor(Color.orange);
				g.fillRect(MARGEN_IZQUIERDO + columnaActual, MARGEN_SUPERIOR + filaActual, DIMENSION_CUADRADO, DIMENSION_CUADRADO);
				columnaActual +=DIMENSION_CUADRADO*2;       
			}  
			filaActual +=DIMENSION_CUADRADO*2;
			columnaActual = DIMENSION_CUADRADO;
		}
		
		
		
		/*
		 * DESCOMENTAR Y VER COMO SE VA MOVIENDO
		 */
		
		//unConductor.avanzarEnDireccion(new Arriba() );
		//unConductor.avanzarEnDireccion(new Derecha() );
		//unConductor.avanzarEnDireccion(new Abajo() );
		//unConductor.avanzarEnDireccion(new Izquierda() );
		//unConductor.avanzarEnDireccion(new Arriba() );
		//unConductor.avanzarEnDireccion(new Arriba() );
		
		/*
		 * ASI SE MUEVE EL AUTO
		 */
		g.setColor(Color.red);
		g.fillArc(MARGEN_IZQUIERDO + DIMENSION_CUADRADO*unConductor.getCelda().getCoordenada().getX() , MARGEN_SUPERIOR + DIMENSION_CUADRADO*(this.juego.getMapa().getCantidadDeColumnas()-1 - unConductor.getCelda().getCoordenada().getY()), DIMENSION_CUADRADO, DIMENSION_CUADRADO, 360, 360);				
	}
	
	

  
/*
 * Esto no se deberia ejecutar NUNCA, ejecutar el Main.java para ver las cosas. 
 */
public static void main(String[] args) {
	
    JFrame frame = new JFrame();
    //frame.getContentPane().add(new MainClass(new Juego()));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setVisible(true);
    frame.setBackground(Color.white);
    frame.setTitle("GPS BATTLE v1.0");
  }
}