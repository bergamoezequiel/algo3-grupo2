package fiuba.algo3.vista.pintores;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.Coordenada;

public class PintorManzana extends Pintor{

	final String PATH = "/imagenes/manzana.png";
	
	public PintorManzana(Graphics unG) {
		super(unG);
	}
	
	@Override
	public void pintar(Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){
		ImageIcon imagenManzana = new ImageIcon(getClass().getResource(PATH));
		this.g.drawImage(imagenManzana.getImage(), unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);
	}
}