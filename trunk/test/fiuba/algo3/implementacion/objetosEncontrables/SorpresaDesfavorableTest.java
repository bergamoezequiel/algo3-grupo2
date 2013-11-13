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
		
		unaSorpresaDesfavorable.interactuarConAuto(unConductor);
		Assert.assertEquals(10, unConductor.getMovimientos());
	}
	
	@Test
	public void deberiaAumentarLosMovimientosDelAutoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(new Coordenada(10, 10));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto());		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaDesfavorable);
		
		//No agarra la sorpresa desfavorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa desfavorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (3 , unConductor.getMovimientos());
	}
	
	@Test
	public void deberiaAumentarLosMovimientosDeLaMotoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(new Coordenada(10, 10));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Moto());		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaDesfavorable);
		
		//No agarra la sorpresa desfavorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa desfavorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (3 , unConductor.getMovimientos());
	}
	
	@Test
	public void deberiaAumentarLosMovimientosDeLaTodoTerrenoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(new Coordenada(10, 10));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new TodoTerreno());		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaDesfavorable unaSorpresaDesfavorable= new SorpresaDesfavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaDesfavorable);
		
		//No agarra la sorpresa desfavorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa desfavorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (3 , unConductor.getMovimientos());
	}


}