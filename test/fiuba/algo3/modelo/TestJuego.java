package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestJuego {

	@Test
	public void testNoDeberiDejarPonerDosUsuariosConElMismoNombre(){
		Juego unJuego = new Juego();
		Usuario unUsuario = new Usuario("Juan");
		Usuario otroUsuario = new Usuario("Mauro");
		Usuario tercerUsuario = new Usuario("Juan");
		
		
		Assert.assertTrue(unJuego.agregarUsuario(unUsuario));
		Assert.assertTrue(unJuego.agregarUsuario(otroUsuario));
		Assert.assertFalse(unJuego.agregarUsuario(tercerUsuario));
		
		Assert.assertEquals(2, unJuego.getCantidadDeUsuarios());	
	}
	
	@Test
	public void deberiaAvisarmeSiSePudoCrearUnUsuarioConElNombreDado(){
		Juego unJuego = new Juego();
		Assert.assertTrue(unJuego.agregarUsuario(new Usuario("A")));
		
		//Agrego un usuario que no existía antes.
		Assert.assertTrue( unJuego.agregarUsuario(new Usuario("Manuel")));
		
		//Intento agregar un usuario con un nombre que ya existe.
		Assert.assertTrue( unJuego.agregarUsuario(new Usuario("Pedro")));
	}
	
	

}