package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class MotoTest {
	@Test
	public void motoAlAvanzarYEncontrarUnPozoDeberiaPenalizarseCon3MovimientosYDesplazarse2Posiciones(){
		Mapa unMapa = new Mapa(new Coordenada(3, 1));
		Celda celdaInicial = unMapa.getCeldaEn(new Coordenada(0, 0));
		Conductor unConductor = new Conductor(new Moto());		
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