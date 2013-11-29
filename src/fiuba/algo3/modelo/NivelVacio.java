package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.Llegada;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Vehiculo;

public class NivelVacio extends Nivel{		
		public NivelVacio (Vehiculo unVehiculo,Juego juego){	
			movimientosLimites = 500;
			puntajePorMovimientoSobrante = 1;
			this.juegoActual = juego;
			this.mapa = new Mapa (5, 5);
			this.conductor = new Conductor(unVehiculo, new Derecha(), 8);
			
			mapa.getCeldaEn(new Coordenada(6,9)).agregarContenido(new Llegada(this));
			mapa.getCeldaEn(new Coordenada(6,0)).agregarContenido(this.conductor);
		}

	}
