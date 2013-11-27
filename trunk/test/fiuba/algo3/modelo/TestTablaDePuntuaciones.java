package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestTablaDePuntuaciones {

	@Test
	public void testTablaDePosicionesDeberiarCrearseVacia(){
		TablaDePuntuaciones unaTablaDePuntuaciones = new TablaDePuntuaciones();
		Assert.assertEquals(0, unaTablaDePuntuaciones.size());
	}

	@Test
	public void testTablaDePosicionesDeberiarEstarOrdenadaDeMayorPuntajeAMenorPuntaje(){
		TablaDePuntuaciones unaTablaDePuntuaciones = new TablaDePuntuaciones();
		ElementoTablaDePuntuacion e1 = new ElementoTablaDePuntuacion(new Usuario("Juan"), 100);
		ElementoTablaDePuntuacion e2 = new ElementoTablaDePuntuacion(new Usuario("Mauro"), 50);
		ElementoTablaDePuntuacion e3 = new ElementoTablaDePuntuacion(new Usuario("Manuel"), 10);
		unaTablaDePuntuaciones.agregar(e2);
		unaTablaDePuntuaciones.agregar(e1);
		unaTablaDePuntuaciones.agregar(e3);
		
		Assert.assertEquals(e1, unaTablaDePuntuaciones.elementoEn(0));
		Assert.assertEquals(e2, unaTablaDePuntuaciones.elementoEn(1));
		Assert.assertEquals(e3, unaTablaDePuntuaciones.elementoEn(2));
	}
	
}