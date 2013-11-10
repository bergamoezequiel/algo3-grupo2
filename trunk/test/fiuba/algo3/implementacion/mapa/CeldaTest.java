package fiuba.algo3.implementacion.mapa;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;

public class CeldaTest{

	@Test
	public void testDeberiaInicializarceLaCeldaSinObjeto(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(0,0));
		Assert.assertNull(unaCelda.getContenido());
	}

	@Test
	public void testDeberiaInicializarceLaCeldaEnUnaCoordenada(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 2));
		Assert.assertEquals(new Coordenada(1, 2), unaCelda.getCoordenada());
	}
	
	@Test
	public void testDeberiaAgregarUnContenidoALaCelda(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 2));		
		Conductor unContenido = new Conductor(new Auto());
		unaCelda.agregarContenido(unContenido);
		Assert.assertEquals(unContenido, unaCelda.getContenido());
		Assert.assertEquals(unaCelda, unContenido.getCelda());	
	}
	
	@Test
	public void testDeberiaAgregarYLuegoQuitarUnContenidoDeLaCelda(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 2));
		Conductor unVehiculo = new Conductor(new Auto());		
		unaCelda.agregarContenido(unVehiculo);
		
		Assert.assertEquals (unVehiculo, unaCelda.getContenido());
		Assert.assertEquals (unaCelda, unVehiculo.getCelda());
		
		unaCelda.quitarContenido();
		
		Assert.assertNull (unaCelda.getContenido());
		Assert.assertNull (unVehiculo.getCelda());
	}

}

