package fiuba.algo3.implementacion.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;
import fiuba.algo3.implementacion.mapa.UbicacionEnMapaException;

public class ObjetoEncontrableTest {
	@Test(expected = UbicacionEnMapaException.class) 
	public void vehiculoDeberiaLanzarExcepcionSiSeCreaEnCoordenadaParXyParY(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Pozo unPozo = new Pozo();
		celdaInicial.agregarContenido(unPozo);
	}
	
	@Test(expected = UbicacionEnMapaException.class) 
	public void vehiculoDeberiaLanzarExcepcionSiSeCreaEnCoordenadaImParXyImParY(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(3, 3));
		Pozo unPozo = new Pozo();
		celdaInicial.agregarContenido(unPozo);
	}
}