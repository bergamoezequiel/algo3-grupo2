package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;
import fiuba.algo3.implementacion.vehiculos.Vehiculo;

public class CambioDeVehiculo extends Sorpresa {

	public CambioDeVehiculo() {
		super();
	}
	
	@Override
	public void interactuarConMoto(Conductor unConductor) {
		Vehiculo unAuto = new Auto();
		unConductor.cambiarDeVehiculo (unAuto);
	}
	
	@Override
	public void interactuarConAuto(Conductor unConductor) {
		Vehiculo unTodoTerreno = new TodoTerreno();
		unConductor.cambiarDeVehiculo (unTodoTerreno);
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor){
		Vehiculo unaMoto = new Moto();
		unConductor.cambiarDeVehiculo (unaMoto);
       }


	
}


