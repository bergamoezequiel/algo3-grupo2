package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelFacil extends Nivel {	
	
	public NivelFacil (Vehiculo unVehiculo,Juego juego){	
		this.nombre = "Nivel Facil";
		this.movimientosLimites = 50;
		this.puntajePorMovimientoSobrante = 1;
		this.juegoActual = juego;
		this.mapa = new Mapa (4, 4);
		this.conductor = new Conductor(unVehiculo, new Derecha(), 5);
		this.getConductor().addObserver(this);
		
		mapa.getCeldaEn(new Coordenada(7,0)).agregarContenido(new Llegada());
		mapa.getCeldaEn(new Coordenada(0,8)).agregarContenido(this.conductor);
		
		//Snorlaxs
		mapa.getCeldaEn(new Coordenada(0,1)).agregarContenido(new Snorlax());
		mapa.getCeldaEn(new Coordenada(1,4)).agregarContenido(new Snorlax());
		mapa.getCeldaEn(new Coordenada(6,1)).agregarContenido(new Snorlax());
		mapa.getCeldaEn(new Coordenada(6,3)).agregarContenido(new Snorlax());

		//Piquete
		mapa.getCeldaEn(new Coordenada(5,0)).agregarContenido(new Piquete());
	
		//Cambios de Vehiculo
		mapa.getCeldaEn(new Coordenada(3,0)).agregarContenido(new CambioDeVehiculo());
		mapa.getCeldaEn(new Coordenada(0,5)).agregarContenido(new CambioDeVehiculo());
		
		//Controles Policiales
		mapa.getCeldaEn(new Coordenada(3,2)).agregarContenido(new ControlPolicial());
	
		//Pozos
		mapa.getCeldaEn(new Coordenada(1,8)).agregarContenido(new Pozo());
		
		//Sorpresas Desfavorables
		mapa.getCeldaEn(new Coordenada(7,8)).agregarContenido(new SorpresaDesfavorable());
		mapa.getCeldaEn(new Coordenada(5,6)).agregarContenido(new SorpresaDesfavorable());

		//Sorpresa Favorables
		mapa.getCeldaEn(new Coordenada(3,6)).agregarContenido(new SorpresaDesfavorable());
	
	
	}
}


