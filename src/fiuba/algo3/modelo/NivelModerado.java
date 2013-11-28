package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelModerado extends Nivel {
	
	
	
	public NivelModerado (Vehiculo unVehiculo,Juego juego){
		movimientosLimites=30;
		puntajePorMovimientoSobrante = 2;
		this.juegoActual=juego;
		this.mapa = new Mapa (8, 8);
		this.conductor = new Conductor(unVehiculo, 6);
		
		mapa.getCeldaEn(new Coordenada(1,16)).agregarContenido(new Llegada(this));
		mapa.getCeldaEn(new Coordenada(14,2)).agregarContenido(this.conductor);
		
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
