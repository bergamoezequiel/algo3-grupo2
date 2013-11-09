package fiuba.algo3.implementacion;

public class CambioDeVehiculo extends Sorpresa {
	
	public CambioDeVehiculo() {
		super();
	}

	public void InteractuarCon(Conductor unConductor, Moto unaMoto) {
		Vehiculo unAuto = new Auto();
		unConductor.cambiarDeVehiculo (unAuto);
	}
	
	public void InteractuarCon(Conductor unConductor, Auto unAuto) {
		Vehiculo unTodoTerreno = new TodoTerreno();
		unConductor.cambiarDeVehiculo (unTodoTerreno);
	}
	
	public void InteractuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
		Vehiculo unaMoto = new Moto();
		unConductor.cambiarDeVehiculo (unaMoto);
       }

	}


