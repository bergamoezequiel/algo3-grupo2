package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

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
	}
	
	@Override
	public void interactuarConAuto(Conductor unConductor) {
		aplicarPenalizacion(unConductor);
	}
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor){
		aplicarPenalizacion(unConductor);
	}

	
}


