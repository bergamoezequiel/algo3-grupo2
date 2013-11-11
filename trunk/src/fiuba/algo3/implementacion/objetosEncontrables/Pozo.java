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
	public void interactuarConAuto(Conductor unConductor) {
		unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
	}

	@Override
	public void interactuarConMoto(Conductor unConductor) {
		unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor) {
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


