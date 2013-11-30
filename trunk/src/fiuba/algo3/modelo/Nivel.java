package fiuba.algo3.modelo;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public abstract class Nivel implements Observer {
	
	protected String nombre;
	protected Mapa mapa;
	protected Conductor conductor;
	protected int movimientosLimites;
	protected Juego juegoActual;
	protected int puntajePorMovimientoSobrante; 
	
	public Mapa getMapa(){
		return this.mapa;
	}
	
	public Conductor getConductor(){
		return this.conductor;
	}
	
	public int getMovimientosLimites(){
		return this.movimientosLimites;
	}
	
	public int getMovimientosRestantes(){
		return this.movimientosLimites - this.conductor.getMovimientos();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntaje(){
		return (getMovimientosRestantes() * puntajePorMovimientoSobrante);
	}
	
	public Juego getJuegoActual(){
		return juegoActual;
	}
	
	public int getPuntajePorMovimientosSobrantes(){
		return this.puntajePorMovimientoSobrante;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (getMovimientosRestantes() <= 0){
			this.juegoActual.perdio();
		}
		
		else if (this.conductor.getEncontroLlegada()){
			this.juegoActual.conductorAlcanzoLaLlegadaDelNivelActual();
		}
	}
}
