package fiuba.algo3.implementacion.mapa;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;

public class MapaTest {
	@Test
	public void testDeberiaPoderCrearUnMapaConCiertaDimension(){
		Mapa unMapa = new Mapa(new Coordenada(4, 3));
		Assert.assertEquals(3, unMapa.getCantidadDeFilas());
		Assert.assertEquals(4, unMapa.getCantidadDeColumnas());
	}
	
	@Test
	public void testDeberiaObtenerCeldaDeUnaCoordenada(){
		Mapa unMapa = new Mapa(new Coordenada(4, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(3, 2));
		Assert.assertEquals(new Coordenada(3, 2), unaCelda.getCoordenada());
	}
	
	@Test
	public void testDeberiaSerInvalidaLaCoordenada(){
		Mapa unMapa = new Mapa (new Coordenada (4,4));
		Coordenada unaCoordenada = new Coordenada (5,5);
		Assert.assertEquals (false, unMapa.coordenadaValida(unaCoordenada));
	}
	
	@Test(expected = UbicacionEnMapaException.class) 
	public void testDeberiaLanzarExcepcionSiPidoUnaCeldaEnUnaCoordenadaFueraDeRango(){
		Mapa unMapa = new Mapa (new Coordenada (4, 4));
		//La ubicacion 4, 4 esta fuera del mapa, el mapa va de (0,0) a (3,3)
		Coordenada unaCoordenada = new Coordenada (4, 4);
		unMapa.getCeldaEn(unaCoordenada);
	}
	
	@Test(expected = UbicacionEnMapaException.class) 
	public void testDeberiaLanzarExcepcionSiPidoUnaCeldaEnUnaCoordenadaFueraDeRango2(){
		Mapa unMapa = new Mapa (new Coordenada (4, 4));
		//La ubicacion 4, 4 esta fuera del mapa, el mapa va de (0,0) a (3,3)
		Coordenada unaCoordenada = new Coordenada (-1, -1);
		unMapa.getCeldaEn(unaCoordenada);
	}
	
}