package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class PosicionTest {
	
	@Test
	public void testDeberiaDevolverSusParametrosCorrectamente(){
		Posicion unaPosicion = new Posicion(2,1);
		Assert.assertEquals(2, unaPosicion.getFila());
		Assert.assertEquals(1, unaPosicion.getColumna());
	}
	
	@Test
	public void testDeberiaSerIgualesDosObjetosPosicionDistintosConSusMismosParametros(){
		Posicion unaPosicion = new Posicion(2,1);
		Posicion otraPosicion = new Posicion(2,1);
		Assert.assertEquals(unaPosicion, otraPosicion);
	}

}
