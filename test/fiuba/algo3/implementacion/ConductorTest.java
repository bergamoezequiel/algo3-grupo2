package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;


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
		/*Direccion arriba = new Arriba ();
		unConductor.avanzarEnDireccion(arriba);
		Assert.assertEquals(new Coordenada (2, 2), unConductor.getCelda().getCoordenada());*/
		
		//Avanza para la izquierda.
		/*Direccion izquierda = new Izquierda ();
		unConductor.avanzarEnDireccion(izquierda);
		Assert.assertEquals (new Coordenada(0, 2) , unConductor.getCelda().getCoordenada());*/
		
		//Avanza para Abajo.
		/*Direccion abajo = new Abajo();
		unConductor.avanzarEnDireccion(abajo);
		Assert.assertEquals (new Coordenada(0, 0) , unConductor.getCelda().getCoordenada());*/
	}
}