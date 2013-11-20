package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.ContenidoDeCelda;
import fiuba.algo3.implementacion.mapa.UbicacionEnMapaException;

public abstract class ObjetoEncontrable extends ContenidoDeCelda implements Interactuable{

	@Override
	public void setCelda(Celda unaCelda) throws UbicacionEnMapaException {
		Coordenada coordenadaInicial = unaCelda.getCoordenada();
		if (coordenadaInicial.getX()%2 == 0 && coordenadaInicial.getY()%2 == 0){
			throw new UbicacionEnMapaException();
		}
		
		if (coordenadaInicial.getX()%2 != 0 && coordenadaInicial.getY()%2 != 0){
			throw new UbicacionEnMapaException();
		}
		this.celda = unaCelda;
	}
	
}
