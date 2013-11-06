package fiuba.algo3.implementacion;

import static org.junit.Assert.*;


import org.junit.Test;


public class MapaTest {

	@Test
	public void testDeberiaPoderCrearUnMapaConCiertoLarga(){
		Mapa mapa = new Mapa(4,3);
		assertEquals(4, mapa.getCantidadDeFilas());
		assertEquals (3, mapa.getCantidadDeColumnas());
	}
	
	@Test 
	public void testDeberiaTenerTodasLasCeldasSinVehiculos(){
		Mapa mapa = new Mapa (5,3);
		for (int i = 0; i < mapa.getCantidadDeFilas(); i++) {
			for (int j = 0; j < mapa.getCantidadDeColumnas(); j++) {
				assertEquals (null, mapa.getVehiculoEnPosicion(i, j));
			}			
		}
							
	}
	
	@Test
	public void testDeberiaPoderPonerUnVehiculoEnUnaCeldaDelMapa(){
		Mapa mapa = new Mapa (3,2);
		Vehiculo unVehiculo = new Vehiculo();
		mapa.setVehiculoEnPosicion(unVehiculo, 1, 0);
		
		assertEquals (unVehiculo , mapa.getVehiculoEnPosicion(1, 0));
	}
	
}
