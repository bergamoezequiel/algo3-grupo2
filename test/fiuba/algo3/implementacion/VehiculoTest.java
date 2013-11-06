package fiuba.algo3.implementacion;

import junit.framework.Assert;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void vehiculoDeberiaTener0MovimientosAlCrearse(){
        Vehiculo unVehiculo= new Vehiculo();
        Assert.assertEquals(0, unVehiculo.getMovimientos());
	}
	
	@Test
	public void vehiculoAlAvanzarDeberiaAumentarSusMovimientosEnUno(){
		Vehiculo unVehiculo = new Vehiculo();
		Assert.assertEquals(0, unVehiculo.getMovimientos());
		unVehiculo.avanzar();
        Assert.assertEquals(1, unVehiculo.getMovimientos());
	
	}

}