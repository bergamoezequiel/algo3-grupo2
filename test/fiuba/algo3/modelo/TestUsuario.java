package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class TestUsuario {
	@Test
	public void testGetUsuario(){
		Usuario unUsuario = new Usuario("Juan");
		Assert.assertEquals("Juan", unUsuario.getNombre());	
	}
}