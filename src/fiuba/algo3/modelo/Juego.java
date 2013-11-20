package fiuba.algo3.modelo;

import java.util.Observer;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;
import fiuba.algo3.modelo.coordenadas.*;


public class Juego {

	private Observer observador;
	private Mapa mapa;
	private Conductor conductor;	
	private int puntaje;
	
	public Juego (){
		this.puntaje  = 0;
		this.mapa= new Mapa (new Coordenada(11, 11));
		this.conductor = new Conductor(new Auto());	
	}

	public void agregarObservador(Observer unObservador){
		this.observador = unObservador;
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
