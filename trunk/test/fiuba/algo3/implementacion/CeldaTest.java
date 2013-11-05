package fiuba.algo3.implementacion;

import static org.junit.Assert.*;

import org.junit.Test;

public class CeldaTest{

	@Test
	public void testDeberiaInicializarceLaCeldaSinNingunVehiculo(){
		Celda celda = new Celda();
		assertEquals(null, celda.getVehiculo());	
	}
	
	@Test
	public void testDeberiaPoderPonerUnVehiculoEnUnaCelda(){
		Vehiculo unVehiculo = new Vehiculo();
		Celda celda = new Celda ();
		
		celda.setVehiculo( unVehiculo );
		
		assertEquals (unVehiculo, celda.getVehiculo());	
	}

}

