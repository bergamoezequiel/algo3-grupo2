package fiuba.algo3.implementacion;

import static org.junit.Assert.*;

import org.junit.Test;


public class MapaTest {

	@Test
	public void testDeberiaPoderCrearUnMapaConCiertoLarga(){
		Mapa mapa = new Mapa(3,3);
		assertEquals(3, mapa.getCantidadDeFilas());
		assertEquals (3, mapa.getCantidadDeColumnas());
	}
	
	@Test 
	public void testDeberiaTenerTodasLasCeldasSinVehiculos(){
		Mapa mapa = new Mapa (3,3);
		for (int i = 0; i < mapa.getCantidadDeColumnas(); i++) {
			for (int j = 0; j < mapa.getCantidadDeFilas(); j++) {
				assertEquals (null, mapa.getCeldaEnPos(1,1).getVehiculo());
			}			
		}
							
	}
	
	@Test
	public void testDeberiaPoderPonerUnVehiculoEnUnaCeldaDelMapa(){
		Mapa mapa = new Mapa (3,3);
		Vehiculo unVehiculo = new Vehiculo();
		mapa.getCeldaEnPos(2, 1).setVehiculo(unVehiculo);
		
		assertEquals (unVehiculo , mapa.getCeldaEnPos(2 , 1).getVehiculo());
	}

	

	
}
