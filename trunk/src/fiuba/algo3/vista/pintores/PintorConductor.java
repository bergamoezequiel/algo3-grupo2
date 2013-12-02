package fiuba.algo3.vista.pintores;

import java.awt.Graphics;
import java.util.Hashtable;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.NivelVacio;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.vehiculos.*;


public class PintorConductor extends PintorVehiculo{

	private Hashtable<Class<?>, PintorVehiculo> indice;
	
	public PintorConductor(){
		
		this.indice = new Hashtable<Class<?>, PintorVehiculo>();
		
		this.indice.put(Moto.getInstancia().getClass(), new PintorMoto());
		this.indice.put(Auto.getInstancia().getClass(), new PintorAuto());
		this.indice.put(TodoTerreno.getInstancia().getClass(), new PintorTodoTerreno());
	}
	
	public void pintar(Graphics g, Conductor unConductor, Coordenada unaCoordenadaVista, int anchoCelda, int altoCelda){		
		
		this.indice.get(unConductor.getVehiculo().getClass()).pintar(g, unaCoordenadaVista, anchoCelda, altoCelda, unConductor.getDireccion());
	}
}