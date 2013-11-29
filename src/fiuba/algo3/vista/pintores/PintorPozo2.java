package fiuba.algo3.vista.pintores;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.Coordenada;

public class PintorPozo2 extends Pintor{

	final String PATH = "/imagenes/pozo.png";
	
	public PintorPozo2(Graphics unG) {
		super(unG);
	}

	@Override
	public void pintar(Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){
		ImageIcon imagenPozo = new ImageIcon(getClass().getResource(PATH));
		this.g.drawImage(imagenPozo.getImage(), unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);
	}
}
