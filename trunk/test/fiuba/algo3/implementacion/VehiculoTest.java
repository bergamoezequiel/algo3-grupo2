package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void testEquals(){
		Auto unAuto = new Auto();
		Auto otroAuto = new Auto();
		Assert.assertEquals(unAuto, otroAuto);
	}
}