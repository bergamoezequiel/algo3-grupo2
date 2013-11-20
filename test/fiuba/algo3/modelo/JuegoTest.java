package fiuba.algo3.modelo;

import static org.junit.Assert.*;


import org.junit.Test;

import fiuba.algo3.modelo.vehiculos.*;

public class JuegoTest {

	@Test
	public void deberiaInicializarseElMapaConCiertasDimensionesYVehiculo() {
		Juego unJuego = new Juego();
		
		assertEquals(11, unJuego.getMapa().getCantidadDeColumnas());
		assertEquals(11, unJuego.getMapa().getCantidadDeFilas());
		
		assertEquals(0, unJuego.getPuntaje());
		
		assertEquals (unJuego.getConductor().getVehiculo(),  new Auto());		
	}
}
