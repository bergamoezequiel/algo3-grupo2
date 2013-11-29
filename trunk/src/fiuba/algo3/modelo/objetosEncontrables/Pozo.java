package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;

public class Pozo extends ObjetoEncontrable {
	
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
		unConductor.variarMovimientosEn(this.obtenerPenalizacion());		
	}

	@Override
	public void interactuarConMoto(Conductor unConductor) {
		unConductor.variarMovimientosEn(this.obtenerPenalizacion());		
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor) {

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

