package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class SorpresaDesfavorable extends Sorpresa {
	double penalizacion;
	
	public SorpresaDesfavorable() {
		super();
		this.penalizacion = 0.2;
	}
	
	
	/*
	 * En caso de que el producto de los movimientos con el porcentaje de la penalizacion
	 * sea menor a 1, se le agrega siempre 1 movimiento extra.
	 */
	@Override
	public void interactuarCon(Conductor unConductor, Moto unaMoto) {
		int penalizacionAAgregar = ((int) Math.round(unConductor.getMovimientos()*this.penalizacion));
		
		if (penalizacionAAgregar < 1){
			unConductor.aumentarMovimientosEn (1);
		} else{
			unConductor.aumentarMovimientosEn (penalizacionAAgregar);
		}
	}
	

	
	/*
	 * En caso de que el producto de los movimientos con el porcentaje de la penalizacion
	 * sea menor a 1, se le agrega siempre 1 movimiento extra.
	 */
	@Override
	public void interactuarCon(Conductor unConductor, Auto unAuto) {
		int penalizacionAAgregar = ((int) Math.round(unConductor.getMovimientos()*this.penalizacion));
		
		if (penalizacionAAgregar < 1){
			unConductor.aumentarMovimientosEn (1);
		} else{
			unConductor.aumentarMovimientosEn (penalizacionAAgregar);
		}
	}
	
	
	/*
	 * En caso de que el producto de los movimientos con el porcentaje de la penalizacion
	 * sea menor a 1, se le agrega siempre 1 movimiento extra.
	 */
	@Override
	public void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
	/*Redondea el valor a un numero entero*/
		int penalizacionAAgregar = ((int) Math.round(unConductor.getMovimientos()*this.penalizacion));
		
		if (penalizacionAAgregar < 1){
			unConductor.aumentarMovimientosEn (1);
		} else{
			unConductor.aumentarMovimientosEn (penalizacionAAgregar);
		}
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


