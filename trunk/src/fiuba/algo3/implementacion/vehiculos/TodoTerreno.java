package fiuba.algo3.implementacion.vehiculos;

import fiuba.algo3.implementacion.objetosEncontrables.ObjetoEncontrable;

public class TodoTerreno extends Vehiculo {

	@Override
	public void interactuar(ObjetoEncontrable unObjetoEncontrable,	Conductor unConductor) {
		unObjetoEncontrable.interactuarConTodoTerreno(unConductor);
	}

	@Override
	public boolean meDejanPasar(ObjetoEncontrable unObjetoEncontrable) {
		return unObjetoEncontrable.dejaPasar(this);
	}

}