package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;
import fiuba.algo3.implementacion.vehiculos.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa {
	int penalizacion;
	
	public SorpresaDesfavorable() {
		super();
		this.penalizacion = 2;
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, Moto unaMoto) {
	
		unConductor.aumentarMovimientosEn (this.penalizacion);
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, Auto unAuto) {
		unConductor.aumentarMovimientosEn (this.penalizacion);
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
		unConductor.aumentarMovimientosEn (this.penalizacion);
       }

	/*No Afecta al Paso de Vehiculos*/
	
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


