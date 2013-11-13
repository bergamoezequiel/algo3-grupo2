package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

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
	public void interactuarConMoto(Conductor unConductor) {
		this.aplicarPenalizacion(unConductor);
	}
	
	@Override
	public void interactuarConAuto(Conductor unConductor) {
		this.aplicarPenalizacion(unConductor);
	}	
	
	@Override
	public void interactuarConTodoTerreno(Conductor unConductor){
		this.aplicarPenalizacion(unConductor);
	}	

	@Override
	public boolean dejaPasar(Moto unaMoto) {
		return true;
	}

	@Override
	public boolean dejaPasar(Auto unAuto) {
		return true;
	}

	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno) {
		return true;
	}
}


