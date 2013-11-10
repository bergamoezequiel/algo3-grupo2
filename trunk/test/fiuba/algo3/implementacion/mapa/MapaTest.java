package fiuba.algo3.implementacion.mapa;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.Mapa;

public class MapaTest {
	@Test
	public void testDeberiaPoderCrearUnMapaConCiertaDimension(){
		Mapa unMapa = new Mapa(new Coordenada(4, 3));
		Assert.assertEquals(3, unMapa.getCantidadDeFilas());
		Assert.assertEquals(4, unMapa.getCantidadDeColumnas());
	}
	
	@Test
	public void testDeberiaObtenerCeldaDeUnaCoordenada(){
		Mapa unMapa = new Mapa(new Coordenada(4, 3));
		Celda unaCelda = unMapa.getCeldaEn(new Coordenada(3, 2));
		Assert.assertEquals(new Coordenada(3, 2), unaCelda.getCoordenada());
	}
	
	@Test
	public void testDeberiaSerInvalidaLaCoordenada(){
		Mapa unMapa = new Mapa (new Coordenada (4,4));
		Coordenada unaCoordenada = new Coordenada (5,5);
		Assert.assertEquals (false, unMapa.coordenadaValida(unaCoordenada));
	}
}

/*
Mapa unMapa = new Mapa(3,3);
Celda unaCelda = unMapa.getCeldaEnPosicion(new Posicion(0,0));
Conductor unVehiculo = new Conductor();
unaCelda.setContenido(unVehiculo);
unVehiculo.avanzar(new Derecha());



///Metodo avanzar() de Conductor//
void avanzar(){
cotenidoDeAlLado = celda.getVecino(new Derecha()).getContenido();
if (contenido == null){
	this.moverASiguienteEsquina(derecha);
}
else
{
contenidoDeAlLado.interactuarCon(this, this.getTipoDeVehiculo());
if contenidoDeAlLado.dejaPasar(this) {
			this.moverASiguienteEsquina(derecha);
}
}
}


//interactuarCon (Del Pozo)//
void interactuarCon(Vehicuilo unVehiculo, Moto unaMoto){
	unVehiculo.incrementarMovimientos(this.getPenalizacion());
}

void interactuarCon(Vehicuilo unVehiculo, Auto unAuto){
	unVehiculo.incrementarMovimientos(this.getPenalizacion());
}

void interactuarCon(Vehicuilo unVehiculo, 4x4 una4x4){

}

//Metodo moverASiguienteEsquina de Conductor//
void moverASiguienteEsquina(derecha){
nuevaCelda = unVehiculo.getCelda().getVecinoDerecha().getVecinoDerecha();
	unaCelda.desligarDeSuContenido();
nuevaCelda.setContenido(unVehiculo);
this.incrementarMovimientosEn(this.getPenalizacionDeAvance());
}
*/