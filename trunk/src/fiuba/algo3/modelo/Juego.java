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
		Ventana unaVentana = new Ventana(this); //Observador
		this.addObserver(unaVentana);
		
		this.mapa = new Mapa (new Coordenada(11, 11));
		this.mapa.addObserver(unaVentana);
		
		this.conductor = new Conductor(new Auto());	
		this.conductor.addObserver(unaVentana);
		
		this.mapa.getCeldaEn(new Coordenada(0,0)).agregarContenido(this.conductor);
		
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
