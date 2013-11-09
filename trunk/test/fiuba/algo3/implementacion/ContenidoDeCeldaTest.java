package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class ContenidoDeCeldaTest{

	@Test
	public void testSetterYGetterDelContenidoDeCelda(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(0, 0));
		Pozo unPozo = new Pozo();
		
		Assert.assertNull(unPozo.getCelda());
		
		unPozo.setCelda(unaCelda);		
		Assert.assertEquals(unaCelda, unPozo.getCelda());		
	}
}