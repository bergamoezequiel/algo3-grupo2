package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelFacil extends Nivel {
	
	final int MOVIMIENTOS_LIMITES = 50;
	final int puntajePorPuntoSobrante = 1;
	
	public NivelFacil (Vehiculo unVehiculo){	
		this.mapa = new Mapa (8, 8);
		this.conductor = new Conductor(unVehiculo, 8);
		mapa.getCeldaEn(new Coordenada(2,5)).agregarContenido(new Llegada());
		
		this.mapa.getCeldaEn(new Coordenada(0,0)).agregarContenido(this.conductor);
	}
}



