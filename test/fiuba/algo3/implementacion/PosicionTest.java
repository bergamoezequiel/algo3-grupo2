package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class PosicionTest {
	@Test
	public void deberiaCrearUnaPosicionYDevolverSusParametrosCorrectamente(){
		Posicion unaPosicion = new Posicion(2,1);
        Assert.assertEquals(unaPosicion.getFila(), 2);
        Assert.assertEquals(unaPosicion.getColumna(), 1);
	}

}
