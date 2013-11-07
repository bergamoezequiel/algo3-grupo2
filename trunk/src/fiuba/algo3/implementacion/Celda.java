package fiuba.algo3.implementacion;

public class Celda{
	
	private Vehiculo vehiculo;
	
	public Celda(){
		this.vehiculo = null;
	}
	
	public Vehiculo getVehiculo () {
		return this.vehiculo;
	}
	
	public void setVehiculo(Vehiculo unVehiculo) {
		this.vehiculo = unVehiculo;
	}

	public void eliminarVehiculo() {
		this.vehiculo = null;
	}
}