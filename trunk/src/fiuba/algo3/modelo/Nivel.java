package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class Nivel {
	
	private Mapa mapa;
	private Conductor conductor;
	private int movimientosLimites;
	
	public Nivel (int unaDificultad, Vehiculo unVehiculo){		
		this.movimientosLimites = 60;
		this.mapa = new Mapa (8, 8);
		this.conductor = new Conductor(unVehiculo, 4);
		
		this.mapa.getCeldaEn(new Coordenada(8,8)).agregarContenido(this.conductor);
		this.mapa.getCeldaEn(new Coordenada(8,9)).agregarContenido(new Pozo());
		this.mapa.getCeldaEn(new Coordenada(1,2)).agregarContenido(new Piquete());
		this.mapa.getCeldaEn(new Coordenada(2,3)).agregarContenido(new CambioDeVehiculo());
	}
	
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
}
