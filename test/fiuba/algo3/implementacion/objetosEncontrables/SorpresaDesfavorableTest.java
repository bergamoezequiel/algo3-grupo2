package fiuba.algo3.implementacion.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.objetosEncontrables.CambioDeVehiculo;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class SorpresaDesfavorableTest {
	@Test
	public void LaSorpresaDesfavorableDeberiaDejarPasarALasMotos(){
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		Moto unaMoto= new Moto();
		Assert.assertEquals(true,unaSorpresaDesfavorable.dejaPasar(unaMoto));
	}
	
	@Test
	public void LaSorpresaDesfavorableDeberiaDejarPasarALosAutos(){
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		Auto unAuto= new Auto();
		Assert.assertEquals(true,unaSorpresaDesfavorable.dejaPasar(unAuto));
	}
	
	@Test
	public void LaSorpresaDesfavorableDeberiaDejarPasarALosTodoTerreno(){
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		TodoTerreno unTodoTerreno=new TodoTerreno();
		Assert.assertEquals(true,unaSorpresaDesfavorable.dejaPasar(unTodoTerreno));
	}
}