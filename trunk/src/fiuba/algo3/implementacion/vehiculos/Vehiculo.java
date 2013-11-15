package fiuba.algo3.implementacion.vehiculos;

import fiuba.algo3.implementacion.objetosEncontrables.*;

public abstract class Vehiculo{

	@Override
	public boolean equals (Object unObjeto) {
		boolean boEquals = false;
		if (unObjeto instanceof Vehiculo) {
			Vehiculo unVehiculo = (Vehiculo) unObjeto;
			if ( this.getClass() == unVehiculo.getClass()) {
				boEquals = true;
			}
		}
		return boEquals;
	}
	
	public abstract void interactuar(Interactuable unObjetoEncontrable, Conductor unConductor);
	public abstract boolean meDejanPasar(Interactuable unObjetoEncontrable);

}
