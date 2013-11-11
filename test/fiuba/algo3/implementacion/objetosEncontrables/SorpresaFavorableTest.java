package fiuba.algo3.implementacion.objetosEncontrables;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.coordenadas.Derecha;
import fiuba.algo3.implementacion.coordenadas.Direccion;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class SorpresaFavorableTest {
	@Test
	public void testLaSorpresaFavorableDeberiaDejarPasarALasMotos(){
		SorpresaFavorable unaSorpresaFavorable= new SorpresaFavorable();
		Moto unaMoto= new Moto();
		Assert.assertEquals(true,unaSorpresaFavorable.dejaPasar(unaMoto));
	}
	
	@Test
	public void testLaSorpresaFavorableDeberiaDejarPasarALosAutos(){
		SorpresaFavorable unaSorpresaFavorable= new SorpresaFavorable();
		Auto unAuto= new Auto();
		Assert.assertEquals(true,unaSorpresaFavorable.dejaPasar(unAuto));
	}
	
	@Test
	public void testLaSorpresaFavorableDeberiaDejarPasarALosTodoTerreno(){
		SorpresaFavorable unaSorpresaFavorable= new SorpresaFavorable();
		TodoTerreno unTodoTerreno=new TodoTerreno();
		Assert.assertEquals(true,unaSorpresaFavorable.dejaPasar(unTodoTerreno));
	}
	
	@Test
	public void testDeberiaDisminuirLosMovimientosDeUnConductor(){
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto);
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		
		unConductor.aumentarMovimientosEn(8);
		
		unaSorpresaFavorable.interactuarConAuto(unConductor);
		Assert.assertEquals(6, unConductor.getMovimientos());
	}
	
	@Test
	public void testDeberiaDisminuirLosMovimientosDelAutoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(new Coordenada(10, 10));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto());		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaFavorable unaSorpresaFavorable= new SorpresaFavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaFavorable);
		
		//No agarra la sorpresa desfavorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa desfavorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (1 , unConductor.getMovimientos());
	}
	
	@Test
	public void testDeberiaDisminuirLosMovimientosDeLaMotoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(new Coordenada(10, 10));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Moto());		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaFavorable unaSorpresaFavorable= new SorpresaFavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaFavorable);
		
		//No agarra la sorpresa desfavorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa desfavorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (1 , unConductor.getMovimientos());
	}
	
	public void testDeberiaDisminuirLosMovimientosDeLaTodoTerrenoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(new Coordenada(10, 10));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new TodoTerreno());		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaFavorable unaSorpresaFavorable= new SorpresaFavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaFavorable);
		
		//No agarra la sorpresa desfavorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa desfavorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (1 , unConductor.getMovimientos());
	}

}