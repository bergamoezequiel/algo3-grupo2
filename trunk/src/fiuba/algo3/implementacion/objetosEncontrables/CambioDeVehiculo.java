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
	public void interactuarCon(Conductor unConductor, Moto unaMoto) {
		Vehiculo unAuto = new Auto();
		unConductor.cambiarDeVehiculo (unAuto);
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, Auto unAuto) {
		Vehiculo unTodoTerreno = new TodoTerreno();
		unConductor.cambiarDeVehiculo (unTodoTerreno);
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
		Vehiculo unaMoto = new Moto();
		unConductor.cambiarDeVehiculo (unaMoto);
       }


	@Override
	public boolean dejaPasar(Moto unaMoto) {
		return true;
	}


	@Override
	public boolean dejaPasar(Auto unAuto) {
		return true;
	}


	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno) {
		return true;
	}
}

