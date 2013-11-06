package fiuba.algo3.implementacion;

import static org.junit.Assert.*;

import org.junit.Test;


public class MapaTest {

	@Test
	public void testDeberiaPoderCrearUnMapaConCiertoTamaño(){
		Mapa unMapa = new Mapa(3,4);
		assertEquals(3, unMapa.getCantidadDeColumnas());
		assertEquals(4, unMapa.getCantidadDeFilas());
	}
	
	@Test 
	public void testAlCrearUnMapaDeberiaTenerTodasLasCeldasSinVehiculos(){
		Mapa unMapa = new Mapa (3,3);
		for (int i = 0; i < unMapa.getCantidadDeColumnas(); i++) {
			for (int j = 0; j < unMapa.getCantidadDeFilas(); j++) {
				assertEquals (null, unMapa.getVehiculoEnPosicion(i, j));
			}			
		}
							
	}
	
	@Test
	public void testDeberiaPoderPonerUnVehiculoEnUnaCeldaDelMapa(){
		Mapa unMapa = new Mapa (3,3);
		Vehiculo unVehiculo = new Vehiculo();
		unMapa.setVehiculoEnPosicion(unVehiculo, 0, 0);
		
		assertEquals (unVehiculo, unMapa.getVehiculoEnPosicion(0, 0));
	}

	

	
}
