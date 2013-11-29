package fiuba.algo3.vista.pintores;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.Coordenada;

public class PintorControlPolicial extends Pintor{

	final String PATH = "/imagenes/controlPolicial.png";
	
	public PintorControlPolicial(Graphics unG) {
		super(unG);
	}
	
	@Override
	public void pintar(Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){
		ImageIcon imagenControlPolicial = new ImageIcon(getClass().getResource(PATH));
		this.g.drawImage(imagenControlPolicial.getImage(), unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);
	}
}