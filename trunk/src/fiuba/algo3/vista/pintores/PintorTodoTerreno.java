package fiuba.algo3.vista.pintores;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.*;

public class PintorTodoTerreno extends Pintor{

	final String PATH_ARRIBA = "/imagenes/todoTerreno_arriba.png";
	final String PATH_ABAJO = "/imagenes/todoTerreno_abajo.png";
	final String PATH_IZQUIERDA = "/imagenes/todoTerreno_izquierda.png";
	final String PATH_DERECHA = "/imagenes/todoTerreno_derecha.png";
	
	public void pintar(Graphics g, Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda, Direccion unaDireccion){
		ImageIcon imagen = new ImageIcon(getClass().getResource(PATH_ARRIBA));
		
		if (unaDireccion instanceof Arriba){
			imagen = new ImageIcon(getClass().getResource(PATH_ARRIBA));
		}
		else if (unaDireccion instanceof Abajo){
			imagen = new ImageIcon(getClass().getResource(PATH_ABAJO));
		}
		else if (unaDireccion instanceof Izquierda){
			imagen = new ImageIcon(getClass().getResource(PATH_IZQUIERDA));
		}
		else if (unaDireccion instanceof Derecha){
			imagen = new ImageIcon(getClass().getResource(PATH_DERECHA));
		}
		
		g.drawImage(imagen.getImage(), unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);
	}
}