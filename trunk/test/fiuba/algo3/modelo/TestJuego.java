package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestJuego {

	@Test
	public void testNoDeberiDejarPonerDosUsuariosConElMismoNombre(){
		Usuario unUsuario = new Usuario("Juan");
		Usuario otroUsuario = new Usuario("Mauro");
		Usuario tercerUsuario = new Usuario("Juan");
		Juego unJuego = new Juego();
		
		unJuego.agregarUsuario(unUsuario);
		unJuego.agregarUsuario(otroUsuario);
		unJuego.agregarUsuario(tercerUsuario);
		
		Assert.assertEquals(2, unJuego.getCantidadDeUsuarios());	
	}
	

}