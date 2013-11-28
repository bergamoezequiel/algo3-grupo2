package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;

public class Llegada extends ObjetoEncontrable implements Interactuable {

	@Override
	public void interactuarConMoto(Conductor unConductor) {
		
	}
	
	@Override
	public void interactuarConAuto(Conductor unConductor) {
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor){
	}

	@Override
	public boolean dejaPasar(Moto unaMoto){
		return false;
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

	
	

