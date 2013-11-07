package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;


public class VehiculoTest {

	@Test
	public void vehiculoDeberiaTener0MovimientosAlCrearse(){
        Mapa unMapa = new Mapa(3,3);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
        Assert.assertEquals(0, unVehiculo.getMovimientos());
	}
	
	@Test
	public void vehiculoAlAvanzarDeberiaAumentarSuMovimientoEnUnoYCambiarSuPosicion(){
        Mapa unMapa = new Mapa(3,3);
		Vehiculo unVehiculo = new Vehiculo(unMapa);
		Posicion posicionInicial = new Posicion(0, 0);
		Posicion posicionFinal = new Posicion(2, 0);
		
		unMapa.setVehiculoEnPosicion(unVehiculo, posicionInicial.getFila(), posicionInicial.getColumna());
		
		Assert.assertEquals(0, unVehiculo.getMovimientos());
		Assert.assertEquals(posicionInicial.getFila(), unMapa.getPosicionDelVehiculo(unVehiculo).getFila());
		Assert.assertEquals(posicionInicial.getColumna(), unMapa.getPosicionDelVehiculo(unVehiculo).getColumna());
		
		unVehiculo.avanzar();
		
		Assert.assertEquals(posicionFinal.getFila(), unMapa.getPosicionDelVehiculo(unVehiculo).getFila());
		Assert.assertEquals(posicionFinal.getColumna(), unMapa.getPosicionDelVehiculo(unVehiculo).getColumna());
        Assert.assertEquals(1, unVehiculo.getMovimientos());
	}
	
}