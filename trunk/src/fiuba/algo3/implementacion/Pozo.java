package fiuba.algo3.implementacion;

public class Pozo implements Obstaculo {
	int movimientos;
	
	
	public Pozo() {
		this.movimientos=3;
	}

	public int obtenerPenalizacion(){
		return this.movimientos;
	}
	
	}


