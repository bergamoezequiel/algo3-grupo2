package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.ContenidoDeCelda;

public abstract class ObjetoEncontrable extends ContenidoDeCelda implements Interactuable{

	@Override
	public void setCelda(Celda unaCelda){
		/*Coordenada coordenadaInicial = unaCelda.getCoordenada();
		
		if (coordenadaInicial.getX()%2 != 0 && coordenadaInicial.getY()%2 != 0){
			throw new UbicacionEnMapaException();
		}*/
		
		this.celda = unaCelda;
	}
	
}
