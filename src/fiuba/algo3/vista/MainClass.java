package fiuba.algo3.vista;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;


public class MainClass extends JPanel {
	
	private int MARGEN_IZQUIERDO= 0;
	private int MARGEN_SUPERIOR = 0;
	private int DIMENSION_CUADRADO = 40;

	public void paint(Graphics g) {
  
		Graphics2D g2 = (Graphics2D) g;
	
		
		Mapa unMapa = new Mapa(new Coordenada(11, 11));
		Conductor unConductor = new Conductor (new Auto());
		
		
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(0, 0));
		unaCelda.agregarContenido(unConductor);
		
		
		int filaActual = 0;
		int columnaActual = 0;
		
		//Pintando todo de Gris.
		for (int i = 0; i < unMapa.getCantidadDeFilas(); i++) {
			for (int j = 0; j < unMapa.getCantidadDeColumnas(); j++) {
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
		for ( int i = 1; i < unMapa.getCantidadDeFilas(); i+=2 ) {
			for (int j = 1; j < unMapa.getCantidadDeColumnas(); j+=2) {
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
		g.fillArc(MARGEN_IZQUIERDO + DIMENSION_CUADRADO*unConductor.getCelda().getCoordenada().getX() , MARGEN_SUPERIOR + DIMENSION_CUADRADO*(unMapa.getCantidadDeColumnas()-1 - unConductor.getCelda().getCoordenada().getY()), DIMENSION_CUADRADO, DIMENSION_CUADRADO, 360, 360);		
		
		
		
		
	}
	
	

  
  public static void main(String[] args) {
	
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClass());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setVisible(true);
    frame.setBackground(Color.white);
    frame.setTitle("GPS BATTLE v1.0");
  }
}