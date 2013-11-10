package fiuba.algo3.implementacion.vehiculos;

import fiuba.algo3.implementacion.objetosEncontrables.ObjetoEncontrable;

public class Moto extends Vehiculo {
	public void interactuar(ObjetoEncontrable unObjetoEncontrable, Conductor unConductor) {
		unObjetoEncontrable.interactuarCon(unConductor, this);
	}

	public boolean meDejanPasar(ObjetoEncontrable unObjetoEncontrable) {
		return unObjetoEncontrable.dejaPasar(this);
	}
}
