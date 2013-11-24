package fiuba.algo3.modelo;

import java.util.Observable;

import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.vista.Ventana;


public class Juego extends Observable {

	private Mapa mapa;
	private Conductor conductor;	
	private int puntaje;
	
	public Juego (){
		this.mapa = new Mapa (5, 5);
		this.conductor = new Conductor(new Auto());	
		this.mapa.getCeldaEn(new Coordenada(2,2)).agregarContenido(this.conductor);
		
		this.puntaje = 0;
		
		//Hago update para que cargue las posiciones iniciales de todo.
		this.setChanged();
		this.notifyObservers();
	}

	public Mapa getMapa(){
		return this.mapa;
	}
	
	public Conductor getConductor(){
		return this.conductor;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}

}
