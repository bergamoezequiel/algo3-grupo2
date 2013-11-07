package fiuba.algo3.implementacion;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class MapaTest {
	@Test
	public void testDeberiaPoderCrearUnMapaConCiertaDimension(){
		Mapa unMapa = new Mapa(4, 3);
		assertEquals(4, unMapa.getCantidadDeFilas());
		assertEquals(3, unMapa.getCantidadDeColumnas());
	}
	
	@Test 
	public void testAlCrearUnMapaDeberiaTenerTodasLasCeldasSinVehiculos(){
		Mapa unMapa = new Mapa (5,3);
		for (int i = 0; i < unMapa.getCantidadDeFilas(); i++) {
			for (int j = 0; j < unMapa.getCantidadDeColumnas(); j++) {
				assertEquals (null, unMapa.getVehiculoEnPosicion(i, j));
			}			
		}
							
	}
	
	@Test
	public void testDeberiaPoderPonerUnVehiculoEnUnaCeldaDelMapa(){
		Mapa unMapa = new Mapa (3,2);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		unMapa.setVehiculoEnPosicion(unVehiculo, 1, 0);
		
		assertEquals (unVehiculo, unMapa.getVehiculoEnPosicion(1, 0));
	}
	
	@Test
	public void testGetVehiculoEnPosicion(){
		Mapa unMapa = new Mapa (3,3);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		unMapa.setVehiculoEnPosicion(unVehiculo, 2, 2);
		
		assertEquals(unMapa.getVehiculoEnPosicion(0,0), null);
		assertEquals(unMapa.getVehiculoEnPosicion(2,2), unVehiculo);		
	}
	
	@Test
	public void testDeberiaDevolverLaPosicionDelAuto(){
		Mapa unMapa = new Mapa (3,3);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		
		unMapa.setVehiculoEnPosicion(unVehiculo, 2, 1);
		
		assertEquals(unMapa.getPosicionDelVehiculo(unVehiculo).getFila(), 2);
		assertEquals(unMapa.getPosicionDelVehiculo(unVehiculo).getColumna(), 1);
	}
	
	/*@Ignore
	@Test(expected=UbicacionEnMapaExcepcion.class)
	public void testDeberiaLanzarExcepcionAlUbicarVehiculoFueraDeRango(){
		Mapa unMapa = new Mapa(3,4);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		try{
			unMapa.setVehiculoEnPosicion(unVehiculo, 3, 4);
		}
		catch(UbicacionEnMapaExcepcion e){
			assertEquals(e.getMessage(), "La ubicacion esta fuera del rango del mapa.");
		}

	}*/

	
}
