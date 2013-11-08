package fiuba.algo3.implementacion;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;


public class CeldaTest{

	@Test
	public void testDeberiaInicializarceLaCeldaSinObjeto(){
		Celda celda = new Celda(new Posicion(2,3));
		Assert.assertNull(celda.getContenido());	
	}
	
	@Test
	public void testDeberiaPonerUnObjetoEnLaCelda(){
		Celda unaCelda = new Celda(new Posicion(2,3));		
		ContenidoDeCelda unObjeto = new ContenidoDeCelda();
		unaCelda.setObjeto(unObjeto);
		Assert.assertEquals(unObjeto, unaCelda.getContenido());	
	}
	
	@Test
	public void testDeberiaPonerUnObjetoEnUnaCeldaYQuitarlo(){
		Celda unaCelda = new Celda (new Posicion (2,3));
		Vehiculo unVehiculo = new Vehiculo(new Mapa(0,0));		
		unaCelda.setObjeto(unVehiculo);
		
		assertEquals (unaCelda.getContenido(), unVehiculo);
		
		unaCelda.desligarseDeSuObjeto();
		
		assertEquals (unaCelda.getContenido(), null);
	}

}

