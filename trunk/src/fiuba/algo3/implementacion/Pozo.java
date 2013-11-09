package fiuba.algo3.implementacion;

public class Pozo extends Obstaculo {
	int penalizacion;
	
	
	public Pozo() {
		super();
		this.penalizacion = 3;
	}

	public int obtenerPenalizacion(){
		return this.penalizacion;
	}

	public void InteractuarCon(Conductor unConductor, Moto UnaMoto) {
		unConductor.aumentarMovimientosEn(this.penalizacion);
	}
	
	public void InteractuarCon(Conductor unConductor, Auto unAuto) {
		unConductor.aumentarMovimientosEn(this.penalizacion);
	}
	
	public void InteractuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
	}

	public boolean dejaPasar(Moto unaMoto){ 
		return true;
	}
	
	public boolean dejaPasar(Auto unAuto){ 
		return true;
	}
	
	public boolean dejaPasar(TodoTerreno unTodoTerreno){ 
		return true;
	}
}


