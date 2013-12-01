package fiuba.algo3.modelo.vehiculos;

import fiuba.algo3.modelo.objetosEncontrables.*;

public class Moto extends Vehiculo {
	
public static Moto instancia= null;
	
	private Moto(){
		
	}
	
	public static Moto getInstancia(){
		if (instancia==null){
			instancia=new Moto();
		}
		return instancia;
	}
	
	@Override
	public void interactuar(Interactuable unObjetoEncontrable, Conductor unConductor) {
		unObjetoEncontrable.interactuarConMoto(unConductor);
	}

	@Override
	public boolean meDejanPasar(Interactuable unObjetoEncontrable) {
		return unObjetoEncontrable.dejaPasar(this);
	}
}
