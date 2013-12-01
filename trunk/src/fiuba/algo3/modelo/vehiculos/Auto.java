package fiuba.algo3.modelo.vehiculos;

import fiuba.algo3.modelo.objetosEncontrables.*;

public class Auto extends Vehiculo {
	
	public static Auto instancia= null;
	
	private Auto(){
		
	}
	public static Auto getInstancia(){
		if (instancia==null){
			instancia=new Auto();
		}
		return instancia;
	}
	@Override
	public void interactuar(Interactuable unObjetoEncontrable, Conductor unConductor) {
		unObjetoEncontrable.interactuarConAuto(unConductor);
	}

	@Override
	public boolean meDejanPasar(Interactuable unObjetoEncontrable) {
		return unObjetoEncontrable.dejaPasar(this);
	}

}
