package fiuba.algo3.implementacion;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.Posicion;

public class PosicionTest {
	@Test
	public void testDeberiaCrearUnaPosicionYDevolverSusParametrosCorrectamente(){
		Posicion unaPosicion = new Posicion(2,1);
        assertEquals(unaPosicion.getFila(), 2);
        assertEquals(unaPosicion.getColumna(), 1);
	}
	
	@Test
	public void testDeberiaPoderModificarUnaPosicion(){
		Posicion unaPosicion = new Posicion (0,0);
		unaPosicion.setColumna(2);
		unaPosicion.setFila(2);
		
		assertEquals (unaPosicion.getColumna() , 2);
		assertEquals (unaPosicion.getFila() , 2);
		
	}

}
