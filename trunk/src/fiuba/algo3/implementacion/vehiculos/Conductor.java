package fiuba.algo3.implementacion.vehiculos;

import fiuba.algo3.implementacion.coordenadas.Coordenada;
import fiuba.algo3.implementacion.coordenadas.Direccion;
import fiuba.algo3.implementacion.mapa.Celda;
import fiuba.algo3.implementacion.mapa.ContenidoDeCelda;
import fiuba.algo3.implementacion.mapa.UbicacionEnMapaException;
import fiuba.algo3.implementacion.objetosEncontrables.*;
import fiuba.algo3.implementacion.vehiculos.Vehiculo;


public class Conductor extends ContenidoDeCelda{
	
	private int penalizacionDeAvance;
	private int movimientos;
	private int alcanceDeVision;
	private Vehiculo vehiculo;
	
	public Conductor(Vehiculo unVehiculo){
		super();
		this.movimientos = 0;
		this.penalizacionDeAvance = 1;
		this.vehiculo = unVehiculo;
		this.alcanceDeVision = 4;
	}
	
	@Override
	public void setCelda(Celda unaCelda) throws UbicacionEnMapaException {
		Coordenada coordenadaInicial = unaCelda.getCoordenada();
		if (coordenadaInicial.getX()%2 != 0 || coordenadaInicial.getY()%2 != 0){
			throw new UbicacionEnMapaException();
		}
		this.celda = unaCelda;
	}
	
	public void cambiarDeVehiculo(Vehiculo unVehiculo){
		this.vehiculo = unVehiculo;
	}
	
	public int getMovimientos(){
		return this.movimientos;
	}
	
	public Vehiculo getVehiculo(){
		return this.vehiculo;
	}
	
	public int getPenalizacionDeAvance(){
		return this.penalizacionDeAvance;
	}
	
	public int getAlcanceDeVision(){
		return this.alcanceDeVision;
	}

	public void variarMovimientosEn(int unosMovimientos){
		if ((this.movimientos + unosMovimientos)<=0) {
			this.movimientos=0;
		}
		else{
			this.movimientos += unosMovimientos;
		}
	}
	
	public void desplazarseASiguienteEsquina(Direccion unaDireccion){
		Celda celdaInicial = this.getCelda();
		celdaInicial.quitarContenido();
		Celda celdaFinal = celdaInicial.getVecino(unaDireccion).getVecino(unaDireccion);
		celdaFinal.agregarContenido(this);
		this.variarMovimientosEn(this.getPenalizacionDeAvance());
	}
	
	public void avanzarEnDireccion(Direccion unaDireccion) {
		ContenidoDeCelda contenidoVecino = this.getCelda().getVecino(unaDireccion).getContenido();
		Interactuable unObjetoEncontrable = (Interactuable) contenidoVecino;
		
		if (unObjetoEncontrable == null){
			this.desplazarseASiguienteEsquina(unaDireccion);
		}
		else{			
			if (this.getVehiculo().meDejanPasar(unObjetoEncontrable)) {
				this.desplazarseASiguienteEsquina(unaDireccion);
			}
			this.getVehiculo().interactuar(unObjetoEncontrable, this);
		}
	}
	
}