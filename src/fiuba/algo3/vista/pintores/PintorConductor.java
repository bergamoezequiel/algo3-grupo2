package fiuba.algo3.vista.pintores;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.vehiculos.*;

public class PintorConductor extends Pintor{

	public void pintar(Graphics g, Conductor unConductor, Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){		

		if (unConductor.getVehiculo() instanceof Moto){
			new PintorMoto().pintar(g, unaCoordenadaVista, anchoCelda, altoCelda, unConductor.getDireccion());
		}
		else if (unConductor.getVehiculo() instanceof Auto){
			new PintorAuto().pintar(g, unaCoordenadaVista, anchoCelda, altoCelda, unConductor.getDireccion());
		}
		else if (unConductor.getVehiculo() instanceof Auto){
			new PintorTodoTerreno().pintar(g, unaCoordenadaVista, anchoCelda, altoCelda, unConductor.getDireccion());
		}

	}
}