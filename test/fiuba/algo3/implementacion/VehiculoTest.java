package fiuba.algo3.implementacion;

import junit.framework.Assert;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void vehiculoDeberiaTener0MovimientosAlCrearse(){
        Vehiculo unVehiculo= new Vehiculo();
        Assert.assertEquals(0, unVehiculo.obtenerMovimientos());
	
	}

}