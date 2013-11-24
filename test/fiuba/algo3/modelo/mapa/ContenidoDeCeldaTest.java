package fiuba.algo3.modelo.mapa;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.Pozo;

public class ContenidoDeCeldaTest{

	@Test
	public void testSetterYGetterDelContenidoDeCelda(){
		Mapa unMapa = new Mapa(2,2);
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 0));
		Pozo unPozo = new Pozo();
		
		Assert.assertNull(unPozo.getCelda());
		
		unPozo.setCelda(unaCelda);		
		Assert.assertEquals(unaCelda, unPozo.getCelda());		
	}
}