package fiuba.algo3.implementacion;

import junit.framework.Assert;
import org.junit.Test;

public class MapaTest {

	@Test
	public void doFooShouldReturnFoo(){
        Mapa unMapa = new Mapa();
        String result = unMapa.doMapa();
        Assert.assertEquals("Mapa", result);
	
	}

}
