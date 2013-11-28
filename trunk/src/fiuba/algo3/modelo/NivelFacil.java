package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelFacil extends Nivel {
	
	
	
	
	public NivelFacil (Vehiculo unVehiculo,Juego juego){	
		movimientosLimites =50;
		puntajePorMovimientoSobrante = 1;
		this.juegoActual=juego;
		this.mapa = new Mapa (8, 8);
		this.conductor = new Conductor(unVehiculo, 8);
		mapa.getCeldaEn(new Coordenada(15,2)).agregarContenido(new Llegada(this));
		
		this.mapa.getCeldaEn(new Coordenada(0,0)).agregarContenido(this.conductor);
	}
}


