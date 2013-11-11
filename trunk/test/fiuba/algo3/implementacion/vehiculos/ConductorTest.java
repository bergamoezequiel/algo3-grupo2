package fiuba.algo3.implementacion.vehiculos;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Abajo;
import fiuba.algo3.implementacion.coordenadas.Arriba;
import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.coordenadas.Derecha;
import fiuba.algo3.implementacion.coordenadas.Direccion;
import fiuba.algo3.implementacion.coordenadas.Izquierda;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;


public class ConductorTest {

	@Test
	public void vehiculoDeberiaTener0MovimientosAlCrearse(){
		Conductor unConductor = new Conductor(new Auto());
		Assert.assertEquals(0, unConductor.getMovimientos());
	}
	
	@Test
	public void vehiculoDeberiaCrearseConUnTipoDeVehiculoAuto(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto);
		Assert.assertEquals(unAuto, unConductor.getVehiculo());
	}
	
	@Test
	public void conductorDeberiaPoderCambiarDeVehiculo(){
		
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto);
		Moto unaMoto= new Moto();
		unConductor.cambiarDeVehiculo(unaMoto);
		Assert.assertEquals(unaMoto, unConductor.getVehiculo());
	}
	@Test
	public void vehiculoDeberiaCrearseConUnaPenalizacionDeAvanceIgualAUno(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto);
		Assert.assertEquals(1, unConductor.getPenalizacionDeAvance());
	}

	@Test
	public void vehiculoAlAvanzarDeberiaDesplazarseDosPosicionesSiNoSeEncuentraObstaculosOSorpresas(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto());		
		celdaInicial.agregarContenido(unConductor);
		
		//Avanza a la derecha.
		Direccion derecha = new Derecha();
		unConductor.avanzarEnDireccion(derecha);
		Assert.assertEquals(new Coordenada (2, 0) , unConductor.getCelda().getCoordenada());

		//Avanza para arriba.
		Direccion arriba = new Arriba ();
		unConductor.avanzarEnDireccion(arriba);
		Assert.assertEquals(new Coordenada (2, 2), unConductor.getCelda().getCoordenada());
		
		//Avanza para la izquierda.
		Direccion izquierda = new Izquierda ();
		unConductor.avanzarEnDireccion(izquierda);
		Assert.assertEquals (new Coordenada(0, 2) , unConductor.getCelda().getCoordenada());
		
		//Avanza para Abajo.
		Direccion abajo = new Abajo();
		unConductor.avanzarEnDireccion(abajo);
		Assert.assertEquals (new Coordenada(0, 0) , unConductor.getCelda().getCoordenada());
	}
}