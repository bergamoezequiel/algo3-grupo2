package fiuba.algo3.modelo.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.CambioDeVehiculo;
import fiuba.algo3.modelo.vehiculos.*;


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
		Mapa unMapa = new Mapa(6,6);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto(), 4);		
		celdaInicial.agregarContenido(unConductor);
		
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		Celda celdaDelCambio = unMapa.getCeldaEn(new Coordenada(0, 1));
		celdaDelCambio.agregarContenido(unCambioDeVehiculo);
		
		//Paso por el Cambio de Vehiculo.
		unConductor.avanzarEnDireccion(new Arriba());
		
		Assert.assertEquals(new TodoTerreno(), unConductor.getVehiculo());
		}
	
	@Test
	public void testDeberiaCambiarMotoEnAuto(){
		
		Mapa unMapa = new Mapa(6,6);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Moto(), 4);		
		celdaInicial.agregarContenido(unConductor);
		
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		Celda celdaDelCambio = unMapa.getCeldaEn(new Coordenada(0, 1));
		celdaDelCambio.agregarContenido(unCambioDeVehiculo);
		
		//Paso por el Cambio de Vehiculo.
		unConductor.avanzarEnDireccion(new Arriba());
		
		Assert.assertEquals(new Auto(), unConductor.getVehiculo());
		}
	
	
	@Test
	public void testDeberiaCambiarTodoTerrenoEnMoto(){
		Mapa unMapa = new Mapa(6,6);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new TodoTerreno(),4);		
		celdaInicial.agregarContenido(unConductor);
		
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		Celda celdaDelCambio = unMapa.getCeldaEn(new Coordenada(0, 1));
		celdaDelCambio.agregarContenido(unCambioDeVehiculo);
		
		//Paso por el Cambio de Vehiculo.
		unConductor.avanzarEnDireccion(new Arriba());
		
		Assert.assertEquals(new Moto(), unConductor.getVehiculo());
		}
}