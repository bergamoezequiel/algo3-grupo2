package fiuba.algo3.implementacion;


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
	
	public void avanzarEnDireccion(Direccion unaDireccion) {
		Celda celdaInicial = this.getCelda();
		celdaInicial.quitarContenido();
		Celda celdaFinal = celdaInicial.getVecino(unaDireccion).getVecino(unaDireccion);
		celdaFinal.agregarContenido(this);
		
		this.aumentarMovimientosEn(this.getPenalizacionDeAvance());
	}
	
}