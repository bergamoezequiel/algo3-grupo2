package fiuba.algo3.implementacion;

import junit.framework.Assert;
import org.junit.Test;

public class EsquinaTest {

	@Test
	public void deberiaRetornarEsquina(){
		Esquina unaEsquina = new Esquina();
        String result = unaEsquina.doEsquina();
        Assert.assertEquals("Esquina", result);
	
	}

}
