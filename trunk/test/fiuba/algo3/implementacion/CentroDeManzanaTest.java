package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class CentroDeManzanaTest {

	@Test
	public void deberiaRetornarCentroDeManzana(){
		CentroDeManzana unCentroDeManzana = new CentroDeManzana();
        String result = unCentroDeManzana.doCentroDeManzana();
        Assert.assertEquals("CentroDeManzana", result);
	
	}

}
