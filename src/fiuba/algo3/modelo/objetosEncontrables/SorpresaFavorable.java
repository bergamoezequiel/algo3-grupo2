package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Conductor;


public class SorpresaFavorable extends Sorpresa {
	double penalizacion;
	
	public SorpresaFavorable() {
		super();
		this.penalizacion = -0.2;
	}

	public void aplicarPenalizacion(Conductor unConductor){
		int penalizacionAAgregar = ((int) Math.floor(unConductor.getMovimientos()*this.penalizacion));
		unConductor.variarMovimientosEn(penalizacionAAgregar);
	}
	
	@Override
	public void interactuarConMoto(Conductor unConductor) {
		aplicarPenalizacion(unConductor);
		this.getCelda().quitarContenido();
	}
	
	@Override
	public void interactuarConAuto(Conductor unConductor) {
		aplicarPenalizacion(unConductor);
		this.getCelda().quitarContenido();
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor){
		aplicarPenalizacion(unConductor);
		this.getCelda().quitarContenido();
	}

	
}


