package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class Pozo extends Obstaculo {
	int penalizacion;
	
	
	public Pozo() {
		super();
		this.penalizacion = 3;
	}

	public int obtenerPenalizacion(){
		return this.penalizacion;
	}

	@Override
	public void interactuarCon(Conductor unConductor, Auto unAuto) {
		unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
	}

	@Override
	public void interactuarCon(Conductor unConductor, Moto unaMoto) {
		unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno) {
		unConductor.aumentarMovimientosEn(0);	
	}
	
	@Override
	public boolean dejaPasar(Auto unAuto) {
		return true;
	}

	@Override
	public boolean dejaPasar(Moto unaMoto) {
		return true;
	}

	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno) {
		return true;
	}
}


