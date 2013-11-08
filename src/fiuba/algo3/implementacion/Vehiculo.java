package fiuba.algo3.implementacion;


public class Vehiculo extends ContenidoDeCelda{
	
	private int penalizacionDeAvance;
	private int movimientos;
	private Mapa mapa;
	
	public Vehiculo(Mapa unMapa){
		this.movimientos = 0;
		this.penalizacionDeAvance = 1;
		this.mapa = unMapa;
	}
	
	public int getMovimientos(){
		return this.movimientos;
	}
	
	public void avanzar(){
		Posicion miPosicion = mapa.getPosicionDelVehiculo(this);
		Posicion nuevaPosicion = new Posicion(miPosicion.getFila()+2, miPosicion.getColumna());
		mapa.eliminarVehiculo(this);
		mapa.setVehiculoEnPosicion(this, nuevaPosicion.getFila(), nuevaPosicion.getColumna());
		this.movimientos += this.penalizacionDeAvance;
	}
}