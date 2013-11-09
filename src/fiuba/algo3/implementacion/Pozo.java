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
		unConductor.aumentarMovimientosEn(3);
		
	}
	public void InteractuarCon(Conductor unConductor, Auto unAuto) {
		unConductor.aumentarMovimientosEn(3);
	}	
	}


