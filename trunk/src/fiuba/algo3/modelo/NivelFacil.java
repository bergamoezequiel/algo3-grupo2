package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public class NivelFacil extends Nivel {
	
	public NivelFacil (Vehiculo unVehiculo){
		this.movimientosLimites = 100;
		this.mapa = new Mapa (4, 4);
		this.conductor = new Conductor(unVehiculo, 4);
		
		this.mapa.getCeldaEn(new Coordenada(0,0)).agregarContenido(this.conductor);
	}
}
