package fiuba.algo3.modelo.vehiculos;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.ContenidoDeCelda;
import fiuba.algo3.modelo.mapa.UbicacionEnMapaException;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.Vehiculo;


public class Conductor extends ContenidoDeCelda{
	
	private boolean encontroLlegada;
	private int penalizacionDeAvance;
	private int movimientos;
	private int alcanceDeVision;
	private Vehiculo vehiculo;
	private Direccion direccion;
	private double id;	
	
	public Conductor(Vehiculo unVehiculo, Direccion unaDireccion, int unAlcanceDeVision){
		super();
		this.encontroLlegada = false;
		this.movimientos = 0;
		this.penalizacionDeAvance = 1;
		this.vehiculo = unVehiculo;
		this.alcanceDeVision = unAlcanceDeVision;
		this.direccion = unaDireccion;
		this.id = Math.random();
	}
	
	@Override
	public void setCelda(Celda unaCelda) throws UbicacionEnMapaException {
		Coordenada coordenadaInicial = unaCelda.getCoordenada();
		if (coordenadaInicial.getX()%2 != 0 || coordenadaInicial.getY()%2 != 0){
			throw new UbicacionEnMapaException();
		}
		this.celda = unaCelda;
	}
	
	public void encontroLlegada(){
		this.encontroLlegada = true;
	}
	
	public boolean getEncontroLlegada(){
		return this.encontroLlegada;
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
	
	private void avanzar(){
		ContenidoDeCelda contenidoVecino = this.getCelda().getVecino(this.getDireccion()).getContenido();
		Interactuable unObjetoEncontrable = (Interactuable) contenidoVecino;
			
		if (unObjetoEncontrable == null){
			this.desplazarseASiguienteEsquina(this.getDireccion());
		}
		else{
			if (this.getVehiculo().meDejanPasar(unObjetoEncontrable)) {
				this.desplazarseASiguienteEsquina(this.getDireccion());
			}
			this.getVehiculo().interactuar(unObjetoEncontrable, this);
		}
	}
	
	public void avanzarEnDireccion(Direccion unaDireccion) {
		/*
		 * Si el conductor no esta mirando en la direccion en la que desea avanzar
		 * se va a re orientar en esa direccion.
		 * En cambio, si el conductor ya estaba orientado hacia la direccion que desea avanzar
		 * entonces efectivamente va a avanzar.
		 */
		
		System.out.println(this.id);
		if (this.getDireccion().equals(unaDireccion))
			this.avanzar();
		else
			this.girarEnDireccion(unaDireccion);
		
		//Hago update de la vista porque se movio (o intento moverse) el conductor
		this.setChanged();
		this.notifyObservers();
	}
	
	//Le falta su test
	private void girarEnDireccion(Direccion unaDireccion){
		this.direccion = unaDireccion;
	}
	
	//Le falta su test
	public Direccion getDireccion(){
		return this.direccion;
	}

	public double getID() {
		return this.id;
	}
	
}