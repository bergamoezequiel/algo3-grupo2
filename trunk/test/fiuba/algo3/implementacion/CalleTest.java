package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class CalleTest {

	@Test
	public void deberiaRetornarCalle(){
        Calle unaCalle = new Calle();
        String result = unaCalle.doCalle();
        Assert.assertEquals("Calle", result);
	
	}

}
