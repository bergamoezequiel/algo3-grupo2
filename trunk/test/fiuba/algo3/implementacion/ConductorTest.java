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
		
		Direccion derecha = new Derecha();
		unConductor.avanzarEnDireccion(derecha);
		Assert.assertEquals(celdaInicial.getVecino(derecha).getVecino(derecha).getCoordenada(), unConductor.getCelda().getCoordenada());
	}
}