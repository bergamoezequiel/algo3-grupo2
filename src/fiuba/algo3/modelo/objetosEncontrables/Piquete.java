package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;

public class Piquete extends ObjetoEncontrable {
	int penalizacion;

	public Piquete() {
		super();
		this.penalizacion = 2;
	}

	public int obtenerPenalizacion(){
		return this.penalizacion;
	}
	
	@Override
	public void interactuarConMoto(Conductor unConductor) {
		unConductor.variarMovimientosEn(this.obtenerPenalizacion());
	}
	
	@Override
	public void interactuarConAuto(Conductor unConductor) {
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor){
	}

	@Override
	public boolean dejaPasar(Moto unaMoto){
		return true;
	}
	
	@Override
	public boolean dejaPasar(Auto unAuto){
		return false;
	}
	
	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno){
		return false;
	}
}

