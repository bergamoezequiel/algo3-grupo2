package fiuba.algo3.vista.pintores;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import fiuba.algo3.modelo.coordenadas.Coordenada;

public class PintorConductor extends Pintor{

	final String PATH = "/imagenes/auto.png";
	
	public PintorConductor(Graphics unG) {
		super(unG);
	}
	
	@Override
	public void pintar(Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){
		ImageIcon imagenConductor = new ImageIcon(getClass().getResource(PATH));
		g.drawImage(imagenConductor.getImage(), unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);
	}
}