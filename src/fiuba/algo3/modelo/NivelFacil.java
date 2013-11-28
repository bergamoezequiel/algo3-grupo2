package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelFacil extends Nivel {	
	
	public NivelFacil (Vehiculo unVehiculo,Juego juego){	
		movimientosLimites = 50;
		puntajePorMovimientoSobrante = 1;
		this.juegoActual = juego;
		this.mapa = new Mapa (6, 6);
		this.conductor = new Conductor(unVehiculo, 7);
		
		mapa.getCeldaEn(new Coordenada(11,12)).agregarContenido(new Llegada(this));
		mapa.getCeldaEn(new Coordenada(0,0)).agregarContenido(this.conductor);
		
		mapa.getCeldaEn(new Coordenada(1,0)).agregarContenido(new Pozo());
		mapa.getCeldaEn(new Coordenada(0,1)).agregarContenido(new Snorlax());
		mapa.getCeldaEn(new Coordenada(1,2)).agregarContenido(new Piquete());
		mapa.getCeldaEn(new Coordenada(8,11)).agregarContenido(new ControlPolicial());
		mapa.getCeldaEn(new Coordenada(12,3)).agregarContenido(new Pozo());
		mapa.getCeldaEn(new Coordenada(2,5)).agregarContenido(new Piquete());
		mapa.getCeldaEn(new Coordenada(6,3)).agregarContenido(new ControlPolicial());
		mapa.getCeldaEn(new Coordenada(4,3)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(2,5)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(12,1)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(7,8)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(9,2)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(10,9)).agregarContenido(new SorpresaFavorable());
		mapa.getCeldaEn(new Coordenada(10,1)).agregarContenido(new SorpresaFavorable());
		mapa.getCeldaEn(new Coordenada(9,2)).agregarContenido(new SorpresaDesfavorable());
		mapa.getCeldaEn(new Coordenada(9,6)).agregarContenido(new SorpresaDesfavorable());
	}
}


