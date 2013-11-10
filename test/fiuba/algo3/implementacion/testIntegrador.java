package fiuba.algo3.implementacion;

import static org.junit.Assert.*;


import org.junit.Test;

public class testIntegrador {

	@Test
	public void pruebaIntegradora(){
		Mapa unMapa = new Mapa(new Coordenada(10, 10));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto());		
		celdaInicial.agregarContenido(unConductor);
		
		Pozo unPozo = new Pozo();
		Celda celdaDelPozo = unMapa.getCeldaEn(new Coordenada(1, 0));
		celdaDelPozo.agregarContenido(unPozo);
		
		
		Direccion derecha = new Derecha();
		unConductor.avanzarEnDireccion(derecha);
		
		//Revisa que se mueva dos posiciones al avanzar.
		assertEquals(celdaInicial.getVecino(derecha).getVecino(derecha).getCoordenada(), unConductor.getCelda().getCoordenada());
		//Revisa que se penzalice con 3 movimientos por el pozo mas 1 por el avance.
		assertEquals(unConductor.getPenalizacionDeAvance()+unPozo.obtenerPenalizacion(), unConductor.getMovimientos());
		
		//Avanzo otra vez a la derecha.
		Celda celdaActual = unConductor.getCelda();
		unConductor.avanzarEnDireccion(derecha);
		
		//Revisa que se haya movida 2 posiciones mas.
		assertEquals(celdaActual.getVecino(derecha).getVecino(derecha).getCoordenada(), unConductor.getCelda().getCoordenada());
		//Revisa que se penzalice con 3 movimientos por el pozo mas 2 por el avance.
		assertEquals(unConductor.getPenalizacionDeAvance()*2 +unPozo.obtenerPenalizacion(), unConductor.getMovimientos());
		
		//Me muevo para arriba 2 posiciones  ---> irian 4 movimientos + 3 por penalizacion.
		celdaActual = unConductor.getCelda();
		Direccion arriba = new Arriba();
		
		Celda celdaFinal = celdaActual.getVecino(arriba).getVecino(arriba).getVecino(arriba).getVecino(arriba);
		unConductor.avanzarEnDireccion(arriba);
		unConductor.avanzarEnDireccion(arriba);
		
		//Se movio 4 posiciones mas.
		assertEquals(celdaFinal.getCoordenada(), unConductor.getCelda().getCoordenada());
		//4 movimientos comunes + 3 por penalizacion
		assertEquals(unConductor.getPenalizacionDeAvance()*4 +unPozo.obtenerPenalizacion(), unConductor.getMovimientos());
		
		
		//pongo un piquete a la derecha de la posicion actual, que es (4,4).
		Piquete unPiquete = new Piquete();
		celdaActual = unConductor.getCelda();
		Celda celdaDelPiquete  = unMapa.getCeldaEn(new Coordenada (5,4));
		celdaDelPiquete.agregarContenido(unPiquete);
		
		unConductor.avanzarEnDireccion(derecha);
		
		//No se volvio a mover.
		assertEquals(new Coordenada (4,4), unConductor.getCelda().getCoordenada());
		//4 movimientos comunes + 3 por penalizacion
		assertEquals(unConductor.getPenalizacionDeAvance()*4 +unPozo.obtenerPenalizacion(), unConductor.getMovimientos());
		
		
		//Pongo un cambioDeVehiculo a la Izquierda.
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		Celda celdaDelCambioDeVechiulo = unMapa.getCeldaEn(new Coordenada (3,4));
		celdaDelCambioDeVechiulo.agregarContenido(unCambioDeVehiculo);
		celdaActual = unConductor.getCelda();
		
		Direccion izquierda = new Izquierda();
		unConductor.avanzarEnDireccion(izquierda);
		
		//Se deberia mover a la izquierda.
		assertEquals(celdaActual.getVecino(izquierda).getVecino(izquierda).getCoordenada(), unConductor.getCelda().getCoordenada());
		//Deberia haber cambiado mi vehiculo a TodoTerreno.
		assertEquals (unConductor.getVehiculo(), new TodoTerreno());		
												
	}

}
