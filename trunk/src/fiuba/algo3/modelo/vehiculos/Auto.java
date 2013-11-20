package fiuba.algo3.modelo.vehiculos;

import fiuba.algo3.modelo.objetosEncontrables.*;

public class Auto extends Vehiculo {

	@Override
	public void interactuar(Interactuable unObjetoEncontrable,	Conductor unConductor) {
		unObjetoEncontrable.interactuarConAuto(unConductor);
	}

	@Override
	public boolean meDejanPasar(Interactuable unObjetoEncontrable) {
		return unObjetoEncontrable.dejaPasar(this);
	}

}
