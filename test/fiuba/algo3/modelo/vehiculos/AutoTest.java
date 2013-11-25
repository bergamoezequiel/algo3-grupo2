package fiuba.algo3.modelo.vehiculos;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.coordenadas.Direccion;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.Pozo;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;

public class AutoTest {

	@Test
	public void autoAlAvanzarYEncontrarUnPozoDeberiaPenalizarseCon3MovimientosYDesplazarse2Posiciones(){
		Mapa unMapa = new Mapa(1,1);
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Auto());		
		celdaInicial.agregarContenido(unConductor);
		
		Pozo unPozo = new Pozo();
		Celda celdaDelPozo = unMapa.getCeldaEn(new Coordenada(1, 0));
		celdaDelPozo.agregarContenido(unPozo);
		
		Direccion derecha = new Derecha();
		unConductor.avanzarEnDireccion(derecha);
		//Revisa que se mueva dos posiciones al avanzar.
		Assert.assertEquals(celdaInicial.getVecino(derecha).getVecino(derecha).getCoordenada(), unConductor.getCelda().getCoordenada());
		//Revisa que se penzalice con 3 movimientos por el pozo mas 1 por el avance.
		Assert.assertEquals(unConductor.getPenalizacionDeAvance()+unPozo.obtenerPenalizacion(), unConductor.getMovimientos());
	}
}