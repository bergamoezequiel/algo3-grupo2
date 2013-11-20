package fiuba.algo3.implementacion.mapa;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;
import fiuba.algo3.implementacion.objetosEncontrables.Pozo;

public class ContenidoDeCeldaTest{

	@Test
	public void testSetterYGetterDelContenidoDeCelda(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 0));
		Pozo unPozo = new Pozo();
		
		Assert.assertNull(unPozo.getCelda());
		
		unPozo.setCelda(unaCelda);		
		Assert.assertEquals(unaCelda, unPozo.getCelda());		
	}
}