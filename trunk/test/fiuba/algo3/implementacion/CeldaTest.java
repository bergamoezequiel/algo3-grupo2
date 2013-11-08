package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class CeldaTest{

	@Test
	public void testDeberiaInicializarceLaCeldaSinObjeto(){
		Celda celda = new Celda(new Posicion(2,3));
		Assert.assertNull(celda.getContenido());	
	}
	
	@Test
	public void testDeberiaPonerUnObjetoEnLaCelda(){
		Celda unaCelda = new Celda(new Posicion(2,3));		
		ContenidoDeCelda unObjeto = new ContenidoDeCelda();
		unaCelda.setObjeto(unObjeto);
		Assert.assertEquals(unObjeto, unaCelda.getContenido());	
	}

}

