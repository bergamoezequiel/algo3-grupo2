package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Conductor;

public class SorpresaDesfavorable extends Sorpresa {
	double penalizacion;
	
	public SorpresaDesfavorable() {
		super();
		this.penalizacion = 0.25;
	}
	
	public void aplicarPenalizacion(Conductor unConductor){
		int penalizacionAAgregar = ((int) Math.ceil(unConductor.getMovimientos()*this.penalizacion));
		unConductor.variarMovimientosEn(penalizacionAAgregar);
	}

	@Override
	public void interactuarConAuto(Conductor unConductor) {
		aplicarPenalizacion(unConductor);
	}

	@Override
	public void interactuarConMoto(Conductor unConductor) {
		aplicarPenalizacion(unConductor);
	}

	@Override
	public void interactuarConTodoTerreno(Conductor unConductor) {
		aplicarPenalizacion(unConductor);
	}


}


