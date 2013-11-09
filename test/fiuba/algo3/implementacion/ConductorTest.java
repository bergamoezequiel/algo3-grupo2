package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class ConductorTest {

	@Test
	public void vehiculoDeberiaTener0MovimientosAlCrearse(){
		Conductor unVehiculo = new Conductor(new Auto());
		Assert.assertEquals(0, unVehiculo.getMovimientos());
	}
	
	@Test
	public void vehiculoDeberiaCrearseConUnTipoDeVehiculoAuto(){
		Auto unAuto = new Auto();
		Conductor unVehiculo = new Conductor(unAuto);
		Assert.assertEquals(unAuto, unVehiculo.getVehiculo());
	}
	
	@Test
	public void vehiculoDeberiaCrearseConUnaPenalizacionDeAvanceIgualAUno(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto);
		Assert.assertEquals(1, unConductor.getPenalizacionDeAvance());
	}

	@Test
	public void vehiculoAlAvanzarDeberiaDesplazarseDosPosiciones(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto());		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha = new Derecha();
		unConductor.avanzarEnDireccion(derecha);
		Assert.assertEquals(celdaInicial.getVecino(derecha).getVecino(derecha).getCoordenada(), unConductor.getCelda().getCoordenada());
	}
}