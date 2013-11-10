package fiuba.algo3.implementacion.vehiculos;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.coordenadas.Derecha;
import fiuba.algo3.implementacion.coordenadas.Direccion;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;
import fiuba.algo3.implementacion.objetosEncontrables.Pozo;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class TodoTerrenoTest {
	@Test
	public void autoAlAvanzarYEncontrarUnPozoDeberiaPenalizarseCon3MovimientosYDesplazarse2Posiciones(){
		Mapa unMapa = new Mapa(new Coordenada(3, 1));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new TodoTerreno());		
		celdaInicial.agregarContenido(unConductor);
		
		Pozo unPozo = new Pozo();
		Celda celdaDelPozo = unMapa.getCeldaEn(new Coordenada(1, 0));
		celdaDelPozo.agregarContenido(unPozo);
		
		Direccion derecha = new Derecha();
		unConductor.avanzarEnDireccion(derecha);
		//Revisa que se mueva dos posiciones al avanzar.
		Assert.assertEquals(celdaInicial.getVecino(derecha).getVecino(derecha).getCoordenada(), unConductor.getCelda().getCoordenada());
		//Revisa que se penzalice con 0 movimientos por el pozo mas 1 por el avance.
		Assert.assertEquals(unConductor.getPenalizacionDeAvance(), unConductor.getMovimientos());
	}
}