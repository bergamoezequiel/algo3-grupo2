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
		this.mapa = new Mapa (8, 8);
		this.conductor = new Conductor(new Auto());	
		this.mapa.getCeldaEn(new Coordenada(8,8)).agregarContenido(this.conductor);
		
		this.puntaje = 0;
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
