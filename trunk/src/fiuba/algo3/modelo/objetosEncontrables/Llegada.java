package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;
import fiuba.algo3.modelo.*;

public class Llegada extends ObjetoEncontrable implements Interactuable {

	public Nivel nivelActual;
	
	public Llegada(){
		
	}
	
	public Llegada(Nivel nivel){
		this.nivelActual=nivel;
	}
	@Override
	public void interactuarConMoto(Conductor unConductor) {
		nivelActual.vehiculoCruzoLaMeta();
	}
	
	@Override
	public void interactuarConAuto(Conductor unConductor) {
		nivelActual.vehiculoCruzoLaMeta();
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor){
		nivelActual.vehiculoCruzoLaMeta();
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

	
	

