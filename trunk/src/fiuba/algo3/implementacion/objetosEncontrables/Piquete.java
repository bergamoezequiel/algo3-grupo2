package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class Piquete extends Obstaculo {
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


