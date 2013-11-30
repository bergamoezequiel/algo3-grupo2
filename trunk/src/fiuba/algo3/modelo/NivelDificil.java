package fiuba.algo3.modelo;

import java.util.Observable;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelDificil extends Nivel {
	
	public NivelDificil (Vehiculo unVehiculo, Juego juego){
		this.nombre = "Nivel Dificil";
		this.movimientosLimites = 40;
		this.puntajePorMovimientoSobrante = 3;
		this.juegoActual = juego;
		this.mapa = new Mapa (10, 10);
		this.conductor = new Conductor(unVehiculo, new Derecha(), 5);
		this.getConductor().addObserver(this);
		
		mapa.getCeldaEn(new Coordenada(18,5)).agregarContenido(new Llegada());
		mapa.getCeldaEn(new Coordenada(0,0)).agregarContenido(this.conductor);
		
		mapa.getCeldaEn(new Coordenada(1,0)).agregarContenido(new Pozo());
		mapa.getCeldaEn(new Coordenada(1,2)).agregarContenido(new Piquete());
		mapa.getCeldaEn(new Coordenada(4,3)).agregarContenido(new ControlPolicial());
		mapa.getCeldaEn(new Coordenada(7,2)).agregarContenido(new Pozo());
		mapa.getCeldaEn(new Coordenada(2,5)).agregarContenido(new Piquete());
		mapa.getCeldaEn(new Coordenada(6,3)).agregarContenido(new ControlPolicial());
		mapa.getCeldaEn(new Coordenada(4,3)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(2,5)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(4,3)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(7,8)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(9,2)).agregarContenido(new CambioDeVehiculo());
	}
}
