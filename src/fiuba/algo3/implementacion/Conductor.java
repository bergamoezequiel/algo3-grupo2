package fiuba.algo3.implementacion;

import fiuba.algo3.implementacion.Celda;
import fiuba.algo3.implementacion.ContenidoDeCelda;
import fiuba.algo3.implementacion.Direccion;
import fiuba.algo3.implementacion.Vehiculo;


public class Conductor extends ContenidoDeCelda{
	
	private int penalizacionDeAvance;
	private int movimientos;
	private Vehiculo vehiculo;
	
	public Conductor(Vehiculo unVehiculo){
		super();
		this.movimientos = 0;
		this.penalizacionDeAvance = 1;
		this.vehiculo = unVehiculo;
	}
	
	public void cambiarDeVehiculo(Vehiculo unVehiculo){
		this.vehiculo=unVehiculo;
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
	
	public void aumentarMovimientosEn(int unosMovimientos){
		this.movimientos += unosMovimientos;
	}
	
	public void desplazarseASiguienteEsquina(Direccion unaDireccion){
		Celda celdaInicial = this.getCelda();
		celdaInicial.quitarContenido();
		Celda celdaFinal = celdaInicial.getVecino(unaDireccion).getVecino(unaDireccion);
		celdaFinal.agregarContenido(this);
		this.aumentarMovimientosEn(this.getPenalizacionDeAvance());
	}
	
	public void avanzarEnDireccion(Direccion unaDireccion) {
		ContenidoDeCelda contenidoVecino = this.getCelda().getVecino(unaDireccion).getContenido();
		
		if (contenidoVecino == null){
			this.desplazarseASiguienteEsquina(unaDireccion);
		}
		/*else
		{
			contenidoVecino.interactuarCon(this, this.getVehiculo());
			if (contenidoVecino.dejaPasar(this)) {
				this.desplazarseASiguienteEsquina(unaDireccion);
			}
		}*/
	}
	
}