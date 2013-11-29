package fiuba.algo3.vista.pintores;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.Coordenada;

public class PintorCalle extends Pintor{

	final String PATH = "/imagenes/calle.png";
	
	public PintorCalle(Graphics unG) {
		super(unG);
	}
	
	@Override
	public void pintar(Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){
		ImageIcon imagenCalle = new ImageIcon(getClass().getResource(PATH));
		this.g.drawImage(imagenCalle.getImage(), unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);
	}
}