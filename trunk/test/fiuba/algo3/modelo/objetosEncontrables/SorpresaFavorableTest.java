package fiuba.algo3.modelo.objetosEncontrables;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.SorpresaFavorable;
import fiuba.algo3.modelo.vehiculos.*;

public class SorpresaFavorableTest {
	
	@Test
	public void testDeberiaDisminuirLosMovimientosDeLaMotoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(5,5);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Moto(), 4);		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha = new Derecha();
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaFavorable);
		
		
		
		//No agarra la sorpresa favorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa favorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals(1, unConductor.getMovimientos());
	}
	
	@Test
	public void testDeberiaDisminuirLosMovimientosDelAutoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(5,5);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto(), 4);		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaFavorable);
		
		//No agarra la sorpresa favorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa favorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals(1, unConductor.getMovimientos());
	}
	
	@Test
	public void testDeberiaDisminuirLosMovimientosDeLaTodoTerrenoAlPasarPorUnaSorpresa(){
		Mapa unMapa = new Mapa(5,5);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new TodoTerreno(), 4);		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha= new Derecha();
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaFavorable);
		
		//No agarra la sorpresa favorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa favorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (1 , unConductor.getMovimientos());
	}
	
	@Test
	public void testLaSorpresaFavorableDeberiaDejarPasarALasMotos(){
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		Moto unaMoto = new Moto();
		Assert.assertEquals(true, unaSorpresaFavorable.dejaPasar(unaMoto));
	}
	
	@Test
	public void testLaSorpresaFavorableDeberiaDejarPasarALosAutos(){
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		Auto unAuto = new Auto();
		Assert.assertEquals(true, unaSorpresaFavorable.dejaPasar(unAuto));
	}
	
	@Test
	public void testLaSorpresaFavorableDeberiaDejarPasarALosTodoTerreno(){
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		TodoTerreno unTodoTerreno = new TodoTerreno();
		Assert.assertEquals(true, unaSorpresaFavorable.dejaPasar(unTodoTerreno));
	}
	
	@Test
	public void AlPasarPorUnaSopresaEstaDeberiaDesaparecerDelMapa(){
		Mapa unMapa = new Mapa(5,5);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new TodoTerreno(), 4);		
		celdaInicial.agregarContenido(unConductor);
		
		Direccion derecha = new Derecha();
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		Celda celdaFinal = unMapa.getCeldaEn(new Coordenada(3, 0));
		celdaFinal.agregarContenido(unaSorpresaFavorable);
		
		//No agarra la sorpresa favorable todavia.
		unConductor.avanzarEnDireccion(derecha);
		
		//Agarra la sopresa favorable.
		unConductor.avanzarEnDireccion(derecha);
		
		assertEquals (1 , unConductor.getMovimientos());
		
		
		//La sorpresa deberia haber desaparecido.
		assertEquals (null, celdaFinal.getContenido());
		
	}

}