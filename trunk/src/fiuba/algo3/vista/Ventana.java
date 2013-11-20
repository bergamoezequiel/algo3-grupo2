package fiuba.algo3.vista;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Mapa;


public class Ventana extends JPanel {
	
	private int MARGEN_IZQUIERDO= 100;
	private int MARGEN_SUPERIOR = 75;
	private int DIMENSION_CUADRADO = 40;

	public void paint(Graphics g) {
  
		Graphics2D g2 = (Graphics2D) g;
		
    
		Mapa unMapa = new Mapa(new Coordenada(11, 11));
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
	}

  
  public static void main(String[] args) {
	
    JFrame frame = new JFrame();
    frame.getContentPane().add(new Ventana());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 800);
    frame.setVisible(true);
    frame.setBackground(Color.white);
    frame.setTitle("GPS BATTLE v1.0");
  }
}