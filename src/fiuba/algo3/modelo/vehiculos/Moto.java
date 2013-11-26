package fiuba.algo3.modelo.vehiculos;

import fiuba.algo3.modelo.objetosEncontrables.*;

public class Moto extends Vehiculo {
	
	@Override
	public void interactuar(Interactuable unObjetoEncontrable, Conductor unConductor) {
		unObjetoEncontrable.interactuarConMoto(unConductor);
	}

	@Override
	public boolean meDejanPasar(Interactuable unObjetoEncontrable) {
		return unObjetoEncontrable.dejaPasar(this);
	}
}
