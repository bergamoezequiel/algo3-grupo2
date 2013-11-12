package fiuba.algo3.implementacion.mapa;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;

public class CeldaTest{

	@Test
	public void testDeberiaInicializarceLaCeldaSinObjeto(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(0,0));
		Assert.assertNull(unaCelda.getContenido());
	}

	@Test
	public void testDeberiaInicializarceLaCeldaEnUnaCoordenada(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 2));
		Assert.assertEquals(new Coordenada(1, 2), unaCelda.getCoordenada());
	}
	
	@Test
	public void testDeberiaAgregarUnContenidoALaCelda(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 2));		
		Conductor unContenido = new Conductor(new Auto());
		unaCelda.agregarContenido(unContenido);
		Assert.assertEquals(unContenido, unaCelda.getContenido());
		Assert.assertEquals(unaCelda, unContenido.getCelda());	
	}
	
	@Test
	public void testDeberiaAgregarYLuegoQuitarUnContenidoDeLaCelda(){
		Mapa unMapa = new Mapa(new Coordenada(3, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 2));
		Conductor unVehiculo = new Conductor(new Auto());		
		unaCelda.agregarContenido(unVehiculo);
		
		Assert.assertEquals (unVehiculo, unaCelda.getContenido());
		Assert.assertEquals (unaCelda, unVehiculo.getCelda());
		
		unaCelda.quitarContenido();
		
		Assert.assertNull (unaCelda.getContenido());
		Assert.assertNull (unVehiculo.getCelda());
	}
	
	@Test
	public void testDeberiaDecirmeSiCiertasCeldasSonVisiblesONo(){
		Conductor unConductor = new Conductor(new Auto());		
		//Creo un mapa con el doble de tamaño del alcance de vision del conductor.
		//Ubico al conductor en el centro del mapa.
		Mapa unMapa = new Mapa(new Coordenada(unConductor.getAlcanceDeVision()*2+2, unConductor.getAlcanceDeVision()*2+2));
		Coordenada coordenadaConductor = new Coordenada(unConductor.getAlcanceDeVision(), unConductor.getAlcanceDeVision());
		Celda unaCelda = unMapa.getCeldaEn(coordenadaConductor);
		
		unaCelda.agregarContenido(unConductor);
		
		Celda celdaVisibleDerecha = unMapa.getCeldaEn(coordenadaConductor.sumar(new Coordenada(unConductor.getAlcanceDeVision(), 0)));
		Assert.assertTrue (celdaVisibleDerecha.esVisiblePara(unConductor));	

		Celda celdaVisibleIzquierda = unMapa.getCeldaEn(coordenadaConductor.sumar(new Coordenada(-unConductor.getAlcanceDeVision(), 0)));
		Assert.assertTrue (celdaVisibleIzquierda.esVisiblePara(unConductor));

		Celda celdaVisibleArriba = unMapa.getCeldaEn(coordenadaConductor.sumar(new Coordenada(0, unConductor.getAlcanceDeVision())));
		Assert.assertTrue (celdaVisibleArriba.esVisiblePara(unConductor));

		Celda celdaVisibleAbajo = unMapa.getCeldaEn(coordenadaConductor.sumar(new Coordenada(0, -unConductor.getAlcanceDeVision())));
		Assert.assertTrue (celdaVisibleAbajo.esVisiblePara(unConductor));
		
		//A la celda de la derecha que es visible y esta en el limite miramos una celda mas y deberia ser invisible.
		Celda celdaFueraDeRango = unMapa.getCeldaEn(celdaVisibleDerecha.getCoordenada().sumar(new Coordenada(1,0)));
		Assert.assertFalse (celdaFueraDeRango.esVisiblePara(unConductor));
	}

}

