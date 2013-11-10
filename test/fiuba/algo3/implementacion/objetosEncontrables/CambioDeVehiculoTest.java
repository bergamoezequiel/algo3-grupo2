package fiuba.algo3.implementacion.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.objetosEncontrables.CambioDeVehiculo;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class CambioDeVehiculoTest {
	@Test
	public void ElCambioDeVehiculoDeberiaDejarPasarALasMotos(){
		CambioDeVehiculo unCambioDeVehiculo= new CambioDeVehiculo();
		Moto unaMoto= new Moto();
		Assert.assertEquals(true,unCambioDeVehiculo.dejaPasar(unaMoto));
	}
	
	@Test
	public void ElCambioDeVehiculoDeberiaDejarPasarALosAutos(){
		CambioDeVehiculo unCambioDeVehiculo= new CambioDeVehiculo();
		Auto unAuto= new Auto();
		Assert.assertEquals(true,unCambioDeVehiculo.dejaPasar(unAuto));
	}
	
	@Test
	public void ElCambioDeVehiculoDeberiaDejarPasarALosTodoTerreno(){
		CambioDeVehiculo unCambioDeVehiculo= new CambioDeVehiculo();
		TodoTerreno unTodoTerreno=new TodoTerreno();
		Assert.assertEquals(true,unCambioDeVehiculo.dejaPasar(unTodoTerreno));
	}
}