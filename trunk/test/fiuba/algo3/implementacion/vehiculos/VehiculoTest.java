package fiuba.algo3.implementacion.vehiculos;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.vehiculos.Auto;

public class VehiculoTest {

	@Test
	public void testEquals(){
		Auto unAuto = new Auto();
		Auto otroAuto = new Auto();
		Assert.assertEquals(unAuto, otroAuto);
	}
}