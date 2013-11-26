package fiuba.algo3.modelo.vehiculos;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.Abajo;
import fiuba.algo3.modelo.coordenadas.Arriba;
import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.coordenadas.Direccion;
import fiuba.algo3.modelo.coordenadas.Izquierda;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.UbicacionEnMapaException;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;


public class ConductorTest {
	
	
	@Test(expected = UbicacionEnMapaException.class) 
	public void vehiculoDeberiaLanzarExcepcionSiSeCreaEnCoordenadaImpar(){
		Mapa unMapa = new Mapa(1,1);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(1, 0));
		Conductor unConductor = new Conductor(new Auto(), 4);
		celdaInicial.agregarContenido(unConductor);
	}
	
	@Test
	public void vehiculoDeberiaTener0MovimientosAlCrearse(){
		Conductor unConductor = new Conductor(new Auto(), 4);
		Assert.assertEquals(0, unConductor.getMovimientos());
	}
	
	@Test
	public void vehiculoDeberiaCrearseConUnTipoDeVehiculoAuto(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto, 4);
		Assert.assertEquals(unAuto, unConductor.getVehiculo());
	}
	
	@Test
	public void conductorDeberiaPoderCambiarDeVehiculo(){
		
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto, 4);
		Moto unaMoto= new Moto();
		unConductor.cambiarDeVehiculo(unaMoto);
		Assert.assertEquals(unaMoto, unConductor.getVehiculo());
	}
	@Test
	public void vehiculoDeberiaCrearseConUnaPenalizacionDeAvanceIgualAUno(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto, 4);
		Assert.assertEquals(1, unConductor.getPenalizacionDeAvance());
	}

	@Test (expected = UbicacionEnMapaException.class) 
	public void deberiaLanzarUnaExcepcionSiIntentoAvanzarAUnLugarFueraDelMapa(){
		Mapa unMapa = new Mapa (1,1);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor (new Auto(), 4);
		celdaInicial.agregarContenido(unConductor);
		
		//Avanzo a la derecha
		unConductor.avanzarEnDireccion(new Derecha());
		Assert.assertEquals(new Coordenada(2, 0), unConductor.getCelda().getCoordenada());
		
		//No Deberia Poder moverme y deberia lanzar la excepcion..
		unConductor.avanzarEnDireccion(new Derecha());
		
		//Deberia haberme quedado en el mismo lugar.
		Assert.assertEquals(new Coordenada(2, 0), unConductor.getCelda().getCoordenada());		
		
		
	}
	
	@Test
	public void vehiculoAlAvanzarDeberiaDesplazarseDosPosicionesSiNoSeEncuentraObstaculosOSorpresas(){
		Mapa unMapa = new Mapa(1,1);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto(), 4);		
		celdaInicial.agregarContenido(unConductor);
		
		//Avanza a la derecha.
		Direccion derecha = new Derecha();
		unConductor.avanzarEnDireccion(derecha);
		Assert.assertEquals(new Coordenada (2, 0) , unConductor.getCelda().getCoordenada());
		Assert.assertEquals(new Derecha(), unConductor.getDireccion());
		
		//Avanza para arriba.
		Direccion arriba = new Arriba ();
		unConductor.avanzarEnDireccion(arriba);
		Assert.assertEquals(new Coordenada (2, 2), unConductor.getCelda().getCoordenada());
		Assert.assertEquals(new Arriba(), unConductor.getDireccion());
		
		//Avanza para la izquierda.
		Direccion izquierda = new Izquierda ();
		unConductor.avanzarEnDireccion(izquierda);
		Assert.assertEquals (new Coordenada(0, 2) , unConductor.getCelda().getCoordenada());
		Assert.assertEquals(new Izquierda(), unConductor.getDireccion());

		//Avanza para Abajo.
		Direccion abajo = new Abajo();
		unConductor.avanzarEnDireccion(abajo);
		Assert.assertEquals (new Coordenada(0, 0) , unConductor.getCelda().getCoordenada());
		Assert.assertEquals(new Abajo(), unConductor.getDireccion());

	}
}