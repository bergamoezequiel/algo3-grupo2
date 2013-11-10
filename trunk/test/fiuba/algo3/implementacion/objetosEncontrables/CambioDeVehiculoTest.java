package fiuba.algo3.implementacion.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.objetosEncontrables.CambioDeVehiculo;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
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
	
	@Test
	public void testDeberiaCambiarAutoEnTodoTerreno(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto);
		TodoTerreno unTodoTerreno = new TodoTerreno();
		CambioDeVehiculo unCambioDeVehiculo= new CambioDeVehiculo();
		
		unCambioDeVehiculo.interactuarCon(unConductor, unAuto);
		Assert.assertEquals(unTodoTerreno, unConductor.getVehiculo());
		}
	
	@Test
	public void testDeberiaCambiarMotoEnAuto(){
		Moto unaMoto = new Moto();
		Conductor unConductor = new Conductor(unaMoto);
		Auto unAuto = new Auto();
		CambioDeVehiculo unCambioDeVehiculo= new CambioDeVehiculo();
		
		unCambioDeVehiculo.interactuarCon(unConductor, unaMoto);
		Assert.assertEquals(unAuto, unConductor.getVehiculo());
		}
	
	@Test
	public void testDeberiaCambiarTodoTerrenoEnMoto(){
		TodoTerreno unTodoTerreno = new TodoTerreno();
		Conductor unConductor = new Conductor(unTodoTerreno);
		Moto unaMoto = new Moto();
		CambioDeVehiculo unCambioDeVehiculo= new CambioDeVehiculo();
		
		unCambioDeVehiculo.interactuarCon(unConductor, unTodoTerreno);
		Assert.assertEquals(unaMoto, unConductor.getVehiculo());
		}
}