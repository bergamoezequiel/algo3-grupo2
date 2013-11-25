package fiuba.algo3.modelo.vehiculos;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Moto;

public class VehiculoTest {

	@Test
	public void testEquals(){
		Auto unAuto = new Auto();
		Auto otroAuto = new Auto();
		Assert.assertEquals(unAuto, otroAuto);
	}
	
	@Test
	public void testNotEquals(){
		Auto unAuto = new Auto();
		Moto unaMoto = new Moto();
		Assert.assertFalse(unAuto.equals(unaMoto));
	}
	
	@Test
	public void testDeberiaDevolverFalsoSiComparoUnVehiculoConUnaCoordenada(){
		Auto unAuto = new Auto();
		Coordenada unaCoorde = new Coordenada (1,1);
		
		Assert.assertFalse(unAuto.equals(unaCoorde));		
	}
}