package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class PozoTest {
	@Ignore
	@Test
	public void ElPozoTendriaQuePenalizarCon3Movimientos(){
        Pozo unPozo= new Pozo();
        Assert.assertEquals(3, unPozo.obtenerPenalizacion());
	
	}

}