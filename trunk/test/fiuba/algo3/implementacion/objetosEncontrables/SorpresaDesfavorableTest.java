package fiuba.algo3.implementacion.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class SorpresaDesfavorableTest {
	@Test
	public void testLaSorpresaDesfavorableDeberiaDejarPasarALasMotos(){
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		Moto unaMoto= new Moto();
		Assert.assertEquals(true,unaSorpresaDesfavorable.dejaPasar(unaMoto));
	}
	
	@Test
	public void testLaSorpresaDesfavorableDeberiaDejarPasarALosAutos(){
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		Auto unAuto= new Auto();
		Assert.assertEquals(true,unaSorpresaDesfavorable.dejaPasar(unAuto));
	}
	
	@Test
	public void testLaSorpresaDesfavorableDeberiaDejarPasarALosTodoTerreno(){
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		TodoTerreno unTodoTerreno=new TodoTerreno();
		Assert.assertEquals(true,unaSorpresaDesfavorable.dejaPasar(unTodoTerreno));
	}
	
	@Test
	public void testDeberiaAumentarLosMovimientosDeUnConductor(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto);
		SorpresaDesfavorable unaSorpresaDesfavorable = new SorpresaDesfavorable();
		
		unConductor.aumentarMovimientosEn(8);
		
		unaSorpresaDesfavorable.interactuarCon(unConductor, unAuto);
		Assert.assertEquals(10, unConductor.getMovimientos());
	}


}