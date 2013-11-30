package fiuba.algo3.vista.pintores;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.Coordenada;

public class PintorZonaNoVisible extends Pintor{

	public void pintar(Graphics g, Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){
		g.setColor(Color.black);
		g.fillRect(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);
	}
}