package fiuba.algo3.vista.pintores;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.Coordenada;

public class PintorLlegada extends Pintor{

	final String PATH = "/imagenes/llegada.png";
	
	public PintorLlegada(Graphics unG) {
		super(unG);
	}
	
	@Override
	public void pintar(Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){
		ImageIcon imagenLlegada = new ImageIcon(getClass().getResource(PATH));
		this.g.drawImage(imagenLlegada.getImage(), unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);
	}
}