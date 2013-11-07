package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class CeldaTest{

	@Test
	public void testDeberiaInicializarceLaCeldaSinNingunVehiculo(){
		Celda celda = new Celda();
		Assert.assertEquals(null, celda.getVehiculo());	
	}
	
	@Test
	public void testDeberiaPoderPonerUnVehiculoEnUnaCelda(){
		Mapa unMapa = new Mapa(2,2);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		Celda unaCelda = unMapa.getCeldaEnPos(0,0);

		unaCelda.setVehiculo(unVehiculo);
		
		Assert.assertEquals (unVehiculo, unaCelda.getVehiculo());	
	}

}

