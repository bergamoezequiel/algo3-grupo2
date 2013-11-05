package fiuba.algo3.implementacion;

import junit.framework.Assert;
import org.junit.Test;

public class PozoTest {

	@Test
	public void ElPozoTendriaQuePenalizarCon3Movimientos(){
        Pozo unPozo= new Pozo();
        Assert.assertEquals(3, unPozo.obtenerPenalizacion());
	
	}

}