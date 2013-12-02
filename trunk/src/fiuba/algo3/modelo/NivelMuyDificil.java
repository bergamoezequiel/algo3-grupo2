package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelMuyDificil extends Nivel {
	
	public NivelMuyDificil (Vehiculo unVehiculo,Juego juego){
		this.nombre = "Nivel Muy Dificil";
		this.movimientosLimites = 40;
		this.puntajePorMovimientoSobrante = 4;
		this.juegoActual=juego;
		this.mapa = new Mapa (8, 8);
		this.conductor = new Conductor(unVehiculo, new Derecha(), 3);
		this.getConductor().addObserver(this);
		
		mapa.getCeldaEn(new Coordenada(13,16)).agregarContenido(new Llegada());
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
		/*mapa.getCeldaEn(new Coordenada(17,0)).agregarContenido(new SorpresaFavorable());
		mapa.getCeldaEn(new Coordenada(19,0)).agregarContenido(new SorpresaFavorable());
		mapa.getCeldaEn(new Coordenada(15,2)).agregarContenido(new SorpresaDesfavorable());
		mapa.getCeldaEn(new Coordenada(17,2)).agregarContenido(new SorpresaDesfavorable());*/
		
	}
}
