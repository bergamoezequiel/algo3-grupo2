package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelModerado extends Nivel {
	
	public NivelModerado (Vehiculo unVehiculo,Juego juego){
		this.nombre = "Nivel Moderado";
		this.movimientosLimites = 40;
		this.puntajePorMovimientoSobrante = 2;
		this.juegoActual = juego;
		this.mapa = new Mapa (5, 5);
		this.conductor = new Conductor(unVehiculo, new Derecha(), 6);
		this.getConductor().addObserver(this);
		
		mapa.getCeldaEn(new Coordenada(1,10)).agregarContenido(new Llegada());
		mapa.getCeldaEn(new Coordenada(10,2)).agregarContenido(this.conductor);
		
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