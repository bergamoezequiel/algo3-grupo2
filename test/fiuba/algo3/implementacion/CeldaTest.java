package fiuba.algo3.implementacion;

import junit.framework.Assert;
import org.junit.Test;

public class CeldaTest {

	@Test
	public void deberiaRetornarCelda(){
        Celda unaCelda = new Celda();
        String result = unaCelda.doCelda();
        Assert.assertEquals("Celda", result);
	
	}

}
