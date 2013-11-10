package fiuba.algo3.implementacion.coordenadas;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;

public class DireccionTest {
	
	@Test
	public void testgetDireccionIzquierdaComoCoordenada(){
		Direccion unaDireccion = new Izquierda();
		Assert.assertEquals(new Coordenada(-1, 0), unaDireccion.getDireccionComoCoordenada());
	}

	@Test
	public void testgetDireccionDerechaComoCoordenada(){
		Direccion unaDireccion = new Derecha();
		Assert.assertEquals(new Coordenada(1, 0), unaDireccion.getDireccionComoCoordenada());
	}

	@Test
	public void testgetDireccionAbajoComoCoordenada(){
		Direccion unaDireccion = new Abajo();
		Assert.assertEquals(new Coordenada(0, -1), unaDireccion.getDireccionComoCoordenada());
	}
	
	@Test
	public void testgetDireccionArribaComoCoordenada(){
		Direccion unaDireccion = new Arriba();
		Assert.assertEquals(new Coordenada(0, 1), unaDireccion.getDireccionComoCoordenada());
	}
}