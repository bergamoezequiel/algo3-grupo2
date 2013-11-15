package fiuba.algo3.implementacion.vehiculos;

import fiuba.algo3.implementacion.objetosEncontrables.*;

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
