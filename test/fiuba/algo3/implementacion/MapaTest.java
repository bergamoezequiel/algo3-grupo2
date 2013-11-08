package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;




public class MapaTest {
	@Test
	public void testDeberiaPoderCrearUnMapaConCiertaDimension(){
		Mapa unMapa = new Mapa(4, 3);
		Assert.assertEquals(4, unMapa.getCantidadDeFilas());
		Assert.assertEquals(3, unMapa.getCantidadDeColumnas());
	}
	
	@Test
	public void testDeberiaObtenerCeldaDeUnaPosicion(){
		Mapa unMapa = new Mapa(4, 3);
		Celda unaCelda = unMapa.getCeldaEnPosicion(new Posicion(3,2));
		Assert.assertEquals(unaCelda.getPosicion() , new Posicion(3,2));
	}	
	
	/*@Ignore
	@Test 
	public void testAlCrearUnMapaDeberiaTenerTodasLasCeldasSinObjetos(){
		Mapa unMapa = new Mapa (5,3);
		for (int i = 0; i < unMapa.getCantidadDeFilas(); i++) {
			for (int j = 0; j < unMapa.getCantidadDeColumnas(); j++) {
				Assert.assertEquals (null, unMapa.getObjetoEnPosicion(i, j));
			}			
		}
							
	}
	
	@Ignore
	@Test
	public void testDeberiaPoderPonerUnVehiculoEnUnaCeldaDelMapa(){
		Mapa unMapa = new Mapa (3,2);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		unMapa.setVehiculoEnPosicion(unVehiculo, 1, 0);
		
		Assert.assertEquals (unVehiculo, unMapa.getVehiculoEnPosicion(1, 0));
	}
	
	@Ignore
	@Test
	public void testGetVehiculoEnPosicion(){
		Mapa unMapa = new Mapa (3,3);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		unMapa.setVehiculoEnPosicion(unVehiculo, 2, 2);
		
		Assert.assertEquals(unMapa.getVehiculoEnPosicion(0,0), null);
		Assert.assertEquals(unMapa.getVehiculoEnPosicion(2,2), unVehiculo);		
	}
	
	@Ignore
	@Test
	public void testDeberiaDevolverLaPosicionDelAuto(){
		Mapa unMapa = new Mapa (3,3);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		
		unMapa.setVehiculoEnPosicion(unVehiculo, 2, 1);
		
		Assert.assertEquals(unMapa.getPosicionDelVehiculo(unVehiculo).getFila(), 2);
		Assert.assertEquals(unMapa.getPosicionDelVehiculo(unVehiculo).getColumna(), 1);
	}
	
	@Ignore
	@Test
	public void testDeberiaPoderEliminarUnVehiculoDelMapa (){
		Mapa unMapa = new Mapa (3,2);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		unMapa.setVehiculoEnPosicion(unVehiculo, 1, 0);
		
		Assert.assertEquals (unVehiculo, unMapa.getVehiculoEnPosicion(1, 0));
		
		unMapa.eliminarVehiculo(unVehiculo);
		Assert.assertEquals(null, unMapa.getVehiculoEnPosicion(1, 0));
	}

*/	
}

