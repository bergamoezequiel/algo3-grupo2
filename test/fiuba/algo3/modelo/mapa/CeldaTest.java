package fiuba.algo3.modelo.mapa;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;

public class CeldaTest{

	@Test
	public void testDeberiaInicializarceLaCeldaSinObjeto(){
		Mapa unMapa = new Mapa(1,1);
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(0,0));
		Assert.assertNull(unaCelda.getContenido());
	}

	@Test
	public void testDeberiaInicializarceLaCeldaEnUnaCoordenada(){
		Mapa unMapa = new Mapa(1,1);
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(1, 2));
		Assert.assertEquals(new Coordenada(1, 2), unaCelda.getCoordenada());
	}
	
	@Test
	public void testDeberiaAgregarUnContenidoALaCelda(){
		Mapa unMapa = new Mapa(1,1);
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(2, 2));		
		Conductor unContenido = new Conductor(new Auto(), 4);
		unaCelda.agregarContenido(unContenido);
		Assert.assertEquals(unContenido, unaCelda.getContenido());
		Assert.assertEquals(unaCelda, unContenido.getCelda());	
	}
	
	@Test
	public void testDeberiaAgregarYLuegoQuitarUnContenidoDeLaCelda(){
		Mapa unMapa = new Mapa(1,1);
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(2, 2));
		Conductor unVehiculo = new Conductor(new Auto(), 4);		
		unaCelda.agregarContenido(unVehiculo);
		
		Assert.assertEquals (unVehiculo, unaCelda.getContenido());
		Assert.assertEquals (unaCelda, unVehiculo.getCelda());
		
		unaCelda.quitarContenido();
		
		Assert.assertNull (unaCelda.getContenido());
		Assert.assertNull (unVehiculo.getCelda());
	}
	
	@Test
	public void testDeberiaDecirmeSiCiertasCeldasSonVisiblesONo(){
		Conductor unConductor = new Conductor(new Auto(), 4);		
		//Creo un mapa con el doble de tamaño del alcance de vision del conductor.
		//Ubico al conductor en el centro del mapa.
		Mapa unMapa = new Mapa(unConductor.getAlcanceDeVision()+1, unConductor.getAlcanceDeVision()+1);
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

